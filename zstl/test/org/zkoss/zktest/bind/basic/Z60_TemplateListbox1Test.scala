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
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_TemplateListbox1Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="bind/basic/collection-template-listbox.zul"/>
"""

    runZTL(zul, () => {
      var outerbox = jq("$outerbox")
      var outeritems = outerbox.toWidget().firstChild() // include header
      outeritems = outeritems.nextSibling() // don't care header
      var itemLabel = Array("A", "B", "C", "D")
      verifyEquals(itemLabel.length, outerbox.toWidget().nChildren() - 1)
      var outeritem = outeritems
      for (i <- 0 to itemLabel.length - 1) {
        var outerl = itemLabel(i)
        var cell = outeritem.firstChild()
        verifyEquals("" + i, cell.get("label")) // verify the index
        cell = cell.nextSibling()
        verifyEquals(outerl, cell.get("label")) // verify the label
        var innerbox = jq(outeritem).find("@listbox").toWidget()
        verifyTrue(innerbox.exists())
        var inneritems = jq(innerbox).find("@listitem")
        verifyEquals(2, inneritems.length())
        for (j <- 0 to 1) {
          var inneritem = inneritems.eq(j).toWidget()
          cell = inneritem.firstChild()
          verifyEquals("" + j, cell.get("label"))
          cell = cell.nextSibling()
          verifyEquals("" + i, cell.get("label"))
          var innerl = itemLabel(i) + " " + j
          cell = cell.nextSibling()
          verifyEquals(innerl, cell.get("label"))
        }
        cell = outeritem.lastChild().previousSibling()
        var btn = jq(cell).find("@button").toWidget() // index button
        var msg = jq("$msg").toWidget()
        click(btn)
        waitResponse()
        verifyEquals("item index " + i, msg.get("value"))
        // verify template
        cell = outeritem.lastChild()
        if (i == 0 || i == 2)
          verifyEquals("Model1", cell.get("label"))
        else
          verifyEquals("Model2", cell.get("label"))
        outeritem = outeritem.nextSibling()
      }
    })
  }
}