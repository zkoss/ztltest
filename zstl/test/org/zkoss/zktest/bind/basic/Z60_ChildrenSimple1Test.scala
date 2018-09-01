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
class Z60_ChildrenSimple1Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul =
      """
      <include src="/bind/basic/children-simple.zul"/>
    """

    runZTL(zul, () => {
      var init = jq("$init").toWidget()
      var load = jq("$load").toWidget()
      var aftercmd = jq("$aftercmd").toWidget()
      var cmd1 = jq("$cmd1").toWidget()
      var cmd2 = jq("$cmd2").toWidget()
      var labels = jq(init).find("@label")
      var compare = Array("Item A", "Item B", "Item C")
      verifyEquals(3, labels.length())
      for (i <- 0 to 2) {
        verifyEquals(compare(i), labels.eq(i).toWidget().attr("value"))
      }
      labels = jq(load).find("@label")
      verifyEquals(3, labels.length())
      for (i <- 0 to 2) {
        verifyEquals(compare(i), labels.eq(i).toWidget().attr("value"))
      }
      labels = jq(aftercmd).find("@label")
      verifyEquals(0, labels.length())
      click(cmd1)
      waitResponse()
      labels = jq(init).find("@label")
      compare = Array("Item A", "Item B", "Item C")
      verifyEquals(3, labels.length())
      for (i <- 0 to 2) {
        verifyEquals(compare(i), labels.eq(i).toWidget().attr("value"))
      }
      labels = jq(load).find("@label")
      compare = Array("Item A", "Item B", "Item C", "Item D")
      verifyEquals(4, labels.length())
      for (i <- 0 to 3) {
        verifyEquals(compare(i), labels.eq(i).toWidget().attr("value"))
      }
      labels = jq(aftercmd).find("@label")
      verifyEquals(0, labels.length())
      click(cmd2)
      waitResponse()
      labels = jq(init).find("@label")
      compare = Array("Item A", "Item B", "Item C")
      verifyEquals(3, labels.length())
      for (i <- 0 to 2) {
        verifyEquals(compare(i), labels.eq(i).toWidget().attr("value"))
      }
      labels = jq(load).find("@label")
      compare = Array("Item A", "Item B", "Item C", "Item D")
      verifyEquals(4, labels.length())
      for (i <- 0 to 3) {
        verifyEquals(compare(i), labels.eq(i).toWidget().attr("value"))
      }
      labels = jq(aftercmd).find("@label")
      compare = Array("Item A", "Item B", "Item C", "Item D", "Item E")
      verifyEquals(5, labels.length())
      for (i <- 0 to 4) {
        verifyEquals(compare(i), labels.eq(i).toWidget().attr("value"))
      }
      click(cmd1)
      waitResponse()
      labels = jq(load).find("@label")
      compare = Array("Item A", "Item B", "Item C", "Item D", "Item E", "Item D")
      verifyEquals(6, labels.length())
      for (i <- 0 to 5) {
        verifyEquals(compare(i), labels.eq(i).toWidget().attr("value"))
      }
      labels = jq(aftercmd).find("@label")
      compare = Array("Item A", "Item B", "Item C", "Item D", "Item E")
      verifyEquals(5, labels.length())
      for (i <- 0 to 4) {
        verifyEquals(compare(i), labels.eq(i).toWidget().attr("value"))
      }
    })
  }
}


