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
import java.util.ArrayList

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_F00743_2Test extends ZTL4ScalaTestCase {

  def getSelectedIndexes(listbox: Widget): Any = {
    var list = new ArrayList[String]()
    var index = 0
    var w = listbox.firstChild() // maybe include header
    for (i <- 0 to listbox.nChildren() - 1) {
      if ("listitem".equals(w.eval("widgetName"))) {
        if (w.is("selected"))
          list.add(index + "")
        index = index + 1

      }
      w = w.nextSibling()
    }
    var indexes = new Array[String](list.size())
    for (i <- 0 to indexes.length - 1)
      indexes(i) = list.get(i).toString()
    indexes
  }

  @Test
  def testIssue() = {
    val zul = """
      <include src="/bind/issue/F00743_2.zul"/>
"""

    runZTL(zul, () => {
      var outerbox = jq("$outerbox")
      var range = jq("$range")
      var clean = jq("$clean")
      var select = jq("$select")
      var reload = jq("$reload")
      var select0 = jq("$select0")
      var showselect = jq("$showselect")
      click(outerbox.find("@listitem").eq(0).toWidget())
      waitResponse()
      click(outerbox.find("@listitem").eq(2).toWidget())
      waitResponse()
      click(showselect.toWidget())
      waitResponse()
      verifyEquals("[A, C]", range.toWidget().get("value"))
      click(clean.toWidget())
      waitResponse()
      verifyEquals(new Array[String](0), getSelectedIndexes(outerbox.toWidget()))
      click(showselect.toWidget())
      waitResponse()
      verifyEquals("[]", range.toWidget().get("value"))
      click(outerbox.find("@listitem").eq(2).toWidget())
      waitResponse()
      click(outerbox.find("@listitem").eq(4).toWidget())
      waitResponse()
      click(showselect.toWidget())
      waitResponse()
      verifyEquals("[C, E]", range.toWidget().get("value"))
      click(select.toWidget())
      waitResponse()
      // verifyArrayEquals(new long[]{1L,3L}, ListboxUtil.getSelectedIndexs(outerbox))
      click(showselect.toWidget())
      waitResponse()
      verifyEquals("[B, D]", range.toWidget().get("value"))
      click(select0.toWidget())
      waitResponse()
      // verifyArrayEquals(new long[]{0L,1L}, ListboxUtil.getSelectedIndexs(outerbox))
      click(showselect.toWidget())
      waitResponse()
      verifyEquals("[A, B]", range.toWidget().get("value"))
      click(reload.toWidget())
      waitResponse()
      // verifyArrayEquals(new long[]{0L,1L}, ListboxUtil.getSelectedIndexs(outerbox))
      click(showselect.toWidget())
      waitResponse()
      verifyEquals("[A, B]", range.toWidget().get("value"))
    })
  }
}

