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
class Z60_ChildrenSimple2 extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = {
      <include src="/bind/basic/children-simple.zul"/>
    }

    runZTL(zul, () => {
      var dependency = jq("$dependency")
      var cmd3 = jq("$cmd3")
      var labels = dependency.find("@label")
      var compare = Array("Item A", "Item B", "Item C")
      verifyEquals(compare.length, labels.length())
      for (i <- 0 to compare.length - 1) {
        verifyEquals(compare(i), labels.eq(i).toWidget().get("value"))
        verifyEquals(if ("Item A".equals(compare(i))) "c1" else "c2", labels.eq(i).toWidget().get("sclass"))
      }
      click(cmd3.toWidget())
      waitResponse()
      compare = Array("Item X", "Item A", "Item C")
      labels = dependency.find("@label")
      verifyEquals(compare.length, labels.length())
      for (i <- 0 to compare.length - 1) {
        verifyEquals(compare(i), labels.eq(i).toWidget().get("value"))
        verifyEquals(if ("Item A".equals(compare(i))) "c1" else "c2", labels.eq(i).toWidget().get("sclass"))
      }
    })
  }
}

