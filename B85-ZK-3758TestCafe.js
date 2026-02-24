import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3758TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3758.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3758TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.waitResponse(t);
	let prevGridHeight_cafe = await ClientFunction(() =>
		jq(".z-grid").height(),
	)();
	await t.hover(Selector(() => jq(".z-column").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-column .z-column-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menuitem.z-menuitem-checkable")[1]));
	await ztl.waitResponse(t);
	await t.hover(Selector(() => jq(".z-column").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-column .z-column-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menuitem.z-menuitem-checkable")[3]));
	await ztl.waitResponse(t);
	let gridHeight_cafe = await ClientFunction(() => jq(".z-grid").height())();
	await t.expect(prevGridHeight_cafe > gridHeight_cafe).ok();
});
