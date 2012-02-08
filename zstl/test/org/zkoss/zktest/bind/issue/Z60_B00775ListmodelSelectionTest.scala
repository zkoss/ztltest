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
class Z60_B00775ListmodelSelectionTest extends ZTL4ScalaTestCase {

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

  def testArg() = {
    val zul = {
      <include src="/bind/issue/B00775ListmodelSelection.zul"/>
    }

    runZTL(zul, () => {

      var listbox = jq("$listbox")
      var header = jq("$header")
      var shrink = jq("$shrink")

      click(header.toWidget())
      waitResponse()
      click(header.toWidget()) // twice
      waitResponse()

      click(listbox.find("@listitem").eq(8).toWidget())
      waitResponse()
      verifyEquals("8", getListboxSelectedIndex(listbox.toWidget()))

      click(shrink.toWidget())
      waitResponse()
      verifyEquals("0", getListboxSelectedIndex(listbox.toWidget()))

    })
  }
}
