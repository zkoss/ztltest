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
class Z60_TemplateGrid1Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = {
      <include src="bind/basic/collection-template-grid.zul"/>
    }

    runZTL(zul, () => {
      var outerbox = jq("$outergrid")
      var outerrows = outerbox.find("@rows").toWidget().firstChild()
      var itemLabel = Array("A", "B", "C", "D")
      verifyEquals(itemLabel.length, outerbox.find("@rows").toWidget().nChildren())
      var outerrow = outerrows

      for (i <- 0 to itemLabel.length - 1) {
        var outerl = itemLabel(i)
        var rowkid = outerrow.firstChild()
        verifyEquals("" + i, rowkid.get("value")) // verify the index on label
        rowkid = rowkid.nextSibling()
        verifyEquals(outerl, rowkid.get("value")) // verify the label on label
        // verify inner index
        var innergrid = rowkid.nextSibling()
        verifyTrue(innergrid.exists())
        var innerrows = jq(innergrid).find("@row")
        verifyEquals(2, innerrows.length())
        for (j <- 0 to 1) {
          var innerrow = innerrows.eq(j).toWidget()
          rowkid = innerrow.firstChild()
          verifyEquals("" + j, rowkid.get("value"))
          rowkid = rowkid.nextSibling()
          verifyEquals("" + i, rowkid.get("value"))
          var innerl = itemLabel(i) + " " + j
          rowkid = rowkid.nextSibling()
          verifyEquals(innerl, rowkid.get("value"))
        }
        rowkid = outerrow.lastChild().previousSibling()
        var btn = jq(rowkid).find("@button").toWidget() // index button
        var msg = jq("$msg").toWidget()
        click(btn)
        waitResponse()
        verifyEquals("item index " + i, msg.get("value"))
        // verify template
        rowkid = outerrow.lastChild()
        var label = jq(rowkid).find("@label").toWidget() // index button
        if (outerl.equals("A") || i == 2)
          verifyEquals("Model1", label.get("value"))
        else
          verifyEquals("Model2", label.get("value"))
        outerrow = outerrow.nextSibling()
      }
    })
  }
}
