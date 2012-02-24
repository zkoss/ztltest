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
class Z60_B00877NPEInSaveOnlyBindingTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = {
      <include src="/bind/issue/B00877NPEInSaveOnlyBinding.zul"/>
    }

    runZTL(zul, () => {

      var msg = jq("$msg")
      var tb = jq("$tb")

      `type`(tb.toWidget(), "abc")
      waitResponse()
      var errorPopup = jq(".z-errbox.z-popup")
      verifyEquals("", msg.toWidget().get("value"))
      verifyEquals(1, errorPopup.length())

      `type`(tb.toWidget(), "Lin")
      waitResponse()
      verifyEquals("Lin", msg.toWidget().get("value"))
      errorPopup = jq(".z-errbox.z-popup")
      verifyEquals(0, errorPopup.length())

    })
  }
}

