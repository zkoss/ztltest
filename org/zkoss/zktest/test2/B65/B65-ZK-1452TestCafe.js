import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1452TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1452.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1452TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("$col")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$col")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$col")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk("Should not see js error message");
});
