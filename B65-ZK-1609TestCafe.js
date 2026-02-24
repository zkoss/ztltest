import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1609TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1609.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1609TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-button:contains(close)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq(".z-treerow")).$n("icon")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(
					zk.Widget.$(jq(".z-treerow:contains(Node 2)")).$n("icon"),
				).hasClass("z-tree-close"),
			)(),
		)
		.ok("should see the Node2 is closed, and with a close icon");
});
