import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2839TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2839.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2839TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("button").eq(1)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				"hello from global f1()\nhello from global f1()\nhello from local f2()",
			),
		);
});
