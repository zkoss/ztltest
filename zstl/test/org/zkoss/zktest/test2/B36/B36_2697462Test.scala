/* B36_2697462Test.java

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
import org.zkoss.ztl.unit.Widget


class B36_2697462Test extends ZTL4ScalaTestCase {
  @Test
  def testpaging() = {
    var zscript =
      """
			<zk>
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
			</zk>
		"""
    val ztl$engine = engine()
    val tree = ztl$engine.$f("tree")
    runZTL(zscript, () => {
      click(jq("@treerow").find(".z-treerow-checkbox:eq(0)"))
      waitResponse()
      click(jq("@treerow").find(".z-treerow-checkbox:eq(0)"))
      waitResponse()
      click(jq("@paging").find(".z-paging-next"))
      waitResponse()
      click(jq("@paging").find(".z-paging-previous"))
      waitResponse()
      verifyFalse(jq("@treerow:eq(0)").hasClass("z-treerow-selected"))
    })
  }
}



