import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2238TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2238.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2238TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.doScroll({
		locator: Selector(() => jq(".z-tree")[0]),
		scrollType: "vertical",
		percent: "100.0",
	});
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-treerow:contains(99)")).$n("open")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq(".z-tree").is(":visible"))())
		.ok("the tree should not out of view");
});
