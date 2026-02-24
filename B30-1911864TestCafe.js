import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1911864TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1911864.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1911864TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq(".z-combobox")).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq(".z-comboitem").is(":visible"))())
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(jq(".z-comboitem")).text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("male"), "");
});
