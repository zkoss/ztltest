import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2640TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2640.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2640TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.typeText(
		Selector(() => jq(".z-listbox .z-textbox").first()[0]),
		ztl.normalizeText("a"),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.expect("true").ok();
	await t.typeText(
		Selector(() => jq(".z-grid .z-textbox").first()[0]),
		ztl.normalizeText("a"),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.expect("true").ok();
	await t.typeText(
		Selector(() => jq(".z-tree .z-textbox").first()[0]),
		ztl.normalizeText("a"),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.expect("true").ok();
});
