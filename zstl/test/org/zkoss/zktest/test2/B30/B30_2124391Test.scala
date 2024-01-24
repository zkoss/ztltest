/* B30_2124391Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B30_2124391Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
      verifyContains(jq("@treeitem:eq(0)").text(), "Group0")
      verifyContains(jq("@treeitem:eq(1)").text(), "Group1")
      verifyContains(jq("@treeitem:eq(2)").text(), "Group2")
      verifyContains(jq("@treeitem:eq(3)").text(), "Group3")
      verifyContains(jq("@treeitem:eq(4)").text(), "Group4")
    })
  }
}