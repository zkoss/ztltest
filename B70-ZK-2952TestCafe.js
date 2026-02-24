import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2952TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2952.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2952TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.click(Selector(() => jq(".z-textbox")[0]))
		.click(Selector(() => jq("body")[0]))
		.wait(500)
		.click(Selector(() => jq(".z-errorbox").find(".z-errorbox-close")[0]))
		.wait(500);
	await t
		.expect(await ClientFunction(() => jq(".z-errorbox").is(":visible"))())
		.notOk();
});
