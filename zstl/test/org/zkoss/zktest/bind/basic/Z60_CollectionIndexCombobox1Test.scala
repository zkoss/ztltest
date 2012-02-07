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
import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_CollectionIndexCombobox1 extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = {
      <include src="/bind/basic/collection-index-combobox.zul"/>
    }

    runZTL(zul, () => {
      var outerbox = jq("$outergrid")
      var outerrows = outerbox.find("@rows").children()
      var itemLabel = Array("A", "B", "C", "D")
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
