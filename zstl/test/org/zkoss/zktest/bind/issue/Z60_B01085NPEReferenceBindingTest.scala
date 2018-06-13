/* Z60_B01085NPEReferenceBindingTest.scala



	Purpose:
		
	Description:
		
	History:
		Apr 27, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.zktest.bind.issue
import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.unit.Widget

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B01085NPEReferenceBindingTest extends ZTL4ScalaTestCase {

  @Test
  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01085NPEReferenceBinding.zul"/>
"""

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
runZTL(zul, () => {

      var listbox1 = jq("$listbox1")
      var listbox2 = jq("$listbox2")
      var listbox3 = jq("$listbox3")
      var listbox4 = jq("$listbox4")
      var listbox5 = jq("$listbox5")
      var listbox6 = jq("$listbox6")

      var lb1 = jq("$lb1")
      var lb2 = jq("$lb2")

      verifyEquals(-1L, getSelectedIndex(listbox1.toWidget()))
      verifyEquals(-1L, getSelectedIndex(listbox2.toWidget()))
      verifyEquals(-1L, getSelectedIndex(listbox3.toWidget()))
      verifyEquals("", lb1.toWidget().get("value"))

      verifyEquals(1L, getSelectedIndex(listbox4.toWidget()))
      verifyEquals(1L, getSelectedIndex(listbox5.toWidget()))
      verifyEquals(1L, getSelectedIndex(listbox6.toWidget()))
      verifyEquals("1", lb2.toWidget().get("value"))

      click(listbox1.find("@listitem").eq(0).toWidget())
      waitResponse()
      verifyEquals(0L, getSelectedIndex(listbox2.toWidget()))
      verifyEquals(0L, getSelectedIndex(listbox3.toWidget()))
      verifyEquals("0", lb1.toWidget().get("value"))

      click(listbox2.find("@listitem").eq(1).toWidget())
      waitResponse()
      verifyEquals(1L, getSelectedIndex(listbox1.toWidget()))
      verifyEquals(1L, getSelectedIndex(listbox3.toWidget()))
      verifyEquals("1", lb1.toWidget().get("value"))

      click(listbox3.find("@listitem").eq(2).toWidget())
      waitResponse()
      verifyEquals(2L, getSelectedIndex(listbox1.toWidget()))
      verifyEquals(2L, getSelectedIndex(listbox2.toWidget()))
      verifyEquals("2", lb1.toWidget().get("value"))

      click(listbox4.find("@listitem").eq(0).toWidget())
      waitResponse()
      verifyEquals(1L, getSelectedIndex(listbox5.toWidget()))
      verifyEquals(1L, getSelectedIndex(listbox6.toWidget()))
      verifyEquals("1", lb2.toWidget().get("value"))
      verifyEquals(1, jq(".z-window-modal").length())
      click(jq(".z-window-modal @button").toWidget())
      waitResponse()

      click(listbox5.find("@listitem").eq(0).toWidget())
      waitResponse()
      verifyEquals(0L, getSelectedIndex(listbox4.toWidget()))
      verifyEquals(1L, getSelectedIndex(listbox6.toWidget()))
      verifyEquals("1", lb2.toWidget().get("value"))
      verifyEquals(1, jq(".z-window-modal").length())
      click(jq(".z-window-modal @button").toWidget())
      waitResponse()

      click(listbox6.find("@listitem").eq(0).toWidget())
      waitResponse()
      verifyEquals(0L, getSelectedIndex(listbox4.toWidget()))
      verifyEquals(0L, getSelectedIndex(listbox5.toWidget()))
      verifyEquals("1", lb2.toWidget().get("value"))
      verifyEquals(1, jq(".z-window-modal").length())
      click(jq(".z-window-modal @button").toWidget())
      waitResponse()

    })
  }
}
