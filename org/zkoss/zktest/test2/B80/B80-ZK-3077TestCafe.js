import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-3077TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3077.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3077TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-listitem-checkbox")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-listitem-checkbox")[1]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-listitem-checkbox")[2]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-listitem-checkbox")[3]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-listitem-checkbox")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-listitem-checkbox")[1]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-listitem-checkbox")[2]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-listitem-checkbox")[3]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-listitem-focus").length,
	)();
	await t.expect(verifyVariable_cafe_0_0 == 1).ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-listitem-focus")[0].id)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-listitem")[3].id)(),
			),
		);
});
