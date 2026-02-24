import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2911385TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-2911385.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-2911385TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.hover(Selector(() => jq("@menu > .z-menu-content")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq(".z-menupopup").is(":visible"))())
		.ok();
	await t.click(Selector(() => jq("@menuitem:first")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq(".z-menupopup").is(":visible"))())
		.notOk();
});
