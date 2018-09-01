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
import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_TemplateListbox2Test extends ZTL4ScalaTestCase {
  @Test
  def testArg() = {
    val zul = """
      <include src="bind/basic/collection-template-listbox.zul"/>
"""

    runZTL(zul, () => {
      var outerbox = jq("$outerbox").toWidget()
      var outeritems = outerbox.firstChild() // include header
      // =================================delete 2rd row
      var outeritem = outeritems.nextSibling().nextSibling() // header -> 0 -> 1
      click(jq(outeritem).find("@button").eq(1)) // click the delete button on 2nd row
      waitResponse()
      outerbox = jq("$outerbox").toWidget()
      outeritems = outerbox.firstChild() // include header
      var itemLabel = Array("A", "C", "D")
      verifyEquals(3, outerbox.nChildren() - 1)
      outeritem = outeritems

      for (i <- 0 to itemLabel.length - 1) {
        outeritem = outeritem.nextSibling()
        var outerl = itemLabel(i)
        var cell = outeritem.firstChild()
        verifyEquals("" + i, cell.attr("label")) // verify the index
        cell = cell.nextSibling()
        verifyEquals(outerl, cell.attr("label")) // verify the label
        var innerbox = jq(outeritem).find("@listbox").toWidget()
        verifyTrue(innerbox.exists())
        var inneritems = jq(innerbox).find("@listitem")
        verifyEquals(2, inneritems.length())
        for (j <- 0 to 1) {
          var inneritem = inneritems.eq(j).toWidget()
          cell = inneritem.firstChild()
          verifyEquals("" + j, cell.attr("label"))
          cell = cell.nextSibling()
          verifyEquals("" + i, cell.attr("label"))
          var innerl = itemLabel(i) + " " + j
          cell = cell.nextSibling()
          verifyEquals(innerl, cell.attr("label"))
        }
        cell = outeritem.lastChild().previousSibling()
        var btn = jq(cell).find("@button").toWidget() // index button
        var msg = jq("$msg").toWidget()
        click(btn)
        waitResponse()
        verifyEquals("item index " + i, msg.attr("value"))
        // verify template
        cell = outeritem.lastChild()
        if (i == 0 || i == 2) {
          verifyEquals("Model1", cell.attr("label"))
        } else {
          verifyEquals("Model2", cell.attr("label"))
        }
      }
      // ===============================add after row
      outeritems = outerbox.firstChild()
      outeritem = outeritems.nextSibling().nextSibling() // header -> 0 -> 1
      click(jq(outeritem).find("@button").eq(2)) // click the add after button on 2nd row
      waitResponse()
      outerbox = jq("$outerbox").toWidget()
      outeritems = outerbox.firstChild() // include header
      itemLabel = Array("A", "C", "C1", "D")
      verifyEquals(4, outerbox.nChildren() - 1)
      outeritem = outeritems
      for (i <- 0 to itemLabel.length - 1) {
        outeritem = outeritem.nextSibling()
        var outerl = itemLabel(i)
        var cell = outeritem.firstChild()
        verifyEquals("" + i, cell.attr("label")) // verify the index
        cell = cell.nextSibling()
        verifyEquals(outerl, cell.attr("label")) // verify the label
        // verify template
        cell = outeritem.lastChild()
        if (i == 0 || i == 2) {
          verifyEquals("Model1", cell.attr("label"))
        } else {
          verifyEquals("Model2", cell.attr("label"))
        }
      }
      // ===============================add add before row
      outeritems = outerbox.firstChild()
      outeritem = outeritems.nextSibling().nextSibling().nextSibling() // header -> 0 -> 1 -> 2
      click(jq(outeritem).find("@button").eq(3)) // click the add before button on 2nd row
      waitResponse()
      outerbox = jq("$outerbox").toWidget()
      outeritems = outerbox.firstChild() // include header
      itemLabel = Array("A", "C", "C12", "C1", "D")
      verifyEquals(5, outerbox.nChildren() - 1)
      outeritem = outeritems
      for (i <- 0 to itemLabel.length - 1) {
        outeritem = outeritem.nextSibling()
        var outerl = itemLabel(i)
        var cell = outeritem.firstChild()
        verifyEquals("" + i, cell.attr("label")) // verify the index
        cell = cell.nextSibling()
        verifyEquals(outerl, cell.attr("label")) // verify the label
        // verify template
        cell = outeritem.lastChild()
        if (i == 0 || i == 2) {
          verifyEquals("Model1", cell.attr("label"))
        } else {
          verifyEquals("Model2", cell.attr("label"))
        }
      }
    })
  }
}

