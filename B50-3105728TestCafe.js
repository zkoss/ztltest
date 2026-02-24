import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3105728TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3105728.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3105728TestCafe", async (t) => {
	await ztl.initTest(t);
	if (
		await ClientFunction(
			() =>
				jq(jq(zk.Widget.$(jq(".z-datebox")).$n("real")))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => jq(zk.Widget.$(jq(".z-datebox")).$n("real"))[0]),
		);
	await ztl.waitResponse(t);
	await t.pressKey("1 / 1").click(Selector(() => jq(".z-label")[0]));
	let value_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-datebox")).$n("real")).val(),
	)();
	await t
		.expect(ztl.normalizeText(value_cafe))
		.contains(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-datebox").eq(1)).$n("real")).val(),
				)(),
			),
			"",
		);
});
