import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3618TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3618.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3618TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-image")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-image")[0])()).notOk();
});
