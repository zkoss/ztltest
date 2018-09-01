/* B35_2107058Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B35_2107058Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			



<zk>
	<div>
		1. enter something in acc/pwd , then click login , you will see the
		message with "login button is clicked"
	</div>
	<div>
		2. you press Enter key , you will get the message for "onOK is
		triggered, pwd = " , and you should check the pwd is correct or not.
	</div>
	<window id="login_window" title="Login" border="normal" width="420px"
		sizable="false" mode="overlapped" position="center"
		onOK='alert("Window.onOK triggered, password=" + password.getValue())'
		xmlns:h="http://www.w3.org/1999/xhtml">
		<timer id="timer" running="true" delay="30000" repeats="true"
			onTimer="" />
		<grid fixedLayout="false">
			<rows>
				<row>
					ACC
					<hbox>
						<textbox id="username" constraint="no empty"
							onChange='realname.setValue("your real name")' />
						<label id="realname" />
					</hbox>
					<zscript>
	username.focus();
</zscript>

				</row>
				<row>
					PWD
					<textbox type="password" constraint="no empty"
						id="password" />
				</row>
				<row>
					<label />
					<checkbox id='ldapauth' label="Test" checked='true' />
				</row>

				<row>
					<label />
					<vbox>
						<button id="btn" label=" login"
							onClick='alert("Login button clicked")' />
					</vbox>
				</row>
			</rows>
		</grid>
		<label id="info" style="color:red;" />
	</window>

</zk>

		"""
    val ztl$engine = engine()
    val login_window = ztl$engine.$f("login_window")
    val timer = ztl$engine.$f("timer")
    val username = ztl$engine.$f("username")
    val realname = ztl$engine.$f("realname")
    val password = ztl$engine.$f("password")
    val ldapauth = ztl$engine.$f("ldapauth")
    val btn = ztl$engine.$f("btn")
    val info = ztl$engine.$f("info")
    runZTL(zscript, () => {
      sendKeys(jq("$username"), "hello")
      waitResponse()
      sendKeys(jq("$password"), "world")
      waitResponse()
      click(jq("$btn"))
      waitResponse()
      verifyEquals("Login button clicked", jq(".z-window-highlighted .z-label").text())
      click(jq(".z-messagebox-button"))
      waitResponse()
      focus(jq("$password"))
      sendKeys(jq("$password"), Keys.ENTER)
      waitResponse()
      verifyEquals("Window.onOK triggered, password=world", jq(".z-window-highlighted .z-label").text())
    })
  }
}



