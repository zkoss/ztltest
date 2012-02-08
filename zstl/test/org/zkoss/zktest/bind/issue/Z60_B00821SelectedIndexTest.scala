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
import org.zkoss.ztl.Widget
import java.util.ArrayList
import org.zkoss.ztl.ZKSeleneseTestCase

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00821SelectedIndexTest extends ZTL4ScalaTestCase {

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
    val zul = {
      <include src="/bind/issue/B00821SelectedIndex.zul"/>
    }

    runZTL(zul, () => {

      var selectbox = jq("$selectbox").toWidget()
      var listbox = jq("$listbox").toWidget()
      var combobox = jq("$combobox").toWidget()
      var i1 = jq("$i1").toWidget()
      `type`(i1, "1")
      waitResponse()
      verifyEquals("1", getSelectedIndex(listbox))
      verifyEquals("1", selectbox.get("selectedIndex"))
      verifyEquals("B", combobox.get("value"))
      `type`(i1, "2")
      waitResponse()
      verifyEquals("2", getSelectedIndex(listbox))
      verifyEquals("2", selectbox.get("selectedIndex"))
      verifyEquals("C", combobox.get("value"))

    })
  }
}
