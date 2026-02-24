import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1877051TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1877051TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>Positive intbox can\'t accept "+123" as value but it should be.</n:p>
				<intbox id="myIntbox" constraint="no negative,no zero"/>
			</zk>`,
	);
	await ClientFunction(() => {
		zk.Desktop._dt.$f("myIntbox", true).$n().value = "";
	})();
	if (
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("myIntbox", true))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Desktop._dt.$f("myIntbox", true).$n()));
	await ztl.waitResponse(t);
	await t.pressKey("+ 1 2 3");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("myIntbox", true)).val(),
				)(),
			),
		)
		.notEql(ztl.normalizeText("+123"), "");
});
