package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1609.zul")
class B65_ZK_1609Test extends ZTL4ScalaTestCase {

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
	
]]></zscript>
	<label multiline="true">
		1.click close
		2.click Node1 open icon to open it
		3.you should see the Node2 is closed, and with a close icon, if bug is not fixed, you will see Node2 is closed, but has a open icon
	</label>
	<button label="close" onClick='model.clearOpen()'/>
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
</zk>
    """

    runZTL(zscript,
      () => {
        click(jq(".z-button:contains(close)"))
        waitResponse()
        click(jq(".z-treerow").toWidget().$n("icon"))
        waitResponse()
        verifyTrue("should see the Node2 is closed, and with a close icon", jq(jq(".z-treerow:contains(Node 2)").toWidget().$n("icon")).hasClass("z-tree-close"))
        verifyEquals("should see the Node2 is closed", jq(".z-treerow[style*=none]").length(), 2)
      })

  }
}
