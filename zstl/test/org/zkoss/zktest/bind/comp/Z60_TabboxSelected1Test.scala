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

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.junit.Test

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_TabboxSelected1Test extends ZTL4ScalaTestCase {
  @Test
  def testArg() = {
    val zul = """
      <include src="/bind/comp/tabbox-selected.zul"/>
"""

    runZTL(zul, () => {
      verifyEquals("2", jq("$listbox1").toWidget().get("selectedIndex"))
      verifyEquals("2", jq("$tabbox1").toWidget().get("selectedIndex"))
      verifyFalse(jq("$tab1a").toWidget().is("selected"))
      verifyFalse(jq("$tab1b").toWidget().is("selected"))
      verifyTrue(jq("$tab1c").toWidget().is("selected"))
      click(jq("$item1a"))
      waitResponse()
      verifyEquals("0", jq("$listbox1").toWidget().get("selectedIndex"))
      verifyEquals("0", jq("$tabbox1").toWidget().get("selectedIndex"))
      verifyEquals(true, jq("$tab1a").toWidget().get("selected"))
      verifyFalse(jq("$tab1b").toWidget().is("selected"))
      verifyFalse(jq("$tab1c").toWidget().is("selected"))
      click(jq("$item1b"))
      waitResponse()
      verifyEquals("1", jq("$listbox1").toWidget().get("selectedIndex"))
      verifyEquals("1", jq("$tabbox1").toWidget().get("selectedIndex"))
      verifyFalse(jq("$tab1a").toWidget().is("selected"))
      verifyEquals(true, jq("$tab1b").toWidget().get("selected"))
      verifyFalse(jq("$tab1c").toWidget().is("selected"))
    })
  }
}


