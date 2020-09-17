/* B50_3006772Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B50_3006772Test extends ZTL4ScalaTestCase {
  @Test
  def testfocusArrow() = {
    runZTL(() => {
      click(jq("@treecell:contains(1.1.1)"))
      waitResponse(true)
      click(jq("@treerow").toWidget().$n("icon"))
      waitResponse(true)
      click(jq("@treerow").toWidget().$n("icon"))
      waitResponse(true)
      click(jq("@treecell:contains(1.1.2)"))
      waitResponse(true)
      verifyEquals(1, jq("tr.z-treerow-selected").length())
    })
  }
}



