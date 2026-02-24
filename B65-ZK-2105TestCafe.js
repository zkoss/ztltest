import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-2105TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-2105.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-2105TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("$startLongOp")[0]));
	await ztl.waitResponse(t);
	await t.wait(5500);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-label:eq(1)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("true"), "Should see true.");
});
