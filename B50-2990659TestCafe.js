import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2990659TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2990659TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<decimalbox id="db" format="R ##,###,###,###.00"/>`,
	);
	if (
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("db", true))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Desktop._dt.$f("db", true).$n()));
	await ztl.waitResponse(t);
	await t.pressKey("1 1 1 1");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("db", true)).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("R 1,111.00"));
});
