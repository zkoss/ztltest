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
class Z60_B00757OnChangeTest extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = {
      <include src="/bind/issue/B00757OnChange.zul"/>
    }

    runZTL(zul, () => {
      var t1 = jq("$t1")
      var l1 = jq("$l1")
      var t2 = jq("$t2")
      var l2 = jq("$l2")
      var t3 = jq("$t3")
      var l31 = jq("$l31")
      var l32 = jq("$l32")
      var t4 = jq("$t4")
      var l4 = jq("$l4")
      `type`(t1.toWidget(), "A")
      waitResponse()
      verifyEquals("A-X", l1.toWidget().get("value"))
      `type`(t2.toWidget(), "A")
      waitResponse()
      verifyEquals("null-Y", l2.toWidget().get("value"))
      `type`(t2.toWidget(), "B")
      waitResponse()
      verifyEquals("B-Y", l2.toWidget().get("value"))
      `type`(t2.toWidget(), "C")
      waitResponse()
      verifyEquals("B-Y", l2.toWidget().get("value"))
      `type`(t3.toWidget(), "A")
      waitResponse()
      verifyEquals("A", l31.toWidget().get("value"))
      verifyEquals("", l32.toWidget().get("value"))
      verifyEquals("", l4.toWidget().get("value"))
      `type`(t4.toWidget(), "C")
      waitResponse()
      verifyEquals("A", l31.toWidget().get("value"))
      verifyEquals("", l32.toWidget().get("value"))
      verifyEquals("", l4.toWidget().get("value"))
      `type`(t3.toWidget(), "B")
      waitResponse()
      verifyEquals("B", l31.toWidget().get("value"))
      verifyEquals("B-I", l32.toWidget().get("value"))
      verifyEquals("C-J", l4.toWidget().get("value"))

    })
  }
}