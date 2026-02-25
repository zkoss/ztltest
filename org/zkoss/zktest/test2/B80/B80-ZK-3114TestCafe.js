import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-3114TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3114.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3114TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@chosenbox")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-chosenbox-option:visible")[3]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@chosenbox")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-chosenbox-option:visible")[1]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@chosenbox")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-chosenbox-option:visible")[2]));
	await ztl.waitResponse(t);
	let chbitem_cafe = await ClientFunction(
		() => jq(".z-chosenbox > .z-chosenbox-item").length,
	)();
	await t.expect(ztl.normalizeText(chbitem_cafe)).eql(ztl.normalizeText("3"));
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	chbitem_cafe = await ClientFunction(
		() => jq(".z-chosenbox > .z-chosenbox-item").length,
	)();
	await t.expect(ztl.normalizeText(chbitem_cafe)).eql(ztl.normalizeText("0"));
});
