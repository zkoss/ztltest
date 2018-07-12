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
class Z60_listboxModelTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """ 
      <include src="/bind/basic/listboxmodel.zul" />
"""

    runZTL(zul, () => {
      var outerbox = jq("$outerbox")
      // =================================delete 2rd row
      var outeritems = outerbox.toWidget().firstChild() // include header
      outeritems = outeritems.nextSibling() // don't care header
      var outeritem = outeritems.nextSibling()
      click(jq(outeritem).find("@button").eq(1).toWidget()) // click the delete button on 2nd row
      waitResponse()
      outerbox = jq("$outerbox")
      outeritems = outerbox.toWidget().firstChild() // include header
      outeritems = outeritems.nextSibling() // don't care header
      var itemLabel = Array("A", "C", "D");
      verifyEquals(itemLabel.length, outerbox.toWidget().nChildren() - 1)
      outeritem = outeritems
      for (i <- 0 to itemLabel.length - 1) {
        var outerl = itemLabel(i)
        var cell = outeritem.firstChild()
        verifyEquals("" + i, cell.attr("label")) // verify the index
        cell = cell.nextSibling()
        verifyEquals(outerl, cell.attr("label")) // verify the label
        var innerbox = jq(outeritem).find("@listbox")
        verifyTrue(innerbox.toWidget().exists())
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
        cell = outeritem.lastChild()
        var btn = jq(cell).find("@button") // index button
        click(btn.toWidget())
        waitResponse()
        var msg = jq("$msg")
        verifyEquals("item index " + i, msg.toWidget().attr("value"))
        outeritem = outeritem.nextSibling()
      }
      // ===============================add after row
      outeritems = outerbox.toWidget().firstChild() // include header
      outeritems = outeritems.nextSibling() // don't care header
      outeritem = outeritems.nextSibling()
      click(jq(outeritem).find("@button").eq(2).toWidget()) // click the add after button on 2nd row
      waitResponse()
      outerbox = jq("$outerbox")
      outeritems = outerbox.toWidget().firstChild() // include header
      outeritems = outeritems.nextSibling() // don't care header
      itemLabel = Array("A", "C", "C1", "D")
      verifyEquals(itemLabel.length, outerbox.toWidget().nChildren() - 1)
      outeritem = outeritems
      for (i <- 0 to itemLabel.length - 1) {
        var outerl = itemLabel(i)
        var cell = outeritem.firstChild()
        verifyEquals("" + i, cell.attr("label")) // verify the index
        cell = cell.nextSibling()
        verifyEquals(outerl, cell.attr("label")) // verify the label
        var innerbox = jq(outeritem).find("@listbox")
        verifyTrue(innerbox.toWidget().exists())
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
        cell = outeritem.lastChild()
        var btn = jq(cell).find("@button") // index button
        click(btn.toWidget())
        waitResponse()
        var msg = jq("$msg")
        verifyEquals("item index " + i, msg.toWidget().attr("value"))
        outeritem = outeritem.nextSibling()
      }
      // ===============================add add before row
      outeritems = outerbox.toWidget().firstChild() // include header
      outeritems = outeritems.nextSibling() // don't care header
      outeritem = outeritems.nextSibling().nextSibling()
      click(jq(outeritem).find("@button").eq(3).toWidget()) // click the add before button on 2nd row
      waitResponse()
      outerbox = jq("$outerbox")
      outeritems = outerbox.toWidget().firstChild() // include header
      outeritems = outeritems.nextSibling() // don't care header
      itemLabel = Array("A", "C", "C12", "C1", "D")
      verifyEquals(itemLabel.length, outerbox.toWidget().nChildren() - 1)
      outeritem = outeritems
      for (i <- 0 to itemLabel.length - 1) {
        var outerl = itemLabel(i)
        var cell = outeritem.firstChild()
        verifyEquals("" + i, cell.attr("label")) // verify the index
        cell = cell.nextSibling()
        verifyEquals(outerl, cell.attr("label")) // verify the label
        var innerbox = jq(outeritem).find("@listbox")
        verifyTrue(innerbox.toWidget().exists())
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
        cell = outeritem.lastChild()
        var btn = jq(cell).find("@button") // index button
        click(btn.toWidget())
        waitResponse()
        var msg = jq("$msg")
        verifyEquals("item index " + i, msg.toWidget().attr("value"))
        outeritem = outeritem.nextSibling()
      }
    })
  }
}