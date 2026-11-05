import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3925TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3925.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3925TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => zk.Widget.$(jq("@panel")).$n("max")));
	await ztl.waitResponse(t);
	await t
		.click(Selector(() => jq("@button")[0]))
		.click(Selector(() => zk.Widget.$(jq("@panel")).$n("max")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq("@panel")).$n("max")));
	const panel = Selector(() => jq("@panel")[0]);
	await t
		.expect(panel.offsetWidth)
		.eql(400, "the panel should get back its width of 400px");
	await t
		.expect(panel.offsetHeight)
		.eql(300, "the panel should get back its height of 300px");
});
