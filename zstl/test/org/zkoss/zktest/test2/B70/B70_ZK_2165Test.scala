package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2165.zul")
class B70_ZK_2165Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
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
			<tree hflex="1" height="500px" model="${model}"
				mold="paging" span="true" pageSize="150">
				<treecols sizable="true">
					<treecol label="Column 1" />
				</treecols>
			</tree>
			<!-- pageSize larger than model size causes error -->
			<tree hflex="1" height="500px" model="${model}"
				mold="paging" pageSize="300" span="true">
				<treecols sizable="true">
					<treecol label="Column 1" />
				</treecols>
			</tree>
		</hlayout>
	</window>
</zk>"""
    runZTL(zscript,
      () => {
        val tree0 = jq(".z-tree")
        verScroll(tree0.toWidget(), 1.0)
        verifyTrue("should see all tree item is loaded", tree0.find(".z-treerow:contains(Node 149)").exists())
        
        val tree1 = jq(".z-tree").eq(1)
        verScroll(tree1.toWidget(), 1.0)
        verifyTrue("should see all tree item is loaded", tree1.find(".z-treerow:contains(Node 299)").exists())
      })

  }
}