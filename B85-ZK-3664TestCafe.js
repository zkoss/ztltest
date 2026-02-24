import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3664TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3664.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3664TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-combobox-button")[0]));
	await ztl.waitResponse(t);
	let width1_cafe = await ClientFunction(() =>
		jq(".z-combobox-popup.z-combobox-open:eq(0)").width(),
	)();
	await t.click(Selector(() => jq("body")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-combobox-button")[1]));
	await ztl.waitResponse(t);
	let width2_cafe = await ClientFunction(() =>
		jq(".z-combobox-popup.z-combobox-open:eq(0)").width(),
	)();
	await t.click(Selector(() => jq("body")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-combobox-button")[2]));
	await ztl.waitResponse(t);
	let width3_cafe = await ClientFunction(() =>
		jq(".z-combobox-popup.z-combobox-open:eq(0)").width(),
	)();
	await t.click(Selector(() => jq("body")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(width2_cafe))
		.eql(ztl.normalizeText(width1_cafe), "Width should be the same.");
	await t
		.expect(ztl.normalizeText(width3_cafe))
		.eql(ztl.normalizeText(width1_cafe), "Width should be the same.");
});
