/* B50_3025674Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3025674Test extends ZTL4ScalaTestCase {
  @Test
  def testreloadMessages() = {
    val ztl$engine = engine()
    val msg = ztl$engine.$f("msg")
    runZTL(() => {
      verifyEquals(msg.attr("value"), "")
    })
  }
}



