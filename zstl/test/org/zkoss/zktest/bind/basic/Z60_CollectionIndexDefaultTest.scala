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
      verifyEquals(itemLabel.length, listbox.toWidget().nChildren() - 1)

      var outeritem = outeritems
      for (i <- 0 to itemLabel.length - 1) {
        outeritem = outeritem.nextSibling()
        var outerl = itemLabel(i)

        var cell = outeritem.firstChild()
        verifyEquals("" + i, cell.get("label")) // verify the index
        cell = cell.nextSibling()
        verifyEquals(outerl, cell.get("label")) //verify the label
      }

      var grid = jq("$grid")
      var outerrows = grid.find("@rows").toWidget().firstChild()

      verifyEquals(itemLabel.length, grid.find("@rows").toWidget().nChildren())

      var outerrow = outerrows
      for (i <- 0 to itemLabel.length - 1) {
        var outerl = itemLabel(i)

        var rowkid = outerrow.firstChild()
        verifyEquals("" + i, rowkid.get("value")) // verify the index  on label
        rowkid = rowkid.nextSibling()
        verifyEquals(outerl, rowkid.get("value")) //verify the label on label
        outerrow = outerrow.nextSibling()
      }

      var combobox = jq("$combobox")
      combobox.toWidget().eval("open()") //to show popu first so we can find comboitem in zkmax
      waitResponse()
      var comboitems = combobox.find("@comboitem")
      verifyEquals(itemLabel.length, comboitems.length())
      for (i <- 0 to itemLabel.length - 1) {
        var comboitem = comboitems.eq(i).toWidget()
        verifyEquals(itemLabel(i), comboitem.get("label"))
        verifyEquals("" + i, comboitem.get("description"))
      }

    })
  }
}