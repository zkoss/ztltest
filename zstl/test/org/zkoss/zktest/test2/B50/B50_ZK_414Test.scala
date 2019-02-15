/* B50_ZK_414Test.java

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

class B50_ZK_414Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
      val target = jq(".z-treerow:contains(something):eq(1)")
      evalScript(zk(target) + ".scrollIntoView()")
      waitResponse()
      click(widget(target).$n("open"))
      waitResponse()
      sleep(2000)
      verifyTrue(getScrollTop(jq("$groupTree").toWidget) > 200)
    })
  }
}



