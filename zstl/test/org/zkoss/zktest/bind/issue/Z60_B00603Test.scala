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
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00603Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = { 
      <include src="/bind/issue/B00603.zul" />
    }

    runZTL(zul, () => {
      val outerbox = engine.$f("outsidebox") 
      verifyEquals(outerbox.nChildren(), 4)  // include header
      val itemLabel = Array("A", "B", "C") 
      val optionLabel = Array("A", "B") 
      var outeritem = outerbox.firstChild()  // will skip header
      for (i <- 0 to 2) {
        outeritem = outeritem.nextSibling() 
        val outerl = itemLabel(i) 
        var cell = outeritem.firstChild() 
        verifyEquals(outerl, cell.get("label")) 
        val innerbox = jq(outeritem).find("@listbox") 
        verifyTrue(innerbox != null) 
        val inneritems = jq(innerbox).find("@listitem") 
        verifyEquals(2, inneritems.length()) 
        var inneritem = inneritems.first() 
        for (j <- 0 to 1) {
          val innerl = optionLabel(j) 
          cell = inneritem.toWidget().firstChild() 
          verifyEquals(outerl + " " + innerl, cell.get("label")) 
          cell = cell.nextSibling() 
          verifyEquals(outerl + " " + innerl + innerl, cell.get("label")) 
          inneritem = inneritem.next() 
        }
      }
    })
  }
}