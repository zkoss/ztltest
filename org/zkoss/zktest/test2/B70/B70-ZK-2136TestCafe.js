import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2136TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2136.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2136TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.drag(
		Selector(() => jq("$item1")[0]),
		2,
		100,
	);
	await ztl.waitResponse(t);
	await t.wait(500);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.contains(
			ztl.normalizeText("true"),
			"the detail text of the paging bar should be updated",
		);
});
