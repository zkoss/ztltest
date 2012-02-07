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

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Widget

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_F00743_2Test extends ZTL4ScalaTestCase {

  def getListboxSelectedIndexes(listbox: Widget): ArrayList[String] = {
    var indexes = new ArrayList[String]()
    var listitems = listbox.firstChild() // include header
    for (i <- 0 to listbox.nChildren() - 2) {
      listitems = listitems.nextSibling()
      if (listitems.is("selected"))
        indexes.add(i + "")
    }
    indexes
  }

  def testIssue() = {
    val zul = {
      <include src="/bind/issue/F00743_2.zul"/>
    }

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
      var indexes = getListboxSelectedIndexes(outerbox.toWidget())
      var array = new Array[String](0)
      for (i <- 0 to array.length - 1)
        verifyEquals(array(i), indexes.get(i))
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

