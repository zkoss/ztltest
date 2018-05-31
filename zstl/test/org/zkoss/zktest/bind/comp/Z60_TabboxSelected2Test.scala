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
package org.zkoss.zktest.bind.comp
import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_TabboxSelected2Test extends ZTL4ScalaTestCase {
  @Test
  def testArg() = {
    val zul = """
      <include src="/bind/comp/tabbox-selected.zul"/>
"""

    runZTL(zul, () => {
      verifyEquals("1", jq("$listbox2").toWidget().get("selectedIndex"))
      verifyEquals("1", jq("$tabbox2").toWidget().get("selectedIndex"))
      verifyFalse(jq("$tab2a").toWidget().is("selected"))
      verifyTrue(jq("$tab2b").toWidget().is("selected"))
      verifyFalse(jq("$tab2c").toWidget().is("selected"))
      click(jq("$item2a"))
      waitResponse()
      verifyEquals("0", jq("$listbox2").toWidget().get("selectedIndex"))
      verifyEquals("0", jq("$tabbox2").toWidget().get("selectedIndex"))
      verifyTrue(jq("$tab2a").toWidget().is("selected"))
      verifyFalse(jq("$tab2b").toWidget().is("selected"))
      verifyFalse(jq("$tab2c").toWidget().is("selected"))
      click(jq("$tab2c"))
      waitResponse()
      verifyEquals("2", jq("$listbox2").toWidget().get("selectedIndex"))
      verifyEquals("2", jq("$tabbox2").toWidget().get("selectedIndex"))
      verifyFalse(jq("$tab2a").toWidget().is("selected"))
      verifyFalse(jq("$tab2b").toWidget().is("selected"))
      verifyTrue(jq("$tab2c").toWidget().is("selected"))
    })
  }
}
