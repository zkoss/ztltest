package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1608.zul")
class B65_ZK_1608Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
	<zscript><![CDATA[
	import org.zkoss.zul.*;
	import java.util.ArrayList;
	DefaultTreeNode r = new DefaultTreeNode("root",new ArrayList());
	DefaultTreeNode n1 = new DefaultTreeNode("Node 1",new ArrayList());
	DefaultTreeNode n2 = new DefaultTreeNode("Node 2",new ArrayList());
 	DefaultTreeNode n3 = new DefaultTreeNode("Node 3",new ArrayList());
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
		1.click on set Node2 Data, the node 2 label should change to New Node 2, and still has child Node3
		2.if the bug is not fixed, Node 2 will become a Leaf Node. 
	</label>
	<button label="set Node2 Data" onClick='n2.setData("New Node 2")'/>
	<separator/>
	Template Case:
	<tree model="${model}">
		<treecols visible="false">
			<treecol label="Unit"></treecol>
		</treecols>
		<template name="model">
			<treeitem>
				<treerow>
					<treecell label="${each.data}"/>
				</treerow>
			</treeitem>
		</template>
	</tree>
	ItemRenderer Case:
	<tree model="${model}" itemRenderer="${trr}">
		<treecols visible="false">
			<treecol label="Unit"></treecol>
		</treecols>
		<!-- <template name="model">
			<treeitem>
				<treerow>
					<treecell label="${each.data}"/>
				</treerow>
			</treeitem>
		</template> -->
	</tree>
</zk>
    """

    runZTL(zscript,
      () => {
        click(jq(".z-button:contains(set Node2 Data)"))
        waitResponse()
        verifyEquals("the node 2 label should change to New Node 2", jq(".z-treecell:contains(New Node 2)").length(), 2)
        verifyEquals("still has child Node3", jq(".z-treecell:contains(Node 3)").length(), 2)
      })

  }
}
