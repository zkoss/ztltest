package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1639.zul")
class B65_ZK_1639Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
	<zscript><![CDATA[
	
	DefaultTreeNode r = new DefaultTreeNode("root",new ArrayList());
	DefaultTreeNode n1 = new DefaultTreeNode("Node 1",new ArrayList());
	DefaultTreeNode n2 = new DefaultTreeNode("Node 2",new ArrayList());
	DefaultTreeNode nx = new DefaultTreeNode("Node X",new ArrayList());
	DefaultTreeNode nxo = new DefaultTreeNode("Node O");
	DefaultTreeNode n3 = new DefaultTreeNode("Node 3",new ArrayList());
	DefaultTreeNode n3o = new DefaultTreeNode("Node 3O");
	DefaultTreeNode n4 = new DefaultTreeNode("Node 4");
	
	
	DefaultTreeNode n5 = new DefaultTreeNode("Node 5");
	
	r.add(n1);
	n1.add(n2);
	n1.add(nx);
	n2.add(n3o);
	n2.add(n3);
	nx.add(nxo);
	n3.add(n4);
	           
	DefaultTreeModel model = new DefaultTreeModel(r);
	model.addOpenObject(n1);
	model.addOpenObject(n2);
	model.addOpenObject(n3);
	model.addOpenObject(nx);
	
]]></zscript>
	<label multiline="true">
		Case1 - Test just the Move
		1.Click Move 3 to X, the node 3 should move to node X and with correct Open State()
		2.if the bug is not fixed, you will see Node 3 doesn't have correct state (currently, it was closed but has opened icon)
		3.Click Move 3 to 2, should has same result.
		Case2 - Test move and with modify
		1.Click Move 3 to X, the node 3 should move to node X, and both node2 and nodeX has correct label change (Node (1) ..etc)
		2.Click Move 3 to 2, the node 3 should move to node 2, and both node2 and nodeX has correct label change (Node (1) ..etc)
		3.if the bug is not fixed, you will see Node 3 disappear 
	</label>
	<hbox>
		Case1
		<button label="Move Node 3 to Node X" onClick='nx.add(n3)'/>
		<button label="Move Node 3 to Node 2" onClick='n2.add(n3)'/>
	</hbox>
	<hbox>
		Case2
		<button label="Move Node 3 to Node X" onClick='move(n3,nx)'/>
		<button label="Move Node 3 to Node 2" onClick='move(n3,n2)'/>
		<zscript>
		void move(DefaultTreeNode node,DefaultTreeNode newp){
			DefaultTreeNode oldp = node.getParent();
			oldp.remove(node);
			newp.add(node);
			
			oldp.setData("Node ("+oldp.getChildCount()+")");
			newp.setData("Node ("+newp.getChildCount()+")");
		}
		
		</zscript>
	</hbox>
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

        click(jq(".z-button:contains(Move Node 3 to Node X):eq(0)"))
        waitResponse()

        val case11node3 = jq(".z-treerow:eq(5):contains(Node 3)")
        verifyTrue("the node 3 should move to node X", case11node3.exists())
        verifyTrue("the node 3 should move to node X", case11node3.find(".z-tree-last-open").exists())

        click(jq(".z-button:contains(Move Node 3 to Node 2):eq(0)"))
        waitResponse()

        val case12node3 = jq(".z-treerow:eq(3):contains(Node 3)")
        verifyTrue("the node 3 should move to node X", case12node3.exists())
        verifyTrue("the node 3 should move to node X", case11node3.find(".z-tree-last-open").exists())

        click(jq(".z-button:contains(Move Node 3 to Node X):eq(1)"))
        waitResponse()
        
        val case21node3 = jq(".z-treerow:eq(5):contains(Node 3)")
        verifyTrue("the node 3 should move to node X", case21node3.exists())
        verifyTrue("both node2 and nodeX has correct label change", jq(".z-treerow:eq(1):contains(Node (1))").exists())
        verifyTrue("both node2 and nodeX has correct label change", jq(".z-treerow:eq(3):contains(Node (2))").exists())

        click(jq(".z-button:contains(Move Node 3 to Node 2):eq(1)"))
        waitResponse()

        val case22node3 = jq(".z-treerow:eq(3):contains(Node 3)")
        verifyTrue("the node 3 should move to node X", case22node3.exists())
        verifyTrue("both node2 and nodeX has correct label change", jq(".z-treerow:eq(1):contains(Node (2))").exists())
        verifyTrue("both node2 and nodeX has correct label change", jq(".z-treerow:eq(3):contains(Node (1))").exists())

      })

  }
}
