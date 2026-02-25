import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B86-ZK-4021TestCafe`
	.page`http://localhost:8080/zktest/test2/B86-ZK-4021.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B86-ZK-4021TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.expect(await ClientFunction(() => !!jq("#zk_log")[0])()).notOk();
});
