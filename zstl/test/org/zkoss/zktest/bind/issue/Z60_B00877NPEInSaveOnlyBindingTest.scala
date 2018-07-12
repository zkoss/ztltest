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
import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00877NPEInSaveOnlyBindingTest extends ZTL4ScalaTestCase {

  @Test
  def testArg() = {
    val zul = """
      <include src="/bind/issue/B00877NPEInSaveOnlyBinding.zul"/>
"""

    runZTL(zul, () => {

      var msg = jq("$msg")
      var tb = jq("$tb")

      typeKeys(tb.toWidget(), "abc")
      waitResponse()
      sleep(500)
      var errorPopup = jq(".z-errorbox")
      verifyEquals("", msg.toWidget().attr("value"))
      verifyEquals(1, errorPopup.length())

      tb.toElement().set("value", "")
      typeKeys(tb.toWidget(), "Lin")
      waitResponse()
      sleep(500)
      verifyEquals("Lin", msg.toWidget().attr("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

    })
  }
}

