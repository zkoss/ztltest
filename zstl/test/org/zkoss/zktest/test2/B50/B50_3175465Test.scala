/* B50_3175465Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_3175465Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
Please open the treeitem "item" and you should see the treeitem "child item" is appended as its children.
<tree mold="paging">
<treechildren>
<treeitem open="false">
<treerow>
<treecell label="item" />
</treerow>
<treechildren>
<treeitem>
<treerow>
<treecell label="child item" />
</treerow>
</treeitem>
</treechildren>
</treeitem>
</treechildren>
</tree>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      verifyEquals(1, jq("@treerow").length())
      click(jq(".z-treerow").toWidget().$n("icon"))
      waitResponse()
      verifyEquals(2, jq("@treerow").length())
      verifyContains(jq(".z-treerow:eq(1)").text(), "child item")
    })
  }
}



