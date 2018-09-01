/* B50_3151694Test.java

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


class B50_3151694Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<?page title="new page title" contentType="text/html;charset=UTF-8"?>

<zk>
	<html><![CDATA[
		<ol>
		 <li>Type "25-" in the doublebox</li>
		 <li>Click tab to focus away, if popup a warning box, it is correct</li>
		 <li>Click the button to get value, if dialog shows NumberFormatException, it is bug</li>
		</ol>
	]]></html>
	<decimalbox id="decimalbox"/>
	<separator />
	<button label="Get decimalbox value" onClick="alert(decimalbox.value);"></button>
</zk>

		"""
    val ztl$engine = engine()
    val decimalbox = ztl$engine.$f("decimalbox")
    runZTL(zscript, () => {
      typeKeys(decimalbox, "25-")
      waitResponse()
      verifyTrue(jq(".z-errorbox-content").exists())
      click(jq("@button"))
      waitResponse()
      verifyNotContains(getAlertMessage(), "NumberFormatException")
    })
  }
}



