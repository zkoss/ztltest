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

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_RadiogroupSelectedTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = {
      <include src="/bind/comp/radiogroup-selected.zul"/>
    }

    runZTL(zul, () => {
      verifyEquals("1", jq("$listbox").toWidget().get("selectedIndex"))
      verifyEquals("1", jq("$radiogroup").toWidget().get("selectedIndex"))
      verifyFalse(jq("$radioa").toWidget().is("checked")) // dont use selected, not work
      verifyTrue(jq("$radiob").toWidget().is("checked"))
      verifyFalse(jq("$radioc").toWidget().is("checked"))
      click(jq("$itema"))
      waitResponse()
      verifyEquals("0", jq("$listbox").toWidget().get("selectedIndex"))
      verifyEquals("0", jq("$radiogroup").toWidget().get("selectedIndex"))
      verifyTrue(jq("$radioa").toWidget().is("checked"))
      verifyFalse(jq("$radiob").toWidget().is("checked"))
      verifyFalse(jq("$radioc").toWidget().is("checked"))
      click(jq("$radiob"))
      waitResponse()
      verifyEquals("1", jq("$listbox").toWidget().get("selectedIndex"))
      verifyEquals("1", jq("$radiogroup").toWidget().get("selectedIndex"))
      verifyFalse(jq("$radioa").toWidget().is("checked"))
      verifyTrue(jq("$radiob").toWidget().is("checked"))
      verifyFalse(jq("$radioc").toWidget().is("checked"))
      click(jq("$radioc"))
      waitResponse()
      verifyEquals("2", jq("$listbox").toWidget().get("selectedIndex"))
      verifyEquals("2", jq("$radiogroup").toWidget().get("selectedIndex"))
      verifyFalse(jq("$radioa").toWidget().is("checked"))
      verifyFalse(jq("$radiob").toWidget().is("checked"))
      verifyTrue(jq("$radioc").toWidget().is("checked"))
    })
  }
}

