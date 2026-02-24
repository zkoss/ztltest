import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2862TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2862.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2862TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("$lb").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$lb").eq(0).children().first()[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$lb").eq(0).val())(),
			),
		)
		.eql(ztl.normalizeText("fasfsaf"));
});
