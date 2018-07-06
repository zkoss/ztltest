/* B50_3214754Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3214754Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	Please test the following cases:
	<separator/>
	1. type "test" into the textbox and focus out, it should alert an error.
	<separator/>

	2. clear the error popup and type "123" into the textbox and focus out, it shouldn't alert an error.
	<separator/>
	3. clear the error popup and type "12A3" into the textbox and focus out, they should alert an error.
	<separator/>
	<textbox constraint="/\d+/"/>
	<separator/>
	4. Please test the step 1~3 with the following textbox as well.
	<separator/>
	<textbox constraint="/\d*/"/>
</zk>


		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      `type`(jq("@textbox:eq(0)"), "test")
      waitResponse(true)
      sleep(300)
      verifyTrue(jq(".z-errorbox").exists())
      click(jq(".z-errorbox").toWidget().$n("cls"))
      `type`(jq("@textbox:eq(0)"), "123")
      waitResponse(true)
      sleep(300)
      verifyFalse(jq(".z-errorbox").exists())
      `type`(jq("@textbox:eq(0)"), "12A3")
      waitResponse(true)
      sleep(300)
      verifyTrue(jq(".z-errorbox").exists())
      click(jq(".z-errorbox").toWidget().$n("cls"))
      `type`(jq("@textbox:eq(0)"), "123")
      `type`(jq("@textbox:eq(1)"), "test")
      waitResponse(true)
      sleep(300)
      verifyTrue(jq(".z-errorbox").exists())
      click(jq(".z-errorbox").toWidget().$n("cls"))
      `type`(jq("@textbox:eq(1)"), "123")
      waitResponse(true)
      sleep(300)
      verifyFalse(jq(".z-errorbox").exists())
      `type`(jq("@textbox:eq(1)"), "12A3")
      waitResponse(true)
      sleep(300)
      verifyTrue(jq(".z-errorbox").exists())
      click(jq(".z-errorbox").toWidget().$n("cls"))
    })
  }
}



