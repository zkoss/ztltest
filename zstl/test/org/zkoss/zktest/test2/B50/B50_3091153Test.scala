/* B50_3091153Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B50_3091153Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
      verifyEquals(1, jq(".z-treerow").length())
      verifyEquals(1, jq(".z-treerow-selected").length())
      click(jq(".z-treerow").toWidget().$n("icon"))
      waitResponse()
      verifyEquals(6, jq(".z-treerow-selected").length())
      verifyEquals(6, jq(".z-treerow").length())
      click(jq("@button[label=\"deSelectAll\"]"))
      waitResponse()
      verifyEquals(0, jq(".z-treerow-selected").length())
      verifyEquals(6, jq(".z-treerow").length())
      click(jq("@button[label=\"selectAll\"]"))
      waitResponse()
      verifyEquals(6, jq(".z-treerow-selected").length())
      verifyEquals(6, jq(".z-treerow").length())
    })
  }
}