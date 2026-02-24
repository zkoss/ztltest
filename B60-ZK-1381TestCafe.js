import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-1381TestCafe`
	.page`http://localhost:8080/zktest/test2/B60-ZK-1381.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B60-ZK-1381TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-button:contains(Show Busy)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("block"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-apply-mask").css("display"),
				)(),
			),
			"should not be able to edit textbox inside grid",
		);
});
