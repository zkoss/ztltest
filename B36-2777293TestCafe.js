import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2777293TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2777293TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				Clicks the first button, you shall see only two items left and the
				paging number is 1.
				<separator />
				Clicks the second button, you shall see all items are cleared and
				the paging number is 1.
				<separator />
				<button label="Test new model">
					<attribute name="onClick">
						import org.zkoss.zul.*;
						
					    DefaultTreeNode a = new DefaultTreeNode("a", new ArrayList());
					    DefaultTreeNode b = new DefaultTreeNode("b", new ArrayList());
					    ArrayList rootNodes = new ArrayList();
					    rootNodes.add(a);
					    rootNodes.add(b);
					    DefaultTreeNode root = new DefaultTreeNode(null, rootNodes);
					    DefaultTreeModel m = new DefaultTreeModel(root);
					    tree.setModel(m);
					</attribute>
				</button>
				<button label="Test null model">
					<attribute name="onClick">
					    tree.setModel(null);
					</attribute>
				</button>
				<zscript>
				    import org.zkoss.zktest.test2.tree.BinaryTreeModel;
				    import java.util.*;
				    BinaryTreeModel btm = new BinaryTreeModel(new ArrayList(new org.zkoss.zktest.test2.BigList(1000)));
				</zscript>
				<tree id="tree" mold="paging" pageSize="15" model="&#36;{btm}">
					<attribute name="onCreate">
					    tree.renderItemByPath(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 });
					    tree.renderItemByPath(new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
					    self.getPagingChild().setAutohide(false);
					</attribute>
				</tree>
			</zk>`,
	);
	await t.click(Selector(() => jq('@button[label="Test new model"]')[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("tr.z-treerow").length)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t.click(Selector(() => jq('@button[label="Test null model"]')[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("tr.z-treerow").length)(),
			),
		)
		.eql(ztl.normalizeText("0"));
});
