import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1076TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1076.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1076TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("$btn")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-tabpanel[style!=none] .z-combobox")[0],
			)(),
		)
		.ok("should see the combobox is shown");
	await t.click(Selector(() => jq("$tab1")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$btn")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-tabpanel[style!=none] .z-combobox")[0],
			)(),
		)
		.ok("should see the combobox is shown");
});
