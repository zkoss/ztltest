import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2165TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2165TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<div>
		should see all tree item is loaded
	</div>
	<zscript><![CDATA[
	int size = 300;
	List l = new ArrayList();
	for (int i = 0; i < size; i++)
		l.add(i);
	ListModel ls = new ListModelList(l);
	List parent = new ArrayList();
	for (int i = 0; i < size; i++) {
		final List children = new ArrayList();
		for (int j = 0; j < size; j++) {
			children.add(new DefaultTreeNode("Child node " + j));
		}
		parent.add(new DefaultTreeNode("Node " + i, children));
	}
	TreeNode root = new DefaultTreeNode("root", parent);
	DefaultTreeModel model = new DefaultTreeModel(root);
]]>
</zscript>
	<window>
		<hlayout>
			<tree hflex="1" height="500px" model="\${model}"
				mold="paging" span="true" pageSize="150">
				<treecols sizable="true">
					<treecol label="Column 1" />
				</treecols>
			</tree>
			<!-- pageSize larger than model size causes error -->
			<tree hflex="1" height="500px" model="\${model}"
				mold="paging" pageSize="300" span="true">
				<treecols sizable="true">
					<treecol label="Column 1" />
				</treecols>
			</tree>
		</hlayout>
	</window>
</zk>`,
	);
	await ztl.doScroll({
		locator: Selector(() => zk.Widget.$(jq(".z-tree")).$n()),
		scrollType: "vertical",
		percent: "1.0",
	});
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-tree").find(".z-treerow:contains(Node 149)")[0],
			)(),
		)
		.ok("should see all tree item is loaded");
	await ztl.doScroll({
		locator: Selector(() => zk.Widget.$(jq(".z-tree").eq(1)).$n()),
		scrollType: "vertical",
		percent: "1.0",
	});
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(".z-tree")
						.eq(1)
						.find(".z-treerow:contains(Node 299)")[0],
			)(),
		)
		.ok("should see all tree item is loaded");
});
