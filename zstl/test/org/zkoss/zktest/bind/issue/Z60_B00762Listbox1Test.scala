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

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00762Listbox1Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = {
      <include src="/bind/issue/B00762Listbox1.zul"/>
    }

    runZTL(zul, () => {
      var outerbox = jq("$outerbox")
      var selected = jq("$selected")
      var min = jq("$min")
      var max = jq("$max")
      var clean = jq("$clean")
      var select = jq("$select")
      var reload = jq("$reload")
      var select0 = jq("$select0")
      var showselect = jq("$showselect")
      click(outerbox.find("@listitem").eq(0).toWidget())
      waitResponse(true)
      verifyEquals("A", selected.toWidget().get("value"))
      click(showselect.toWidget())
      waitResponse(true)
      verifyEquals("0", min.toWidget().get("value"))
      verifyEquals("0", max.toWidget().get("value"))
      click(outerbox.find("@listitem").eq(2).toWidget())
      waitResponse(true)
      verifyEquals("C", selected.toWidget().get("value"))
      click(showselect.toWidget())
      waitResponse(true)
      verifyEquals("2", min.toWidget().get("value"))
      verifyEquals("2", max.toWidget().get("value"))
      click(clean.toWidget())
      waitResponse(true)
      var listitems = outerbox.toWidget().firstChild() // include header
      var index = "-1"
      for (i <- 0 to listitems.nChildren() - 1) {
        listitems = listitems.nextSibling()
        if (listitems.is("selected"))
          index = i + ""
      }
      verifyEquals("-1", index);
      verifyEquals("", selected.toWidget().get("value"))
      click(showselect.toWidget())
      waitResponse(true)
      verifyEquals("-1", min.toWidget().get("value"))
      verifyEquals("-1", max.toWidget().get("value"))
      click(select.toWidget())
      waitResponse(true)
      listitems = outerbox.toWidget().firstChild() // include header
      index = "-1"
      for (i <- 0 to listitems.nChildren() - 1) {
        listitems = listitems.nextSibling()
        if (listitems.is("selected"))
          index = i + ""
      }
      verifyEquals("1", index)
      verifyEquals("B", selected.toWidget().get("value"))
      click(showselect.toWidget())
      waitResponse(true)
      verifyEquals("1", min.toWidget().get("value"))
      verifyEquals("1", max.toWidget().get("value"))
      click(select0.toWidget())
      waitResponse(true)
      listitems = outerbox.toWidget().firstChild() // include header
      index = "-1"
      for (i <- 0 to listitems.nChildren() - 1) {
        listitems = listitems.nextSibling()
        if (listitems.is("selected"))
          index = i + ""
      }
      verifyEquals("0", index);
      verifyEquals("B", selected.toWidget().get("value")) // still in B
      click(showselect.toWidget())
      waitResponse(true)
      verifyEquals("0", min.toWidget().get("value"))
      verifyEquals("0", max.toWidget().get("value"))
      click(reload.toWidget())
      waitResponse(true)
      listitems = outerbox.toWidget().firstChild() // include header
      index = "-1"
      for (i <- 0 to listitems.nChildren() - 1) {
        listitems = listitems.nextSibling()
        if (listitems.is("selected"))
          index = i + ""
      }
      verifyEquals("1", index);
      verifyEquals("B", selected.toWidget().get("value"))
      click(showselect.toWidget())
      waitResponse(true)
      verifyEquals("1", min.toWidget().get("value"))
      verifyEquals("1", max.toWidget().get("value"))
    })
  }

}
