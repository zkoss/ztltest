package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1634.zul")
class B65_ZK_1634Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
	<zscript><![CDATA[
	DefaultTreeNode r = new DefaultTreeNode("root", new ArrayList());
	DefaultTreeNode n1 = new DefaultTreeNode("Node 1", new ArrayList());
	DefaultTreeNode n2 = new DefaultTreeNode("Node 2", new ArrayList());
	DefaultTreeNode n3 = new DefaultTreeNode("Node 3", new ArrayList());
	DefaultTreeNode n4 = new DefaultTreeNode("Node 4");
	DefaultTreeNode n5 = new DefaultTreeNode("Node 5");
	r.add(n1);
	n1.add(n2);
	n2.add(n3);
	n3.add(n4);
	DefaultTreeModel model = new DefaultTreeModel(r);
	model.addOpenObject(n1);
	model.addOpenObject(n2);
	model.addOpenObject(n3);
	
	
	public class VR implements org.zkoss.xel.VariableResolver {
		Object each;
		public VR(Object each){
			this.each = each;
		}
		
		public Object resolveVariable(String name) {
			if ("each".equals(name)) {
				return each;
			}
		}
	}
	
	public class TR implements TreeitemRenderer {
		public void render(Treeitem ti, Object node, int index) {
			Tree tree = ti.getTree();
			Component parent = ti.getParent();
			
			if(tree==null){
				throw new RuntimeException("Tree is null");
			}
			if(parent==null){
				throw new RuntimeException("Parent is null");
			}
			
			org.zkoss.zk.ui.util.Template tm = tree.getTemplate("model");
			
			final Object each = node;
			
			org.zkoss.xel.VariableResolver vr = new VR(node);
			
			Component[] items = tm.create(ti.getParent(), ti, vr, null);
			if (items.length != 1)
				throw new UiException("The model template must have exactly one item, not " + items.length);

			Treeitem nti = (Treeitem) items[0];
			if (nti.getValue() == null) //template might set it
				nti.setValue(node);
			ti.setAttribute("org.zkoss.zul.model.renderAs", nti);
			//indicate a new item is created to replace the existent one
			ti.detach();
		}
	}
	;
	TreeitemRenderer myRenderer = new TR();
]]></zscript>
	<label multiline="true">
		1.click on set Node2 Data, the node 2 label should change to New Node 2, and still has child Node3
		2.if the bug is not fixed, you will get exception 
	</label>
	<button label="set Node2 Data" onClick='n2.setData("New Node 2")'/>
	<tree model="${model}" itemRenderer="${myRenderer}">
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
        click(jq(".z-button:contains(set Node2 Data)"))
        waitResponse()

        verifyTrue("the node 2 label should change to New Node 2", jq(".z-treecell:contains(New Node 2)").exists())
        verifyTrue("still has child Node3", jq(".z-treecell:contains(Node 3)").exists())
        verifyTrue("you should not see any exception dialog", !jq(".z-window-modal").exists())
      })

  }
}
