import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2978TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2978.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2978TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-caption").eq(1)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-caption").eq(0)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ztl.hasVScrollbar({
				locator: Selector(() => jq(".menuGroupboxContainer div")[0]),
			}),
		)
		.ok();
});
