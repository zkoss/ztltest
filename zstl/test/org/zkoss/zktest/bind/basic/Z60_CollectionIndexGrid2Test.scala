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
class Z60_CollectionIndexGrid2Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/databinding/collection/collection-index-grid.zul"/>
"""

    runZTL(zul, () => {
      val outerrows = widget("$outergrid").getChild("rows")
      // =================================delete 2rd row
      var outeritem = outerrows.firstChild().nextSibling() // 2rd row
      click(jq(outeritem).find("@button").get(1)) // click the delete button on 2nd row
      waitResponse()

      var itemLabel = Array("A", "C", "D")
      verifyEquals(3, outerrows.nChildren())
      var outerrow = outerrows.firstChild()
      for (i <- itemLabel.indices) {
        var outerl = itemLabel(i)
        var rowkid = outerrow.firstChild()
        verifyEquals("" + i, rowkid.attr("value")) // verify the index on label
        rowkid = rowkid.nextSibling()
        verifyEquals(outerl, rowkid.attr("value")) // verify the label on label
        var innergrid = rowkid.nextSibling()
        verifyTrue(innergrid.exists())
        var innerrows = jq(innergrid).find("@row")
        verifyEquals(2, innerrows.length())
        for (j <- 0 to 1) {
          var innerrow = innerrows.eq(j)
          rowkid = innerrow.toWidget().firstChild()
          verifyEquals("" + j, rowkid.attr("value"))
          rowkid = rowkid.nextSibling()
          verifyEquals("" + i, rowkid.attr("value"))
          var innerl = itemLabel(i) + " " + j
          rowkid = rowkid.nextSibling()
          verifyEquals(innerl, rowkid.attr("value"))
        }
        rowkid = outerrow.lastChild()
        var btn = jq(rowkid).find("@button").toWidget() // index button
        var msg = jq("$msg").toWidget()
        click(btn)
        waitResponse()
        verifyEquals("item index " + i, msg.attr("value"))
        outerrow = outerrow.nextSibling()
      }
      // =================================add after row
      outeritem = outerrows.firstChild().nextSibling() // 2rd row
      click(jq(outeritem).find("@button").get(2)) // add after 2nd row
      waitResponse()

      itemLabel = Array("A", "C", "C1", "D")
      verifyEquals(4, outerrows.nChildren())
      outerrow = outerrows.firstChild()
      for (i <- itemLabel.indices) {
        var outerl = itemLabel(i)
        var rowkid = outerrow.firstChild()
        verifyEquals("" + i, rowkid.attr("value")) // verify the index on label
        rowkid = rowkid.nextSibling()
        verifyEquals(outerl, rowkid.attr("value")) // verify the label on label
        var innergrid = rowkid.nextSibling()
        verifyTrue(innergrid.exists())
        var innerrows = jq(innergrid).find("@row")
        verifyEquals(2, innerrows.length())
        for (j <- 0 to 1) {
          var innerrow = innerrows.eq(j)
          rowkid = innerrow.toWidget().firstChild()
          verifyEquals("" + j, rowkid.attr("value"))
          rowkid = rowkid.nextSibling()
          verifyEquals("" + i, rowkid.attr("value"))
          var innerl = itemLabel(i) + " " + j
          rowkid = rowkid.nextSibling()
          verifyEquals(innerl, rowkid.attr("value"))
        }
        rowkid = outerrow.lastChild()
        var btn = jq(rowkid).find("@button").toWidget() // index button
        var msg = jq("$msg").toWidget()
        click(btn)
        waitResponse()
        verifyEquals("item index " + i, msg.attr("value"))
        outerrow = outerrow.nextSibling()
      }
      // =================================add before row
      outeritem = outerrows.firstChild().nextSibling().nextSibling() // 3rd row
      click(jq(outeritem).find("@button").get(3)) // add before 3nd row
      waitResponse()

      itemLabel = Array("A", "C", "C12", "C1", "D")
      verifyEquals(5, outerrows.nChildren())
      outerrow = outerrows.firstChild()
      for (i <- itemLabel.indices) {
        var outerl = itemLabel(i)
        var rowkid = outerrow.firstChild()
        verifyEquals("" + i, rowkid.attr("value")) // verify the index on label
        rowkid = rowkid.nextSibling()
        verifyEquals(outerl, rowkid.attr("value")) // verify the label on label
        var innergrid = rowkid.nextSibling()
        verifyTrue(innergrid.exists())
        var innerrows = jq(innergrid).find("@row")
        verifyEquals(2, innerrows.length())
        for (j <- 0 to 1) {
          var innerrow = innerrows.eq(j)
          rowkid = innerrow.toWidget().firstChild()
          verifyEquals("" + j, rowkid.attr("value"))
          rowkid = rowkid.nextSibling()
          verifyEquals("" + i, rowkid.attr("value"))
          var innerl = itemLabel(i) + " " + j
          rowkid = rowkid.nextSibling()
          verifyEquals(innerl, rowkid.attr("value"))
        }
        rowkid = outerrow.lastChild()
        var btn = jq(rowkid).find("@button").toWidget() // index button
        var msg = jq("$msg").toWidget()
        click(btn)
        waitResponse()
        verifyEquals("item index " + i, msg.attr("value"))
        outerrow = outerrow.nextSibling()
      }
    })
  }
}