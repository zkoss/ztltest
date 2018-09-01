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
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_CollectionIndexDefaultTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/basic/collection-index-default.zul"/>
"""

    runZTL(zul, () => {
      var listbox = jq("$listbox")
      var outeritems = listbox.toWidget().firstChild() //include header

      var itemLabel = Array("A", "B", "C", "D")
      verifyEquals(4, listbox.toWidget().nChildren() - 1)

      var outeritem = outeritems
      for (i <- 0 to 3) {
        outeritem = outeritem.nextSibling()
        var outerl = itemLabel(i)

        var cell = outeritem.firstChild()
        verifyEquals("" + i, cell.attr("label")) // verify the index
        cell = cell.nextSibling()
        verifyEquals(outerl, cell.attr("label")) //verify the label
      }

      var grid = jq("$grid")
      var outerrows = grid.find("@rows").toWidget().firstChild()

      verifyEquals(4, grid.find("@rows").toWidget().nChildren())

      var outerrow = outerrows
      for (i <- 0 to 3) {
        var outerl = itemLabel(i)

        var rowkid = outerrow.firstChild()
        verifyEquals("" + i, rowkid.attr("value")) // verify the index  on label
        rowkid = rowkid.nextSibling()
        verifyEquals(outerl, rowkid.attr("value")) //verify the label on label
        outerrow = outerrow.nextSibling()
      }

      var combobox = jq("$combobox")
      combobox.toWidget().eval("open()") //to show popu first so we can find comboitem in zkmax
      waitResponse()
      var comboitems = combobox.find("@comboitem")
      verifyEquals(4, comboitems.length())
      for (i <- 0 to 3) {
        var comboitem = comboitems.eq(i).toWidget()
        verifyEquals(itemLabel(i), comboitem.attr("label"))
        verifyEquals("" + i, comboitem.attr("description"))
      }

    })
  }
}