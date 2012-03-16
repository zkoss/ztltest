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

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00878WrongValueException1Test extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = {
      <include src="/bind/issue/B00878WrongValueException.zul"/>
    }

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
		`type`(inpName.toWidget(), "Chen")
		waitResponse()
		`type`(inpAge.toWidget(), "3")
		waitResponse()
		`type`(inpScore.toWidget(), "-1")
		waitResponse()
		click(save.toWidget())
		waitResponse()
		verifyEquals("", msgName.toWidget().get("value"))
		verifyEquals("0", msgAge.toWidget().get("value"))
		verifyEquals("0", msgScore.toWidget().get("value"))
		var errorPopup = jq(".z-errbox.z-popup")
		verifyEquals(3, errorPopup.length())
		`type`(inpName.toWidget(), "Lin")
		waitResponse()
		`type`(inpAge.toWidget(), "5")
		waitResponse()
		`type`(inpScore.toWidget(), "-2")
		waitResponse()
		click(save.toWidget())
		waitResponse()
		verifyEquals("", msgName.toWidget().get("value"))
		verifyEquals("0", msgAge.toWidget().get("value"))
		verifyEquals("0", msgScore.toWidget().get("value"))
		errorPopup = jq(".z-errbox.z-popup")
		verifyEquals(2, errorPopup.length())
		`type`(inpAge.toWidget(), "24")
		waitResponse()
		`type`(inpScore.toWidget(), "-3")
		waitResponse()
		click(save.toWidget())
		waitResponse()
		verifyEquals("", msgName.toWidget().get("value"))
		verifyEquals("0", msgAge.toWidget().get("value"))
		verifyEquals("0", msgScore.toWidget().get("value"))
		errorPopup = jq(".z-errbox.z-popup")
		verifyEquals(1, errorPopup.length())
		`type`(inpScore.toWidget(), "34")
		waitResponse()
		click(save.toWidget())
		waitResponse()
		verifyEquals("Lin", msgName.toWidget().get("value"))
		verifyEquals("24", msgAge.toWidget().get("value"))
		verifyEquals("34", msgScore.toWidget().get("value"))
		errorPopup = jq(".z-errorbox.z-popup")
		verifyEquals(0, errorPopup.length())
	
    })
  }
}