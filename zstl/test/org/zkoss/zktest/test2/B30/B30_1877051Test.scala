/* B30_1877051Test.java

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
import org.zkoss.ztl.Widget


class B30_1877051Test extends ZTL4ScalaTestCase {
  @Test
  def testConstraint() = {
    var zscript =
      """
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>Positive intbox can't accept "+123" as value but it should be.</n:p>
				<intbox id="myIntbox" constraint="no negative,no zero"/>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val myIntbox = ztl$engine.$f("myIntbox")
    runZTL(zscript, () => {
      myIntbox.toElement().set("value", "")
      sendKeys(myIntbox, "+123")
      waitResponse()
      blur(myIntbox)
      waitResponse()
      verifyNotEquals("+123", jq(myIntbox).`val`())
    })
  }
}



