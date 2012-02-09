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

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00762Listbox1Test extends ZTL4ScalaTestCase {

  def getIndex(listbox: Widget): Int = {
    var index = -1
    var listitems = listbox.firstChild() // include header
    for (i <- 0 to listbox.nChildren() - 2) {
      listitems = listitems.nextSibling();
      if (listitems.is("selected"))
        index = i
    }
    index
  }
  
  def testArg() = {
    val zul = {
      <include src="/bind/issue/B00762Listbox1.zul"/>
    }

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
      verifyEquals("-1", getIndex(outerbox.toWidget()));
      verifyEquals("", selected.toWidget().get("value"))
      click(showselect.toWidget())
      waitResponse()
      verifyEquals("-1", min.toWidget().get("value"))
      //      verifyEquals("-1", max.toWidget().get("value"))
      click(select.toWidget())
      waitResponse()
      verifyEquals("1", getIndex(outerbox.toWidget()))
      verifyEquals("B", selected.toWidget().get("value"))
      click(showselect.toWidget())
      waitResponse()
      verifyEquals("1", min.toWidget().get("value"))
      //      verifyEquals("1", max.toWidget().get("value"))
    })
  }

}