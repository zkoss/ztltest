/* B36_2904793Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2904793Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<vbox>
<label value="1. It is correct when you see 'onChange has been triggered!' 
after input any words into following textbox." />
<label value="2. It is correct when you see 'onOK has been triggered!' after press Enter key." />
<textbox id="myTextbox" onOK="okEvtLabel.setVisible(true);" onChanging="changeEvtLabel.setVisible(true);"/>
<label id="changeEvtLabel" value="onChange has been triggered!" visible="false" />
<label id="okEvtLabel" value="onOk has been triggered!" visible="false" />
</vbox>

		"""
    val ztl$engine = engine()
    val myTextbox = ztl$engine.$f("myTextbox")
    val changeEvtLabel = ztl$engine.$f("changeEvtLabel")
    val okEvtLabel = ztl$engine.$f("okEvtLabel")
    runZTL(zscript, () => {
      typeKeys(jq(myTextbox), "k")
      waitResponse()
      verifyTrue("onChange event was not triggered!", jq(changeEvtLabel).isVisible())
      focus(jq(myTextbox))
      sendKeys(myTextbox, Keys.ENTER)
      waitResponse()
      verifyTrue("onOk event was not triggered!", jq(okEvtLabel).isVisible())
    })
  }
}



