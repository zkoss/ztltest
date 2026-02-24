import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-3094TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3094.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3094TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq('.z-button:contains("make smaller")')[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-menubar-left.z-menubar-scrollable")[0],
			)(),
		)
		.ok("Expecting to see menubar left scrollable button, got none");
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-menubar-right.z-menubar-scrollable")[0],
			)(),
		)
		.ok("Expecting to see menubar right scrollable button, got none");
	await t.click(Selector(() => jq('.z-button:contains("produce bug")')[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-menubar-left.z-menubar-scrollable")[0],
			)(),
		)
		.ok("Expecting to see menubar left scrollable button, got none");
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-menubar-right.z-menubar-scrollable")[0],
			)(),
		)
		.ok("Expecting to see menubar right scrollable button, got none");
});
