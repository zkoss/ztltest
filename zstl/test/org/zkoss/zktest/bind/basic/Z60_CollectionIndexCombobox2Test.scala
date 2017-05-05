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
class Z60_CollectionIndexCombobox2 extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/basic/collection-index-combobox.zul" />
"""

    runZTL(zul, () => {
      var outerbox = jq("$outergrid")
      var outerrows = outerbox.find("@rows").children()
      // =================================delete 2rd row
      var outeritem = outerrows.eq(1)
      click(outeritem.find("@button").get(1)) // click the delete button on 2nd row
      waitResponse()
      outerbox = jq("$outergrid")
      outerrows = outerbox.find("@rows").children()
      var itemLabel = Array("A", "C", "D")
      verifyEquals(itemLabel.length, outerrows.length())
      for (i <- 0 to itemLabel.length - 1) {
        var outerrow = outerrows.eq(i)
        var combobox = outerrow.find("@combobox")
        combobox.toWidget().eval("open()") // to show popu first so we can find comboitem in zkmax
        waitResponse();
        var comboitems = combobox.find("@comboitem")
        verifyEquals(2, comboitems.length())
        for (j <- 0 to 1) {
          var comboitem = comboitems.eq(j)
          verifyEquals(itemLabel(i) + " " + j + "-" + j + "-" + i, comboitem.toWidget().get("label"))
          verifyEquals(itemLabel(i) + " " + j, comboitem.toWidget().get("description"))
        }
        var btn = outerrow.find("@button") // index button
        var msg = jq("$msg")
        click(btn.toWidget())
        waitResponse()
        verifyEquals("item index " + i, msg.toWidget().get("value"))
      }
      // =================================add after 2rd row
      outeritem = outerrows.eq(1)
      click(outeritem.find("@button").get(2)) // click the add after button on 2nd row
      waitResponse()
      outerbox = jq("$outergrid")
      outerrows = outerbox.find("@rows").children()
      itemLabel = Array("A", "C", "C1", "D")
      verifyEquals(itemLabel.length, outerrows.length())
      for (i <- 0 to itemLabel.length - 1) {
        var outerrow = outerrows.eq(i)
        var combobox = outerrow.find("@combobox")
        combobox.toWidget().eval("open()") // to show popu first so we can find comboitem in zkmax
        waitResponse();
        var comboitems = combobox.find("@comboitem")
        verifyEquals(2, comboitems.length())
        for (j <- 0 to 1) {
          var comboitem = comboitems.eq(j)
          verifyEquals(itemLabel(i) + " " + j + "-" + j + "-" + i, comboitem.toWidget().get("label"))
          verifyEquals(itemLabel(i) + " " + j, comboitem.toWidget().get("description"))
        }
        var btn = outerrow.find("@button") // index button
        var msg = jq("$msg")
        click(btn.toWidget())
        waitResponse()
        verifyEquals("item index " + i, msg.toWidget().get("value"))
      }
      // =================================add before 2rd row
      outeritem = outerrows.eq(2)
      click(outeritem.find("@button").get(3)) // click the add before button on 2nd row
      waitResponse()
      outerbox = jq("$outergrid")
      outerrows = outerbox.find("@rows").children()
      itemLabel = Array("A", "C", "C12", "C1", "D")
      verifyEquals(itemLabel.length, outerrows.length())
      for (i <- 0 to itemLabel.length - 1) {
        var outerrow = outerrows.eq(i)
        var combobox = outerrow.find("@combobox")
        combobox.toWidget().eval("open()") // to show popu first so we can find comboitem in zkmax
        waitResponse();
        var comboitems = combobox.find("@comboitem")
        verifyEquals(2, comboitems.length())
        for (j <- 0 to 1) {
          var comboitem = comboitems.eq(j)
          verifyEquals(itemLabel(i) + " " + j + "-" + j + "-" + i, comboitem.toWidget().get("label"))
          verifyEquals(itemLabel(i) + " " + j, comboitem.toWidget().get("description"))
        }
        var btn = outerrow.find("@button") // index button
        var msg = jq("$msg")
        click(btn.toWidget())
        waitResponse()
        verifyEquals("item index " + i, msg.toWidget().get("value"))
      }
    })
  }
}
