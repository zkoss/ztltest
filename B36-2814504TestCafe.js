import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2814504TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2814504TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
			First, click
			<button label="change label" onClick=\'i2.label = "test1"\'/>
			and you will see the first treeitem\'s label changed to test1.
			Then, click
			<button label="change label" onClick=\'i1.label = "test2"\'/>
			and you shall see nothing changed. Then, click the previous page
			and you will see the first treeitem is test2.
			
			<tree id="tree" width="400px" mold="paging" pageSize="2"
			onCreate="self.activePage= 1">
			<treecols sizable="true">
			<treecol label="Name" />
			<treecol label="Description" />
			</treecols>
			<treechildren>
			<treeitem>
			<treerow>
			<treecell id="i1" label="Item 1" />
			<treecell label="Item 1 description" />
			</treerow>
			</treeitem>
			<treeitem>
			<treerow>
			<treecell label="Item 2" />
			<treecell label="Item 2 description" />
			</treerow>
			<treechildren>
			<treeitem>
			<treerow>
			<treecell id="i2" label="Item 2.1" />
			</treerow>
			<treechildren>
			<treeitem>
			<treerow>
			<treecell label="Item 2.1.1" />
			</treerow>
			</treeitem>
			<treeitem>
			<treerow>
			<treecell label="Item 2.1.2" />
			</treerow>
			</treeitem>
			</treechildren>
			</treeitem>
			</treechildren>
			</treeitem>
			<treeitem label="Item 3" />
			</treechildren>
			</tree>
			<button label="invalidate" onClick=\'tree.invalidate()\'/>
			</window>`,
	);
	await t.click(
		Selector(() => jq('@window @button[label="change label"]:eq(0)')[0]),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq("$i2")).$n("cave"))
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("test1"), "");
	await t.click(
		Selector(() => jq('@window @button[label="change label"]:eq(1)')[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@paging").find(".z-paging-previous")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq("$i1")).$n("cave"))
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("test2"), "");
});
