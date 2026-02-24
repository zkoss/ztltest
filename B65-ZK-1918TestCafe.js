import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1918TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1918.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1918TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk("no exception");
});
