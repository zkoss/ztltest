
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
class Z60_ComboboxModelTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/basic/comboboxmodel.zul"/>
"""

    runZTL(zul, () => {
      var outerbox = jq("$outergrid").toWidget()
      var outerrows = jq(outerbox).find("@rows").toWidget().firstChild()
      // =================================delete 2rd row
      var outeritem = outerrows.nextSibling()
      click(jq(outeritem).find("@button").eq(1).toWidget()) // click the delete button on 2nd row
      waitResponse()
      outerbox = jq("$outergrid").toWidget()
      outerrows = jq(outerbox).find("@rows").toWidget().firstChild()
      var itemLabel = Array("A", "C", "D")
      verifyEquals(itemLabel.length, jq(outerbox).find("@rows").toWidget().nChildren())
      var outerrow = outerrows

      for (i <- 0 to itemLabel.length - 1) {
        var combobox = jq(outerrow).find("@combobox").toWidget()
        combobox.eval("open()") // to show popu first so we can find comboitem in zkmax
        waitResponse()
        var comboitems = jq(combobox).find("@comboitem")
        verifyEquals(2, comboitems.length())

        for (j <- 0 to 1) {
          var comboitem = comboitems.eq(j).toWidget()
          verifyEquals(itemLabel(i) + " " + j + "-" + j + "-" + i, comboitem.attr("label"))
          verifyEquals(itemLabel(i) + " " + j, comboitem.attr("description"))
        }
        var btn = jq(outerrow).find("@button").toWidget() // index button
        var msg = jq("$msg").toWidget()
        click(btn)
        waitResponse()
        verifyEquals("item index " + i, msg.attr("value"))
        outerrow = outerrow.nextSibling()
      }
      // =================================add after 2rd row
      outeritem = outerrows.nextSibling()
      click(jq(outeritem).find("@button").eq(2).toWidget()) // click the add after button on 2nd row
      waitResponse()
      outerbox = jq("$outergrid").toWidget()
      outerrows = jq(outerbox).find("@rows").toWidget().firstChild()
      itemLabel = Array("A", "C", "C1", "D")
      verifyEquals(itemLabel.length, jq(outerbox).find("@rows").toWidget().nChildren())
      outerrow = outerrows
      for (i <- 0 to itemLabel.length - 1) {
        var combobox = jq(outerrow).find("@combobox").toWidget()
        combobox.eval("open()") // to show popu first so we can find comboitem in zkmax
        waitResponse()
        var comboitems = jq(combobox).find("@comboitem")
        verifyEquals(2, comboitems.length())
        for (j <- 0 to 1) {
          var comboitem = comboitems.eq(j).toWidget()
          verifyEquals(itemLabel(i) + " " + j + "-" + j + "-" + i, comboitem.attr("label"))
          verifyEquals(itemLabel(i) + " " + j, comboitem.attr("description"))
        }
        var btn = jq(outerrow).find("@button").toWidget() // index button
        var msg = jq("$msg").toWidget()
        click(btn)
        waitResponse()
        verifyEquals("item index " + i, msg.attr("value"))
        outerrow = outerrow.nextSibling()
      }
      // =================================add before 2rd row
      outeritem = outerrows.nextSibling().nextSibling()
      click(jq(outeritem).find("@button").eq(3).toWidget()) // click the add after button on 2nd row
      waitResponse()
      outerbox = jq("$outergrid").toWidget()
      outerrows = jq(outerbox).find("@rows").toWidget().firstChild()
      itemLabel = Array("A", "C", "C12", "C1", "D")
      verifyEquals(itemLabel.length, jq(outerbox).find("@rows").toWidget().nChildren())
      outerrow = outerrows
      for (i <- 0 to itemLabel.length - 1) {
        var combobox = jq(outerrow).find("@combobox").toWidget()
        combobox.eval("open()") // to show popu first so we can find comboitem in zkmax
        waitResponse()
        var comboitems = jq(combobox).find("@comboitem")
        verifyEquals(2, comboitems.length())
        for (j <- 0 to 1) {
          var comboitem = comboitems.eq(j).toWidget()
          verifyEquals(itemLabel(i) + " " + j + "-" + j + "-" + i, comboitem.attr("label"))
          verifyEquals(itemLabel(i) + " " + j, comboitem.attr("description"))
        }
        var btn = jq(outerrow).find("@button").toWidget() // index button
        var msg = jq("$msg").toWidget()
        click(btn)
        waitResponse()
        verifyEquals("item index " + i, msg.attr("value"))
        outerrow = outerrow.nextSibling()
      }
    })
  }
}