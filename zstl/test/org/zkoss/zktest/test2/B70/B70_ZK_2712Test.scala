/* B70_ZK_2712Test.scala

	Purpose:
		
	Description:
		
	History:
		Wed Oct 14 16:44:04 CST 2015, Created by chunfu

Copyright (C)  2015 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags;

/**
  *
  * @author chunfu
  */
@Tags(tags = "B70-ZK-2712.zul")
class B70_ZK_2712Test extends ZTL4ScalaTestCase {
  @Test
  def testCase() = {
    runZTL(() => {
      var tree = jq("@tree")
      verScroll(tree, 100)
      waitResponse()
      click(jq("@treerow").last())
      waitResponse()
      click(jq("@button"))
      waitResponse()
      verifyEquals(1, jq("@treerow").length())
      verifyContains(jq(".z-treecell-content").text(), "New item")
    })
  }
}
