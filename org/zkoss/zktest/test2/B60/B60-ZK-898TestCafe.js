import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-898TestCafe`
	.page`http://localhost:8080/zktest/test2/B60-ZK-898.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B60-ZK-898TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(jq(".z-paging").eq(0)).is(":visible"),
			)(),
		)
		.notOk("You should see paging disappeared with Listbox content");
	await t
		.expect(
			await ClientFunction(() =>
				jq(jq(".z-paging").eq(1)).is(":visible"),
			)(),
		)
		.notOk("You should see paging disappeared with Listbox content");
});
