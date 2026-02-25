import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-1003TestCafe`
	.page`http://localhost:8080/zktest/test2/B60-ZK-1003.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B60-ZK-1003TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(ztl.normalizeText("2"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(".z-panel .z-toolbar-panel").length,
				)(),
			),
			"should see two Toolbar below the 'Panel Content'",
		);
});
