package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.{IgnoreBrowsers, Tags}
import org.zkoss.ztl.unit.{Element, Widget}

/**
  * Created by wenning on 1/21/16.
  */
@Tags(tags = "B70-ZK-2941.zul")
@IgnoreBrowsers("ios,android")
class B70_ZK_2941Test extends ZTL4ScalaTestCase {
	
	@Test
	def testClick() = {
		runZTL(() => {
			val cbbid = jq("@combobutton").get(0).attr("id")
			
			focus(jq("$btn"))
			waitResponse()
			
			sendKeysToFocus(Keys.TAB)
			verifyEquals(cbbid, getCurrentFocus().uuid())
			
			sendKeysToFocus(Keys.ENTER)
			sendKeysToFocus(Keys.ENTER)
			verifyEquals(cbbid, getCurrentFocus().uuid())
			
			sendKeysToFocus(Keys.SPACE)
			sendKeysToFocus(Keys.ENTER)
			verifyEquals(cbbid, getCurrentFocus().uuid())
			
			sendKeysToFocus(Keys.ARROW_DOWN)
			
			val menupopup: Element = jq(".z-menupopup").get(0)
			verifyTrue(isVisible(menupopup))
			sendKeys(jq("@combobutton:eq(0)").toWidget, Keys.ESCAPE)
			waitResponse(true)
			verifyFalse(isVisible(menupopup))
		})
	}
	
	def sendKeysToFocus(keys: Keys): Unit = {
		sendKeys(getCurrentFocus(), keys)
		waitResponse()
	}
	
	def getCurrentFocus(): Widget = {
		return jq(":focus").toWidget
	}
}
