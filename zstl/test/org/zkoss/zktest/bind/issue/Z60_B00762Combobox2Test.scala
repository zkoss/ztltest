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
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00762Combobox2Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = """
      <include src="/bind/issue/B00762Combobox2.zul"/>
"""

    runZTL(zul, () => {
      var outerbox = jq("$outerbox")
      var min = jq("$min").toWidget()
      // var max = jq("$max")
      var clean = jq("$clean").toWidget()
      var select = jq("$select").toWidget()
      var reload = jq("$reload").toWidget()
      var showselect = jq("$showselect").toWidget()
      evalScript(outerbox.toWidget() + ".open()")
      waitResponse()
      click(outerbox.find("@comboitem").eq(0).toWidget())
      waitResponse()
      click(showselect)
      waitResponse()
      verifyEquals("0", min.attr("value"))
      // verifyEquals("0", max.attr("value"))
      evalScript(outerbox.toWidget() + ".open()")
      waitResponse()
      click(outerbox.find("@comboitem").eq(2).toWidget())
      waitResponse()
      click(showselect)
      waitResponse()
      verifyEquals("2", min.attr("value"))
      // verifyEquals("2", max.attr("value"))
      click(clean)
      waitResponse()
      verifyEquals("", outerbox.toWidget().attr("value"))
      click(showselect)
      waitResponse()
      verifyEquals("-1", min.attr("value"))
      // verifyEquals("-1", max.attr("value"))
      click(select)
      waitResponse()
      verifyEquals("B", outerbox.toWidget().attr("value"))
      click(showselect)
      waitResponse()
      verifyEquals("1", min.attr("value"))
      // verifyEquals("1", max.attr("value"))
    })
  }
}

