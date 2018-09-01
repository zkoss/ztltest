/* B36_2713338Test.java

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


class B36_2713338Test extends ZTL4ScalaTestCase {
  @Test
  def testgetSelectedItem() = {
    var zscript =
      """
			<zk>
				Select any tree item at the tree then click the button,
			
				the button should show "Not Null", if "Null" the it's a BUG.
				<zscript>
				    import org.zkoss.zktest.test2.tree.BinaryTreeModel;
				    import java.util.*;
				    BinaryTreeModel btm = new BinaryTreeModel(new ArrayList(new org.zkoss.zktest.test2.BigList(1000)));
				</zscript>
					<tree id="tree" model="&#36;{btm}" />
					<button label="Test">
						<attribute name="onClick">
						    if (tree.getSelectedItem().getValue() == null) {
						        self.label = "Null";
						    } else {
						        self.label = "Not Null";
						    }
						</attribute>
					</button>
			</zk>
		"""
    val ztl$engine = engine()
    val tree = ztl$engine.$f("tree")
    runZTL(zscript, () => {
      clickAt(jq("@treecell"), "50,2")
      waitResponse()
      click(jq("@button"))
      waitResponse()
      verifyEquals("Not Null", jq("@button").html())
    })
  }
}



