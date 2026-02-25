import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2075768TestCafe`
	.page`http://localhost:8080/zktest/test2/B35-2075768.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B35-2075768TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-west-noborder")[0])())
		.ok("The west zone should not have a border");
	let noBorderHeight_cafe = await ClientFunction(() =>
		jq(".z-west-noborder").height(),
	)();
	let noBorderWidth_cafe = await ClientFunction(() =>
		jq(".z-west-noborder").width(),
	)();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	let borderHeight_cafe = await ClientFunction(() =>
		jq(".z-west").height(),
	)();
	let borderWidth_cafe = await ClientFunction(() => jq(".z-west").width())();
	await t
		.expect(await ClientFunction(() => !!jq(".z-west-noborder")[0])())
		.notOk("The west zone should have a border");
	await t
		.expect(noBorderHeight_cafe - borderHeight_cafe == 2)
		.ok(
			"The height of the west zone should be 2 pixels smaller than without the border",
		);
	await t
		.expect(noBorderWidth_cafe - borderWidth_cafe == 2)
		.ok(
			"The width of the west zone should be 2 pixels smaller than without the border",
		);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-west-noborder")[0])())
		.ok("The west zone should not have a border");
});
