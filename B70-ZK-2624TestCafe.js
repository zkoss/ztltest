import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2624TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2624.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2624TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-paging").length)(),
			),
		)
		.eql(ztl.normalizeText("3"));
});
