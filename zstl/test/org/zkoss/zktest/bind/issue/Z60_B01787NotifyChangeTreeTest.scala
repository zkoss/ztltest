/* Z60_B01787NotifyChangeTreeTest.scala

	Purpose:
		
	Description:
		
	History:
		Nov 29, 2013 Created by Kuro Chung

Copyright (C) 2013 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author kuro
 */
@Tags(tags = "zbind")
class Z60_B01787NotifyChangeTreeTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B01787NotifyChangeTree.zul"/>
"""

    // don't reuse this, data might different
    val btns = Array(null, "$updatePath", "$updateA", "$updateAName", "$updateB", "$updateBName")
    val answer = Array(
      Array("Item A:0","Item A1:0","Item A2:0","Item B:0","Item B1:0","Item B2:0","Item A:1","Item B:1"),
      Array("Item A:1","Item A1:0","Item A2:0","Item B:1","Item B1:0","Item B2:0","Item A:2","Item B:2"),
      Array("Item A.*:x:0","Item A1:1","Item A2:1","Item B:1","Item B1:1","Item B2:1","Item A.*:0","Item B:1"),
      Array("Item A.name:0","Item A1:0","Item A2:0","Item B:0","Item B1:0","Item B2:0","Item A.name:0","Item B:1"),
      Array("Item A:1","Item A1:1","Item A2:1","Item B.*:x:0","Item B1:1","Item B2:1","Item A:1","Item B.*:0"),
      Array("Item A:0","Item A1:0","Item A2:0","Item B.name:0","Item B1:0","Item B2:0","Item A:1","Item B.name:0"))

    for (i <- 0 to btns.length - 1) {
      runZTL(zul, () => {
    	  if(btns(i) != null) {
    	    click(jq(btns(i)).toWidget())
    	    waitResponse()
    	  }
    	  val comp1s = jq("$tree @treecell")
    	  verifyEquals(6, comp1s.length)
    	  verifyEquals(answer(i)(0), comp1s.eq(0).toWidget().get("label"))
    	  verifyEquals(answer(i)(1), comp1s.eq(1).toWidget().get("label"))
    	  verifyEquals(answer(i)(2), comp1s.eq(2).toWidget().get("label"))
    	  verifyEquals(answer(i)(3), comp1s.eq(3).toWidget().get("label"))
    	  verifyEquals(answer(i)(4), comp1s.eq(4).toWidget().get("label"))
    	  verifyEquals(answer(i)(5), comp1s.eq(5).toWidget().get("label"))	  
    	  val box1s = jq("$box1 @label")
    	  verifyEquals(2, box1s.length)
    	  verifyEquals(answer(i)(6), box1s.eq(0).toWidget().get("value"))
    	  verifyEquals(answer(i)(7), box1s.eq(1).toWidget().get("value"))
      })
    }

  }
}