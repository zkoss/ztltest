import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-3260TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3260.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3260TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-datebox-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-calendar-cell:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-datebox-input").val())(),
			),
		)
		.notEql(ztl.normalizeText(""), "");
});
