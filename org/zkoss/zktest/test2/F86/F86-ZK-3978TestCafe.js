import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F86-ZK-3978TestCafe`
	.page`http://localhost:8080/zktest/test2/F86-ZK-3978.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F86-ZK-3978TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.doScroll({
		locator: Selector(() => jq("@tree")[0]),
		scrollType: "vertical",
		percent: "50.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => jq("@tree")[0]),
		scrollType: "vertical",
		percent: "0.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-tree-icon:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(await ClientFunction(() => getZKLogLineCnt())()),
		)
		.eql(ztl.normalizeText("1"), "OnDataLoading more than once");
});
