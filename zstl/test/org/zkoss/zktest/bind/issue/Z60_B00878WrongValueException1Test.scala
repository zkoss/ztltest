/* 

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.junit.Test

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00878WrongValueException1Test extends ZTL4ScalaTestCase {

  @Test
  def testArg() = {
    val zul = """
      <include src="/bind/issue/B00878WrongValueException.zul"/>
"""

    runZTL(zul, () => {

		var msgName = jq("$msgName")
		var msgAge = jq("$msgAge")
		var msgScore = jq("$msgScore")
		var inpName = jq("$inpName")
		var inpAge = jq("$inpAge")
		var inpScore = jq("$inpScore")
		var save = jq("$save")
		verifyEquals("", msgName.toWidget().get("value"))
		verifyEquals("0", msgAge.toWidget().get("value"))
		verifyEquals("0", msgScore.toWidget().get("value"))
		inpName.toElement().set("value", "")
		sendKeys(inpName.toWidget(), "Chen")
		waitResponse()
		inpAge.toElement().set("value", "")
		sendKeys(inpAge.toWidget(), "3")
		waitResponse()
		inpScore.toElement().set("value", "")
		sendKeys(inpScore.toWidget(), "-1")
		waitResponse()
		click(save.toWidget())
		waitResponse()
		verifyEquals("", msgName.toWidget().get("value"))
		verifyEquals("0", msgAge.toWidget().get("value"))
		verifyEquals("0", msgScore.toWidget().get("value"))
		var errorPopup = jq(".z-errorbox")
		sleep(500)
		verifyEquals(3, errorPopup.length())
		inpName.toElement().set("value", "")
		sendKeys(inpName.toWidget(), "Lin")
		waitResponse()
		inpAge.toElement().set("value", "")
		sendKeys(inpAge.toWidget(), "5")
		waitResponse()
		inpScore.toElement().set("value", "")
		sendKeys(inpScore.toWidget(), "-2")
		waitResponse()
		click(save.toWidget())
		waitResponse()
		verifyEquals("", msgName.toWidget().get("value"))
		verifyEquals("0", msgAge.toWidget().get("value"))
		verifyEquals("0", msgScore.toWidget().get("value"))
		errorPopup = jq(".z-errorbox")
		verifyEquals(2, errorPopup.length())
		inpAge.toElement().set("value", "")
		sendKeys(inpAge.toWidget(), "24")
		waitResponse()
		inpScore.toElement().set("value", "")
		sendKeys(inpScore.toWidget(), "-3")
		waitResponse()
		click(save.toWidget())
		waitResponse()
		verifyEquals("", msgName.toWidget().get("value"))
		verifyEquals("0", msgAge.toWidget().get("value"))
		verifyEquals("0", msgScore.toWidget().get("value"))
		errorPopup = jq(".z-errorbox")
		verifyEquals(1, errorPopup.length())
		inpScore.toElement().set("value", "")
		sendKeys(inpScore.toWidget(), "34")
		waitResponse()
		click(save.toWidget())
		waitResponse()
		verifyEquals("Lin", msgName.toWidget().get("value"))
		verifyEquals("24", msgAge.toWidget().get("value"))
		verifyEquals("34", msgScore.toWidget().get("value"))
		errorPopup = jq(".z-errorbox")
		verifyEquals(0, errorPopup.length())
	
    })
  }
}