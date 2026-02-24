import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3974TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3974.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3974TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-spinner-down")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-spinner-down")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-spinner-input").val())(),
			),
		)
		.eql(ztl.normalizeText("1"));
});
