import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2626TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2626.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2626TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(".z-tree-body .z-treecell-content").eq(0).outerHeight(),
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(".z-tree-body.z-tree-autopaging .z-treecell-content")
					.eq(0)
					.outerHeight(),
			)(),
		),
		ztl.normalizeText("4"),
	);
});
