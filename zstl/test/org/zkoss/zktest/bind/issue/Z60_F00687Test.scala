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
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_F00687Test extends ZTL4ScalaTestCase {
  @Test
  def testIssue() = {
    val zul = """
      <include src="/bind/issue/F00687.zul"/>
"""

    runZTL(zul, () => {
      var l11 = jq("$l11").toWidget()
      var l12 = jq("$l12").toWidget()
      var l13 = jq("$l13").toWidget()
      var l14 = jq("$l14").toWidget()
      var t11 = jq("$t11").toWidget()
      var t12 = jq("$t12").toWidget()
      var t13 = jq("$t13").toWidget()
      var t14 = jq("$t14").toWidget()
      verifyEquals("A", l11.get("value"))
      verifyEquals("B", l12.get("value"))
      verifyEquals("C", l13.get("value"))
      verifyEquals("D", l14.get("value"))
      t11.toElement().set("value", "")
      sendKeys(t11, "Q" + Keys.TAB)
      waitResponse()
      verifyEquals("Q", l11.get("value"))
      verifyEquals("B", l12.get("value"))
      verifyEquals("C", l13.get("value"))
      verifyEquals("D", l14.get("value"))
      t12.toElement().set("value", "")
      sendKeys(t12, "W" + Keys.TAB)
      waitResponse()
      verifyEquals("Q", l11.get("value"))
      verifyEquals("B", l12.get("value"))
      verifyEquals("C", l13.get("value"))
      verifyEquals("D", l14.get("value"))
      t13.toElement().set("value", "")
      sendKeys(t13, "E" + Keys.TAB)
      waitResponse()
      verifyEquals("Q", l11.get("value"))
      verifyEquals("W", l12.get("value"))
      verifyEquals("E", l13.get("value"))
      verifyEquals("D", l14.get("value"))
      click(jq("$btn1").toWidget())
      waitResponse()
      verifyEquals("Q", l11.get("value"))
      verifyEquals("W", l12.get("value"))
      verifyEquals("E", l13.get("value"))
      verifyEquals("command 1", l14.get("value"))
      verifyEquals("command 1", t14.get("value"))
    })
  }
}
