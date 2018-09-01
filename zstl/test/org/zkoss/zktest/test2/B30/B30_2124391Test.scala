/* B30_2124391Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_2124391Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<window title="dynamic tree" border="normal" id="win">
	If you can see each item with "Group0", "Group1"..., that is
	correct.
	<zscript>	
		import org.zkoss.zktest.test2.tree.*;
		HostTreeModel model = new HostTreeModel();
		HostIconTreeRenderer renderer = new HostIconTreeRenderer();
	</zscript>
	<tree model="${model}" treeitemRenderer="${renderer}" />
</window>

		"""
    val ztl$engine = engine()
    val win = ztl$engine.$f("win")
    runZTL(zscript, () => {
      verifyContains(jq("@treeitem:eq(0)").text(), "Group0")
      verifyContains(jq("@treeitem:eq(1)").text(), "Group1")
      verifyContains(jq("@treeitem:eq(2)").text(), "Group2")
      verifyContains(jq("@treeitem:eq(3)").text(), "Group3")
      verifyContains(jq("@treeitem:eq(4)").text(), "Group4")
    })
  }
}



