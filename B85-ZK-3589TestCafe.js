import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3589TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3589.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3589TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@label")[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		zk(jq("$btnBottom")).scrollIntoView();
	})();
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$btnBottom")[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		zk(jq("$btnTop")).scrollIntoView();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("@popup").is(":visible"))())
		.notOk("The popup still appears!");
});
