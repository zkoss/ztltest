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
import org.zkoss.ztl.{Tags, Widget}

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00762Listbox1Test extends ZTL4ScalaTestCase {

  def getListboxSelectedIndex(listbox: Widget): String = {
    var outeritems = listbox.firstChild() // include header
    var index = 0
    var w = outeritems
    for (i <- 0 to listbox.nChildren() - 1) {
      if ("listitem".equals(w.eval("widgetName"))) {
        if (w.is("selected"))
          return index + ""
        index = index + 1
      }
      w = w.nextSibling()
    }
    "-1"
  }

  @Test
  def testArg() = {
    val zul = """
      <include src="/bind/issue/B00762Listbox1.zul"/>
"""

    runZTL(zul, () => {
      var outerbox = jq("$outerbox")
      var selected = jq("$selected")
      var min = jq("$min")
      //      var max = jq("$max")
      var clean = jq("$clean")
      var select = jq("$select")
      var showselect = jq("$showselect")
      click(outerbox.find("@listitem").eq(0).toWidget())
      waitResponse()
      verifyEquals("A", selected.toWidget().get("value"))
      click(showselect.toWidget())
      waitResponse()
      verifyEquals("0", min.toWidget().get("value"))
      //      verifyEquals("0", max.toWidget().get("value"))
      click(outerbox.find("@listitem").eq(2).toWidget())
      waitResponse()
      verifyEquals("C", selected.toWidget().get("value"))
      click(showselect.toWidget())
      waitResponse()
      verifyEquals("2", min.toWidget().get("value"))
      //      verifyEquals("2", max.toWidget().get("value"))
      click(clean.toWidget())
      waitResponse()
      verifyEquals("-1", getListboxSelectedIndex(outerbox.toWidget()));
      verifyEquals("", selected.toWidget().get("value"))
      click(showselect.toWidget())
      waitResponse()
      verifyEquals("-1", min.toWidget().get("value"))
      //      verifyEquals("-1", max.toWidget().get("value"))
      click(select.toWidget())
      waitResponse()
      verifyEquals("1", getListboxSelectedIndex(outerbox.toWidget()))
      verifyEquals("B", selected.toWidget().get("value"))
      click(showselect.toWidget())
      waitResponse()
      verifyEquals("1", min.toWidget().get("value"))
      //      verifyEquals("1", max.toWidget().get("value"))
    })
  }

}
