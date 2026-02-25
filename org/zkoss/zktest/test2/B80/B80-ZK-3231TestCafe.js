import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-3231TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3231.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3231TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-listitem-checkbox")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-intbox").val())(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t.click(Selector(() => jq(".z-icon-angle-right")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-listitem-checkbox")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-intbox").val())(),
			),
		)
		.eql(ztl.normalizeText("2"));
});
