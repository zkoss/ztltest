import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3936TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3936.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3936TestCafe", async (t) => {
	await ztl.initTest(t);
	let widthBeforeCloseTree_cafe = await ClientFunction(() =>
		jq("$combo1").width(),
	)();
	await t.click(Selector(() => jq(".z-icon-caret-down")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$combo1").width())(),
			),
		)
		.eql(ztl.normalizeText(widthBeforeCloseTree_cafe));
});
