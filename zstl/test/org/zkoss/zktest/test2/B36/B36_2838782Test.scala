/* B36_2838782Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2838782Test extends ZTL4ScalaTestCase {
  @Test
  def testnavigate() = {
    var zscript =
      """
			<zk>
				Please select a treeitem and open/close a treeitem, and then use keyboard Up/Down to navigate the tree, it should be OK.
				<zscript>					
				import org.zkoss.zktest.test2.tree.BinaryTreeModel;
				import java.util.*;
				
				BinaryTreeModel btm = new BinaryTreeModel(new ArrayList(new org.zkoss.zktest.test2.BigList(1000)));
				</zscript>
				<tree id="tree" mold="paging" pageSize="15" model="&#36;{btm}">
					<attribute name="onCreate">
					tree.renderItemByPath(new int[]{1,1,1,1,1,1,1,1,1,1,1,1});
					tree.renderItemByPath(new int[]{0,0,0,0,0,0,0,0,0,0,0,0});
					</attribute>
				</tree>
			</zk>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tree = ztl$engine.$f("tree")
    runZTL(zscript, () => {
      click(jq("@treecell:contains(3)"))
      waitResponse()
      click(jq("@treerow:eq(0)").toWidget().$n("icon"))
      waitResponse()
      click(jq("@treerow:eq(0)").toWidget().$n("icon"))
      waitResponse()
      sendKeys(jq(tree), Keys.DOWN)
      sendKeys(jq(tree), Keys.DOWN)
      sendKeys(jq(tree), Keys.UP)
      verifyTrue(jq("@treecell:contains(7)").parent(".z-treerow").hasClass("z-treerow-selected"))
    })
  }
}



