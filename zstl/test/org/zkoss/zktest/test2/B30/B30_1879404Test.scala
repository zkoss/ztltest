/* B30_1879404Test.java

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


class B30_1879404Test extends ZTL4ScalaTestCase {
  @Test
  def testtextBoxOnOk() = {
    var zscript =
      """
<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
	<window id="win" title="Debug" width="500px" border="normal">
	<vbox id="input" visible="false">
		<hbox>
			<textbox id="msg" style="width:240px" onOK="ms.value = self.value" />
			<label id="ms" value="Please type words in the textbox and press Enter button, and then you should see this message will be changed like your input.(IE only)"/>
		</hbox>
	</vbox>
	<div id="login">
  		<vbox>
    	<label value="Enter Chat" style="font-weight: bold"/>
   		<hbox>
      		NickName:
      		<textbox id="nickname" constraint="no empty">
      			<attribute name="onOK">
			  		nickname.setRawValue("");
			  		login.setVisible(false);
					input.setVisible(true);
      			</attribute>
      		</textbox>
      		Please type words and press Enter button.
    	</hbox>
  		</vbox>
	</div>
</window>
</zk>

		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val win = ztl$engine.$f("win")
    val input = ztl$engine.$f("input")
    val msg = ztl$engine.$f("msg")
    val ms = ztl$engine.$f("ms")
    val login = ztl$engine.$f("login")
    val nickname = ztl$engine.$f("nickname")
    runZTL(zscript, () => {
      /**
        * 2010/10/27:TonyQ
        * browsers ie6,ie7,ie8,chrome,firefox,safari402
        * version zk505
        */
      var $nickname = jq("$nickname")
      sendKeys(nickname, "123")
      focus(nickname)
      sendKeys(nickname, Keys.ENTER)
      waitResponse()
      var $msg = jq("$msg")
      verifyTrue($msg.isVisible())
      sendKeys($msg, "ryan is boring")
      waitResponse()
      focus($msg)
      sendKeys($msg, Keys.ENTER)
      waitResponse()
      verifyEquals("ryan is boring", ms.get("value"))
    })
  }
}



