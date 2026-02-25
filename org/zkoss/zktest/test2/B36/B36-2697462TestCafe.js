import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2697462TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2697462TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				Select an item and un-select it. Now navigate to another page in the
				tree and come back. The un-selected item cannot now be selected,
				this is correct.
				<zscript>
				    import org.zkoss.zktest.test2.tree.BinaryTreeModel;
				    import java.util.*;
				    BinaryTreeModel btm = new BinaryTreeModel(new ArrayList(new org.zkoss.zktest.test2.BigList(1000)));
				    btm.setMultiple(true);
				</zscript>
				<tree id="tree" mold="paging" pageSize="15" model="&#36;{btm}"
					checkmark="true" multiple="true">
					<attribute name="onCreate">
					    tree.renderItemByPath(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 });
					    tree.renderItemByPath(new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
					</attribute>
				</tree>
			</zk>`,
	);
	await t.click(
		Selector(() => jq("@treerow").find(".z-treerow-checkbox:eq(0)")[0]),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq("@treerow").find(".z-treerow-checkbox:eq(0)")[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@paging").find(".z-paging-next")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@paging").find(".z-paging-previous")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq("@treerow:eq(0)").hasClass("z-treerow-selected"),
			)(),
		)
		.notOk();
});
