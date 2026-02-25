import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B96-ZK-4912TestCafe`
	.page`http://localhost:8080/zktest/test2/B96-ZK-4912.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B96-ZK-4912TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.click(Selector(() => jq(jq("@select"))[0]))
		.click(Selector(() => jq(jq("@select")).find("option")[1]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
});
