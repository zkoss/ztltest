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
class Z60_CollectionIndexListbox2Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/basic/collection-index-listbox.zul"/>
"""

    runZTL(zul, () => {
      var outerbox = jq("$outerbox").toWidget()
      // =================================delete 2rd row
      var outeritem = outerbox.firstChild().nextSibling() // skip header
      outeritem = outeritem.nextSibling() // 2nd row
      click(jq(outeritem).find("@button").get(1)) // click the delete button on 2nd row
      waitResponse()
      outerbox = jq("$outerbox").toWidget()
      outeritem = outerbox.firstChild() // header will be skipped
      var itemLabel = Array("A", "C", "D")
      verifyEquals(itemLabel.length, outerbox.nChildren() - 1) // don't care header
      for (i <- 0 to itemLabel.length - 1) {
        outeritem = outeritem.nextSibling()
        val outerl = itemLabel(i)
        var cell = outeritem.firstChild()
        verifyEquals("" + i, cell.attr("label")) // verify the index
        cell = cell.nextSibling()
        verifyEquals(outerl, cell.attr("label")) // verify the label
        val innerbox = jq(outeritem).find("@listbox").toWidget()
        verifyTrue(innerbox.exists())
        val inneritems = jq(innerbox).find("@listitem")
        verifyEquals(2, inneritems.length())
        var inneritem = inneritems.first()
        for (j <- 0 to 1) {
          cell = inneritem.toWidget().firstChild()
          verifyEquals("" + j, cell.attr("label"))
          cell = cell.nextSibling()
          verifyEquals("" + i, cell.attr("label"))
          val innerl = itemLabel(i) + " " + j
          cell = cell.nextSibling()
          verifyEquals(innerl, cell.attr("label"))
          inneritem = inneritem.next()
        }
        cell = outeritem.lastChild()
        val btn = jq(cell).find("@button").toWidget() // index button
        val msg = jq("$msg").toWidget()
        click(btn)
        waitResponse()
        verifyEquals("item index " + i, msg.attr("value"))
      }
      // ===============================add after row
      outeritem = outerbox.firstChild().nextSibling() // skip header
      outeritem = outeritem.nextSibling() // 2nd row
      click(jq(outeritem).find("@button").get(2)) // click the add after button on 2nd row
      waitResponse()
      outerbox = jq("$outerbox").toWidget()
      outeritem = outerbox.firstChild() // header will be skipped
      itemLabel = Array("A", "C", "C1", "D")
      verifyEquals(itemLabel.length, outerbox.nChildren() - 1) // don't care header
      for (i <- 0 to itemLabel.length - 1) {
        outeritem = outeritem.nextSibling()
        val outerl = itemLabel(i)
        var cell = outeritem.firstChild()
        verifyEquals("" + i, cell.attr("label")) // verify the index
        cell = cell.nextSibling()
        verifyEquals(outerl, cell.attr("label")) // verify the label
        val innerbox = jq(outeritem).find("@listbox").toWidget()
        verifyTrue(innerbox.exists())
        val inneritems = jq(innerbox).find("@listitem")
        verifyEquals(2, inneritems.length())
        var inneritem = inneritems.first()
        for (j <- 0 to 1) {
          cell = inneritem.toWidget().firstChild()
          verifyEquals("" + j, cell.attr("label"))
          cell = cell.nextSibling()
          verifyEquals("" + i, cell.attr("label"))
          val innerl = itemLabel(i) + " " + j
          cell = cell.nextSibling()
          verifyEquals(innerl, cell.attr("label"))
          inneritem = inneritem.next()
        }
        cell = outeritem.lastChild()
        val btn = jq(cell).find("@button").toWidget() // index button
        val msg = jq("$msg").toWidget()
        click(btn)
        waitResponse()
        verifyEquals("item index " + i, msg.attr("value"))
      }
      // ===============================add add before row
      outeritem = outerbox.firstChild().nextSibling() // skip header
      outeritem = outeritem.nextSibling().nextSibling() // 3nd row
      click(jq(outeritem).find("@button").get(3)) // click the add after button on 2nd row
      waitResponse()
      outerbox = jq("$outerbox").toWidget()
      outeritem = outerbox.firstChild() // header will be skipped
      itemLabel = Array("A", "C", "C12", "C1", "D")
      verifyEquals(itemLabel.length, outerbox.nChildren() - 1) // don't care header
      for (i <- 0 to itemLabel.length - 1) {
        outeritem = outeritem.nextSibling()
        val outerl = itemLabel(i)
        var cell = outeritem.firstChild()
        verifyEquals("" + i, cell.attr("label")) // verify the index
        cell = cell.nextSibling()
        verifyEquals(outerl, cell.attr("label")) // verify the label
        val innerbox = jq(outeritem).find("@listbox").toWidget()
        verifyTrue(innerbox.exists())
        val inneritems = jq(innerbox).find("@listitem")
        verifyEquals(2, inneritems.length())
        var inneritem = inneritems.first()
        for (j <- 0 to 1) {
          cell = inneritem.toWidget().firstChild()
          verifyEquals("" + j, cell.attr("label"))
          cell = cell.nextSibling()
          verifyEquals("" + i, cell.attr("label"))
          val innerl = itemLabel(i) + " " + j
          cell = cell.nextSibling()
          verifyEquals(innerl, cell.attr("label"))
          inneritem = inneritem.next()
        }
        cell = outeritem.lastChild()
        val btn = jq(cell).find("@button").toWidget() // index button
        val msg = jq("$msg").toWidget()
        click(btn)
        waitResponse()
        verifyEquals("item index " + i, msg.attr("value"))
      }
    })
  }
}