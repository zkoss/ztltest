/* B36_2777293Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B36_2777293Test extends ZTL4ScalaTestCase {
  @Test
  def testmodel() = {
    var zscript =
      """
			<zk>
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
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tree = ztl$engine.$f("tree")
    runZTL(zscript, () => {
      click(jq("@button[label=\"Test new model\"]"))
      waitResponse()
      verifyEquals(2, jq("tr.z-treerow").length())
      click(jq("@button[label=\"Test null model\"]"))
      waitResponse()
      verifyEquals(0, jq("tr.z-treerow").length())
    })
  }
}



