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
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00905FormNotifyChangeTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/B00905FormNotifyChange.zul"/>
"""

    runZTL(zul, () => {

      var tb = jq("$tb")
      var l1 = jq("$l1")
      var l2 = jq("$l2")
      var l3 = jq("$l3")
      var btn = jq("$btn")
      var msg = jq("$msg")

      verifyEquals("Dennis", tb.toWidget().attr("value"))
      verifyEquals("Dennis", l1.toWidget().attr("value"))
      verifyEquals("Dennis", l2.toWidget().attr("value"))
      verifyEquals("Dennis", l3.toWidget().attr("value"))
      verifyEquals("Dennis", msg.toWidget().attr("value"))

      `type`(tb.toWidget(), "Alex")
      waitResponse()
      verifyEquals("Alex", tb.toWidget().attr("value"))
      verifyEquals("Alex", l1.toWidget().attr("value"))
      verifyEquals("Alex", l2.toWidget().attr("value"))
      verifyEquals("Alex", l3.toWidget().attr("value"))
      verifyEquals("Dennis", msg.toWidget().attr("value"))

      click(btn.toWidget())
      waitResponse()
      verifyEquals("Alex", tb.toWidget().attr("value"))
      verifyEquals("Alex", l1.toWidget().attr("value"))
      verifyEquals("Alex", l2.toWidget().attr("value"))
      verifyEquals("Alex", l3.toWidget().attr("value"))
      verifyEquals("Alex", msg.toWidget().attr("value"))

    })
  }
}
