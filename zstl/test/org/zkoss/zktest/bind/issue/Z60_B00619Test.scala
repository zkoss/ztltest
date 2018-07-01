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
class Z60_B00619Test extends ZTL4ScalaTestCase {
  
  @Test
  def testIssue() = {
    val zul = """
      <include src="/bind/issue/B00619.zul"/>
"""

    runZTL(zul, () => {
      verifyEquals("1", jq("$listbox").toWidget().get("selectedIndex"))
      verifyEquals("1", jq("$tabbox").toWidget().get("selectedIndex"))
      verifyFalse(jq("$taba").toWidget().is("selected"))
      verifyTrue(jq("$tabb").toWidget().is("selected"))
      verifyFalse(jq("$tabc").toWidget().is("selected"))
      click(jq("$itema").toWidget())
      waitResponse()
      verifyEquals("0", jq("$listbox").toWidget().get("selectedIndex"))
      verifyEquals("0", jq("$tabbox").toWidget().get("selectedIndex"))
      verifyTrue(jq("$taba").toWidget().is("selected"))
      verifyFalse(jq("$tabb").toWidget().is("selected"))
      verifyFalse(jq("$tabc").toWidget().is("selected"))
      click(jq("$tabc").toWidget())
      waitResponse()
      verifyEquals("2", jq("$listbox").toWidget().get("selectedIndex"))
      verifyEquals("2", jq("$tabbox").toWidget().get("selectedIndex"))
      verifyFalse(jq("$taba").toWidget().is("selected"))
      verifyFalse(jq("$tabb").toWidget().is("selected"))
      verifyTrue(jq("$tabc").toWidget().is("selected"))
    })
  }
}