import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3800TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3800.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3800TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("$btnCheck")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$result").html())(),
			),
		)
		.eql(
			ztl.normalizeText("true"),
			"The height of buttons are not the same.",
		);
});
