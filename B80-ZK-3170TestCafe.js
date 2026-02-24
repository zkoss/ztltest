import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-3170TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3170.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3170TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-icon-caret-down")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-icon-caret-right")[0]));
	await ztl.waitResponse(t);
});
