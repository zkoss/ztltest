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
class Z60_TemplateCombobox extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = {
      <include src="/bind/basic/collection-template-combobox.zul"/>
    }

    runZTL(zul, () => {
      var outerbox = jq("$outergrid").toWidget()
      var outerrows = jq(outerbox).find("@rows").toWidget().firstChild()
      var itemLabel = Array("A", "B", "C", "D")
      verifyEquals(itemLabel.length, jq(outerbox).find("@rows").toWidget().nChildren())
      var outerrow = outerrows
      for (i <- 0 to itemLabel.length - 1) {
        var combobox = jq(outerrow).find("@combobox").toWidget()
        combobox.eval("open()") // to show popu first so we can find comboitem in zkmax
        waitResponse(true)
        var comboitems = jq(combobox).find("@comboitem")
        verifyEquals(4, comboitems.length())
        for (j <- 0 to 1) {
          var comboitem = comboitems.eq(j).toWidget()
          if (j == 0 || j == 2)
            verifyEquals("Model1-" + itemLabel(i) + " " + j + "-" + j + "-" + i, comboitem.get("label"))
          else
            verifyEquals("Model2-" + itemLabel(i) + " " + j + "-" + j + "-" + i, comboitem.get("label"))
          verifyEquals(itemLabel(i) + " " + j, comboitem.get("description"))
        }
        var btn = jq(outerrow).find("@button").toWidget() // index button
        var msg = jq("$msg").toWidget()
        click(btn)
        waitResponse(true)
        verifyEquals("item index " + i, msg.get("value"))
        outerrow = outerrow.nextSibling()
      }
    })
  }
}
