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
class Z60_TemplateListbox3Test extends ZTL4ScalaTestCase {

  @Test
  def testArg() = {
    val zul =
      """
      <include src="bind/basic/collection-template-listbox.zul"/>
"""

    runZTL(zul, () => {
      var outerbox = jq("$outerbox").toWidget()
      var outeritems = outerbox.firstChild() // include header
      var itemLabel = Array("A", "B", "C", "D")
      verifyEquals(4, outerbox.nChildren() - 1)
      var outeritem = outeritems
      for (i <- 0 to itemLabel.length - 1) {
        outeritem = outeritem.nextSibling()
        var outerl = itemLabel(i)
        var cell = outeritem.firstChild()
        verifyEquals("" + i, cell.attr("label")) // verify the index
        cell = cell.nextSibling()
        verifyEquals(outerl, cell.attr("label")) // verify the label
        // verify template
        cell = outeritem.lastChild()
        if (i == 0 || i == 2) {
          verifyEquals("Model1", cell.attr("label"))
        } else {
          verifyEquals("Model2", cell.attr("label"))
        }
      }
      // ==============================================
      click(jq(".z-button:contains(change1)"))
      waitResponse()
      outerbox = jq("$outerbox").toWidget()
      outeritems = outerbox.firstChild() // include header
      itemLabel = Array("X", "A", "C", "D")
      verifyEquals(4, outerbox.nChildren() - 1)
      outeritem = outeritems
      for (i <- 0 to itemLabel.length - 1) {
        outeritem = outeritem.nextSibling()
        var outerl = itemLabel(i)
        var cell = outeritem.firstChild()
        verifyEquals("" + i, cell.attr("label")) // verify the index
        cell = cell.nextSibling()
        verifyEquals(outerl, cell.attr("label")) // verify the label
        // verify template
        cell = outeritem.lastChild()
        if (outerl.equals("A") || i == 2) {
          verifyEquals("Model1", cell.attr("label"))
        } else {
          verifyEquals("Model2", cell.attr("label"))
        }
      }
      // ==============================================
      click(jq(".z-button:contains(change2)"))
      waitResponse()
      outerbox = jq("$outerbox").toWidget()
      outeritems = outerbox.firstChild() // include header
      itemLabel = Array("A", "B", "C", "D")
      verifyEquals(4, outerbox.nChildren() - 1)
      outeritem = outeritems
      for (i <- 0 to itemLabel.length - 1) {
        outeritem = outeritem.nextSibling()
        var outerl = itemLabel(i)
        var cell = outeritem.firstChild()
        verifyEquals("" + i, cell.attr("label")) // verify the index
        cell = cell.nextSibling()
        verifyEquals(outerl, cell.attr("label")) // verify the label
        // verify template
        cell = outeritem.lastChild()
        if (outerl.equals("A") || i == 2) {
          verifyEquals("Model1", cell.attr("label"))
        } else {
          verifyEquals("Model2", cell.attr("label"))
        }
      }
    })
  }
}