import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2614901TestCafe`
	.page`http://localhost:8080/zktest/test2/B35-2614901.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B35-2614901TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-menu")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("down");
	await ztl.waitResponse(t);
	await t.pressKey("down");
	await ztl.waitResponse(t);
	await t.pressKey("down");
	await ztl.waitResponse(t);
	await t.pressKey("up");
	await ztl.waitResponse(t);
	await t.pressKey("up");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-menuitem-focus").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(
			ztl.normalizeText("New"),
			"The selected item should be 'New'",
		);
});
