import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F60-ZK-523TestCafe`
	.page`http://localhost:8080/zktest/test2/F60-ZK-523.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F60-ZK-523TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-listbox:contains(ZK Spring)")[0],
			)(),
		)
		.ok("The listbox should displayed well");
});
