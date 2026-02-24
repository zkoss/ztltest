import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-2920TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-2920.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-2920TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-chosenbox-input").eq(0)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-chosenbox-item").length)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t.click(Selector(() => jq(".z-chosenbox-option").eq(0)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-chosenbox-item").length)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t.click(Selector(() => jq(".z-window-header")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-chosenbox-item").length)(),
			),
		)
		.eql(ztl.normalizeText("1"));
});
