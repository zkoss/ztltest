import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3175465TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3175465TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
Please open the treeitem "item" and you should see the treeitem "child item" is appended as its children.
<tree mold="paging">
<treechildren>
<treeitem open="false">
<treerow>
<treecell label="item" />
</treerow>
<treechildren>
<treeitem>
<treerow>
<treecell label="child item" />
</treerow>
</treeitem>
</treechildren>
</treeitem>
</treechildren>
</tree>
</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@treerow").length)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t.click(Selector(() => zk.Widget.$(jq(".z-treerow")).$n("icon")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@treerow").length)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-treerow:eq(1)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("child item"), "");
});
