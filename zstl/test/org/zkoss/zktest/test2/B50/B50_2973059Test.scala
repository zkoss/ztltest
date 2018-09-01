/* B50_2973059Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2973059Test extends ZTL4ScalaTestCase {
  @Test
  def testVisible() = {
    var zscript =
      """
			<zk>
			<html><![CDATA[
			<ul>
			 <li>Type "abc" in the text box and click the button</li>
			 <li>Then, you shall see a message showing up with "abc"</li>
			</ul>
			]]></html>
			
			<textbox id="mytextbox" value="" width="240px" />
			<button id="btn" label="xxx" image="/img/inet.png" onClick="alert(mytextbox.getValue())"
			mold="default"/>
			
			</zk>
		"""
    val ztl$engine = engine()
    val mytextbox = ztl$engine.$f("mytextbox")
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      typeKeys(mytextbox, "abc")
      click(btn)
      waitResponse()
      verifyEquals("abc", getAlertMessage())
    })
  }
}



