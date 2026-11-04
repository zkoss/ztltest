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
	const west = Selector(".z-west");
	const noBorderHeight = await west.offsetHeight;
	const noBorderWidth = await west.offsetWidth;
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-west-noborder")[0])())
		.notOk("The west zone should have a border");
	await t
		.expect(west.offsetHeight)
		.eql(
			noBorderHeight,
			"The west zone should keep its height with a border",
		);
	await t
		.expect(west.offsetWidth)
		.eql(
			noBorderWidth,
			"The west zone should keep its width with a border",
		);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-west-noborder")[0])())
		.ok("The west zone should not have a border");
});
