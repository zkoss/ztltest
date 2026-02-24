import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1765TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1765TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<zscript><![CDATA[
import org.zkoss.zul.*;
import java.util.ArrayList;
DefaultTreeNode r = new DefaultTreeNode("root",new ArrayList());
DefaultTreeNode n1 = new DefaultTreeNode("Node 1", new ArrayList());
DefaultTreeNode n2 = new DefaultTreeNode("Node 2", new ArrayList());
DefaultTreeNode n3 = new DefaultTreeNode("Node 3", new ArrayList()); 
DefaultTreeNode n4 = new DefaultTreeNode("Node 4"); 
	
r.add(n1);
n1.add(n2);
n2.add(n3); 
n3.add(n4); 
	           
DefaultTreeModel model = new DefaultTreeModel(r);
model.addOpenObject(n1);
model.addOpenObject(n2);
model.addOpenObject(n3);

import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.TreeitemRenderer;
import org.zkoss.zul.Treerow;

public class TestTreeRenderer implements TreeitemRenderer{

	public void render(Treeitem item, Object data, int index) throws Exception{
		final DefaultTreeNode node = (DefaultTreeNode) data;
		final Treerow treeRow = new Treerow();
		item.appendChild(treeRow);
		treeRow.appendChild(new Treecell(node.getData().toString()));
	}
}
TestTreeRenderer trr = new TestTreeRenderer();
]]></zscript>
	<label multiline="true">
		1. click on "add New Child Node", should not produce a NullPointerException
	</label>
	<button label="add New Child Node" onClick=\'n1.add(new DefaultTreeNode("New Child Node"))\'/>
	<separator/>
	Template Case:
	<tree model="\${model}">
		<treecols visible="false">
			<treecol label="Unit"></treecol>
		</treecols>
		<template name="model">
			<treeitem>
				<treerow>
					<treecell label="\${each.data}"/>
				</treerow>
			</treeitem>
		</template>
	</tree>
	ItemRenderer Case:
	<tree model="\${model}" itemRenderer="\${trr}">
		<treecols visible="false">
			<treecol label="Unit"></treecol>
		</treecols>
	</tree>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-button:contains(add)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk("no exception");
});
