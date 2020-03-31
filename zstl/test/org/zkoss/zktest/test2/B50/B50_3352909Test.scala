/* B50_3352909Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Oct 12 12:37:32 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 3352909
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3352909.zul,A,E,Grid,Listbox,ROD,Scrollbar")
class B50_3352909Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      var lb = jq("@listbox").toWidget
      var grid = jq("@grid").toWidget
      waitResponse()
      verScroll(lb, 50)
      waitResponse()
      verifyTrue(jq(lb.$n("body")).scrollTop() > 2000)
      verScroll(grid, 50)
      waitResponse()
      sleep(500)
      verifyTrue(jq(grid.$n("body")).scrollTop() > 2000)
    })
  }
}