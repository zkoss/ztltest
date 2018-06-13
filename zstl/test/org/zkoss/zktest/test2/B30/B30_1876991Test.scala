/* B30_1876991Test.java

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
import org.zkoss.ztl.unit.Widget


class B30_1876991Test extends ZTL4ScalaTestCase {
  @Test
  def testConstraint() = {
    var zscript =
      """
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
			<html><![CDATA[
			<ul>
			<li>
			1. Type 100 and tab out, it should not show any error
			</li>
			<li>
			2.Type -100 and it should show "Only positive number is allowed" in English locale
			</li>
			</ul>
			]]></html>
				<intbox id="myIntbox" constraint="no negative,no zero"/>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val myIntbox = ztl$engine.$f("myIntbox")
    runZTL(zscript, () => {
      sendKeys(myIntbox, "100")
      waitResponse()
      blur(myIntbox)
      verifyFalse(jq(".z-errorbox").exists())
      myIntbox.toElement().set("value", "")
      sendKeys(myIntbox, "-100")
      waitResponse()
      blur(myIntbox)
      waitResponse()
      verifyTrue(jq(".z-errorbox").exists())
    })
  }
}



