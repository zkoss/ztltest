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
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_F00843SelectedboxSelectedItemTest extends ZTL4ScalaTestCase {

  def getSelectedIndex(listbox: Widget): String = {
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

  def testArg() = {
    val zul = """
      <include src="/bind/issue/F00843SelectboxSelectedItem.zul"/>
"""

    runZTL(zul, () => {

      var selectbox = jq("$selectbox")
      var listbox = jq("$listbox")
      var combobox = jq("$combobox")
      var l1 = jq("$l1")

      click(listbox.find("@listitem").eq(1))
      waitResponse()

      verifyEquals("1", getSelectedIndex(listbox.toWidget()))
      verifyEquals("1", selectbox.toWidget().get("selectedIndex"))
      verifyEquals("B", combobox.toWidget().get("value"))
      verifyEquals("B", combobox.toWidget().get("value"))

      click(listbox.find("@listitem").eq(2))
      waitResponse()

      verifyEquals("2", getSelectedIndex(listbox.toWidget()))
      verifyEquals("2", selectbox.toWidget().get("selectedIndex"))
      verifyEquals("C", combobox.toWidget().get("value"))
      verifyEquals("C", l1.toWidget().get("value"))

    })
  }
}