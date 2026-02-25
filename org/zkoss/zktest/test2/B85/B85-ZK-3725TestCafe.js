import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3725TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3725.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3725TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.wait(10000);
	await t
		.expect(
			ztl.normalizeText(
				"T1 TaskResult for UI\nT3 TaskResult for UI\nT4 TaskResult for UI",
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
			"error popped",
		);
});
