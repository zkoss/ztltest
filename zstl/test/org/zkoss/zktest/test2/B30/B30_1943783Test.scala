/* B30_1943783Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1943783Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
Press 'Enter' key and you will see a messagebox is shown.
Press 'ESC' key and you will see a messagebox is shown.
<separator/>
<timebox onOK='alert("OK:"+self.value)' onCancel='alert("ESC:"+self.value)' focus="true"/>
<separator/>
<textbox onOK='alert("OK:"+self.value)' onCancel='alert("ESC:"+self.value)'/>
<separator/>
<datebox onOK='alert("OK:"+self.value)' onCancel='alert("ESC:"+self.value)'/>
</zk>

		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      sendKeys(jq("@timebox").find("input"), Keys.ENTER)
      waitResponse()
      verifyNotEquals("OK:null", getAlertMessage())
      clickAlert()
      waitResponse()
      sendKeys(jq("@timebox").find("input"), Keys.ESCAPE)
      waitResponse()
      verifyNotEquals("ESC:null", getAlertMessage())
    })
  }
}



