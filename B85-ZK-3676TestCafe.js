import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3676TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3676.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3676TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("$green")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq(".z-notification").is(":visible"))(),
		)
		.notOk("Notification should be closed.");
});
