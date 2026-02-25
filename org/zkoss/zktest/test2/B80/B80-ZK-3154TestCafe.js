import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-3154TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3154.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3154TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-tree-paging-bottom .z-paging").is(":visible"),
			)(),
		)
		.notOk();
});
