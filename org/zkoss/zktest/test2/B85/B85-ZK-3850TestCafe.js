import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3850TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3850.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3850TestCafe", async (t) => {
	await ztl.initTest(t);
	let height_cafe = await ClientFunction(() => jq("@row").eq(2).height())();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@row").eq(2).height())(),
			),
		)
		.eql(ztl.normalizeText(height_cafe));
});
