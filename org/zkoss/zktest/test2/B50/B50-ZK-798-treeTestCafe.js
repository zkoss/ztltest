import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-798-treeTestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-798-tree.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-798-treeTestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		jq("body")[0].scrollTop = 4000;
	})();
	await t.wait(200).click(Selector(() => jq(".z-treerow:contains(199)")[0]));
	await ztl.waitResponse(t);
	await t
		.wait(200)
		.click(Selector(() => jq(".z-button:contains(invalidate)")[0]))
		.wait(200);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("0"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() => jq("body").css("scrollTop"))(),
			),
			"The scrollTop shouldn't move to first listitem after click the button.",
		);
});
