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
class Z60_GridModelTest extends ZTL4ScalaTestCase {
  @Test
  def testArg() = {
    val zul = """
      <include src="/bind/basic/gridmodel.zul"/>
"""

    runZTL(zul, () => {
      var outerbox = jq("$outergrid")
      var outerrows = outerbox.find("@rows").toWidget().firstChild()
      // =================================delete 2rd row
      var outeritem = outerrows.nextSibling()
      click(jq(outeritem).find("@button").eq(1).toWidget()) // click the delete button on 2nd row
      waitResponse()
      outerbox = jq("$outergrid")
      outerrows = outerbox.find("@rows").toWidget().firstChild()
      var itemLabel = Array("A", "C", "D")
      verifyEquals(itemLabel.length, outerbox.find("@rows").toWidget().nChildren())
      var outerrow = outerrows

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
        rowkid = outerrow.lastChild()
        var btn = jq(rowkid).find("@button").toWidget() // index button
        var msg = jq("$msg").toWidget()
        click(btn)
        waitResponse()
        verifyEquals("item index " + i, msg.get("value"))
        outerrow = outerrow.nextSibling()
      }
      // =================================add after row
      outeritem = outerrows.nextSibling()
      click(jq(outeritem).find("@button").eq(2).toWidget()) // add after 2nd row
      waitResponse()
      outerbox = jq("$outergrid")
      outerrows = outerbox.find("@rows").toWidget().firstChild()
      itemLabel = Array("A", "C", "C1", "D")
      verifyEquals(itemLabel.length, outerbox.find("@rows").toWidget().nChildren())
      outerrow = outerrows
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
        rowkid = outerrow.lastChild()
        var btn = jq(rowkid).find("@button").toWidget() // index button
        var msg = jq("$msg").toWidget()
        click(btn)
        waitResponse()
        verifyEquals("item index " + i, msg.get("value"))
        outerrow = outerrow.nextSibling()
      }
      // =================================add before row
      outeritem = outerrows.nextSibling().nextSibling()
      click(jq(outeritem).find("@button").eq(3).toWidget()) // add before 3nd row
      waitResponse()
      outerbox = jq("$outergrid")
      outerrows = outerbox.find("@rows").toWidget().firstChild()
      itemLabel = Array("A", "C", "C12", "C1", "D")
      verifyEquals(itemLabel.length, outerbox.find("@rows").toWidget().nChildren())
      outerrow = outerrows
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
      