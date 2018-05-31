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
class Z60_CollectionIndexGrid1 extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/basic/collection-index-grid.zul"/>
"""

    runZTL(zul, () => {
      var outerbox = jq("$outergrid").toWidget()
      var outerrows = jq(outerbox).find("@rows").toWidget()
      val itemLabel = Array("A", "B", "C", "D")
      verifyEquals(itemLabel.length, outerrows.nChildren())
      var outerrow = outerrows.firstChild()
      for (i <- 0 to itemLabel.length - 1) {
        var outerl = itemLabel(i)
        var rowkid = outerrow.firstChild()
        verifyEquals("" + i, rowkid.get("value")) // verify the index on label
        rowkid = rowkid.nextSibling()
        verifyEquals(outerl, rowkid.get("value")) // verify the label on label
        var innergrid = rowkid.nextSibling()
        verifyTrue(innergrid.exists())
        var innerrows = jq(innergrid).find("@row")
        verifyEquals(2, innerrows.length())
        var innerrow = innerrows.first()
        for (j <- 0 to 1) {
          rowkid = innerrow.toWidget().firstChild()
          verifyEquals("" + j, rowkid.get("value"))
          rowkid = rowkid.nextSibling()
          verifyEquals("" + i, rowkid.get("value"))
          var innerl = itemLabel(i) + " " + j
          rowkid = rowkid.nextSibling()
          verifyEquals(innerl, rowkid.get("value"))
          innerrow = innerrows.next()
        }
        rowkid = outerrow.lastChild()
        var btn = jq(rowkid).find("@button").toWidget() // index button
        var msg = jq("$msg").toWidget()
        click(btn)
        waitResponse()
        verifyEquals("item index " + i, msg.get("value"))
        outerrow = outerrow.nextSibling()
      }
    })
  }
}