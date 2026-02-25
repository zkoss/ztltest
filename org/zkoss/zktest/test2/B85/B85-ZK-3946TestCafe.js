import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3946TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3946.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3946TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(
		Selector(() => jq("@button:contains(add tree item):eq(0)")[0]),
	);
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("#zk_log")[0])()).notOk();
	await t.click(
		Selector(() => jq("@button:contains(add tree item):eq(1)")[0]),
	);
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("#zk_log")[0])()).notOk();
	await t.click(Selector(() => jq("@button:contains(open):eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("@listbox").is(":visible"))())
		.ok();
	await t.click(Selector(() => jq("@button:contains(open):eq(1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("@textbox").is(":visible"))())
		.ok();
});
