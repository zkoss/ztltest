import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2077989TestCafe`
	.page`http://localhost:8080/zktest/test2/B35-2077989.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B35-2077989TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$win").is(":visible"))(),
			),
		)
		.eql(ztl.normalizeText("true"));
	await t.click(Selector(() => jq("$hidebtn")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$win").is(":visible"))(),
			),
		)
		.eql(ztl.normalizeText("false"));
});
