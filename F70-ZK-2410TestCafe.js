import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F70-ZK-2410TestCafe`
	.page`http://localhost:8080/zktest/test2/F70-ZK-2410.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F70-ZK-2410TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ff")) {
		console.log("This issue is ignored in current browser! (ff)");
		return;
	}
	await t.click(Selector(() => jq(".z-paging-input")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("tab enter");
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("2"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-paging-input").val())(),
			),
		);
});
