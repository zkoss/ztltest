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
class Z60_B00762Combobox1Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = """
      <include src="/bind/issue/B00762Combobox1.zul"/>
"""

    runZTL(zul, () => {
      var outerbox = jq("$outerbox")
      var selected = jq("$selected").toWidget()
      var min = jq("$min").toWidget()
      // var max = jq("$max")
      var clean = jq("$clean").toWidget()
      var select = jq("$select").toWidget()
      var reload = jq("$reload").toWidget()
      var showselect = jq("$showselect").toWidget()
      outerbox.toWidget().eval("open()")
      waitResponse()
      click(outerbox.find("@comboitem").eq(0).toWidget())
      waitResponse()
      verifyEquals("A", selected.get("value"))
      click(showselect)
      waitResponse()
      verifyEquals("0", min.get("value"))
      // verifyEquals("0", max.get("value"))
      outerbox.toWidget().eval("open()")
      waitResponse()
      click(outerbox.find("@comboitem").get(2))
      waitResponse()
      verifyEquals("C", selected.get("value"))
      click(showselect)
      waitResponse()
      verifyEquals("2", min.get("value"))
      // verifyEquals("2", max.get("value"))
      click(clean)
      waitResponse()
      verifyEquals("", outerbox.toWidget().get("value"))
      verifyEquals("", selected.get("value"))
      click(showselect)
      waitResponse()
      verifyEquals("-1", min.get("value"))
      // verifyEquals("-1", max.get("value"))
      click(select)
      waitResponse()
      verifyEquals("B", outerbox.toWidget().get("value"))
      verifyEquals("B", selected.get("value"))
      click(showselect)
      waitResponse()
      verifyEquals("1", min.get("value"))
      // verifyEquals("1", max.get("value"))
    })
  }
}
