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
package org.zkoss.zktest.bind.basic
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_ListboxModelSelectionTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/basic/listboxmodel.zul"/>
"""

    runZTL(zul, () => {
      var msg = jq("$msg").toWidget()
      var outerbox = jq("$outerbox").toWidget()
      var outeritems = outerbox.firstChild() // include header
      outeritems = outeritems.nextSibling() // don't care header
      var outeritem = outeritems.nextSibling() // select 2nd
      clickAt(outeritem.firstChild(), "2,2") // click on listitem is not work if it has listbox inside, (it will click on the inside listbox)
      waitResponse()
      // verifyEquals("1", outerbox.attr("selectedIndex"))
      verifyEquals(1, getListboxSelectedIndex(outerbox))
      verifyEquals("", msg.attr("value"))
      click(jq("$btn1").toWidget())
      waitResponse()
      // verifyEquals(1L, outerbox.getAttribute("selectedIndex")) // fail in max
      outeritems = outerbox.firstChild() // include header
      outeritems = outeritems.nextSibling() // don't care header
      outeritem = outeritems.nextSibling() // select 2nd
      // verifyEquals(outeritem.uuid(), outerbox.eval("getSelectedItem().uuid"))
      verifyEquals(outeritem.uuid(), jq(outerbox).find(".z-listitem-selected").toWidget().uuid())
      verifyEquals("reloaded", msg.attr("value"))
    })
  }

  def getListboxSelectedIndex(listbox: Widget): Int = {
    var listitems = listbox.firstChild(); // include header
    var selectedIndex = -1;
    for (i <- 0 to 3) {
      listitems = listitems.nextSibling();
      if (listitems.is("selected")) {
        selectedIndex = i;
      }
    }
    return selectedIndex;
  }
}