import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3980TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3980.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3980TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq("@notification").is(":visible"))(),
		)
		.ok("Notification should appear");
	await t
		.expect(await ClientFunction(() => !!jq("#zk_log")[0])())
		.notOk("Should be no javascript error");
	await t.click(Selector(() => jq("@label")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq("@notification").is(":visible"))(),
		)
		.notOk("Notification should disappear");
});
