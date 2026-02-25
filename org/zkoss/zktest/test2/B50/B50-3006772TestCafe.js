import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3006772TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3006772.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3006772TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@treecell:contains(1.1.1)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq("@treerow")).$n("icon")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq("@treerow")).$n("icon")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@treecell:contains(1.1.2)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq("tr.z-treerow-selected").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
});
