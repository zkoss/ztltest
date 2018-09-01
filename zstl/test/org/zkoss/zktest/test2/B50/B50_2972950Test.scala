/* B50_2972950Test.java

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
import org.zkoss.ztl.unit.Widget


class B50_2972950Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<zk>
					<html><![CDATA[
					<ul>
					<li>Click the add constraint button and that shall not have any JavaScript error</li>
					<li>Type -1 to the input box and press TAB. Then, an error message will show up</li>
					</ul>
					]]></html>
					<intbox id="intbox" />
					<button id="btn" label="add constraint"
					onClick="intbox.constraint = new SimpleConstraint(SimpleConstraint.NO_NEGATIVE)" />
				</zk>
			"""
    val ztl$engine = engine()
    val intbox = ztl$engine.$f("intbox")
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      click(btn)
      waitResponse()
      verifyFalse(jq(".z-error").exists())
      //type will blur the widget so dont need to press tab
      typeKeys(intbox, "-1")
      verifyTrue(jq(".z-errorbox").exists())
    })
  }
}



