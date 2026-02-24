import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1852895TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1852895.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1852895TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(
		Selector(() => jq(zk.Widget.$(jq(".z-combobox")).$n("btn"))[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-comboitem:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.contains(ztl.normalizeText("1"), "");
});
