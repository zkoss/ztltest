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
class Z60_F00823RadiogroupModel2Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = """
      <include src="/bind/issue/F00823RadiogroupModel2.zul"/>
"""

    runZTL(zul, () => {

      var l1 = jq("$l1")
      var l2 = jq("$l2")
      var box1 = jq("$box1")
      var box2 = jq("$box2")
      var select = jq("$select")
      var clean = jq("$clean")

      verifyEquals("-1", l1.toWidget().get("value"))
      verifyEquals("", l2.toWidget().get("value"))

      click(box1.find("@radio").eq(1).toWidget().$n("real"))
      waitResponse()
      verifyEquals("1", l1.toWidget().get("value"))
      verifyEquals("", l2.toWidget().get("value"))
      click(box1.find("@radio").eq(3).toWidget().$n("real"))
      waitResponse()
      verifyEquals("3", l1.toWidget().get("value"))
      verifyEquals("", l2.toWidget().get("value"))

      click(clean.toWidget())
      waitResponse()
      verifyEquals("-1", l1.toWidget().get("value"))
      verifyEquals("", l2.toWidget().get("value"))

      click(box2.find("@radio").eq(1).toWidget().$n("real"))
      waitResponse()
      verifyEquals("-1", l1.toWidget().get("value"))
      verifyEquals("B", l2.toWidget().get("value"))
      click(box2.find("@radio").eq(3).toWidget().$n("real"))
      waitResponse()
      verifyEquals("-1", l1.toWidget().get("value"))
      verifyEquals("D", l2.toWidget().get("value"))

      click(clean.toWidget())
      waitResponse()
      verifyEquals("-1", l1.toWidget().get("value"))
      verifyEquals("", l2.toWidget().get("value"))

      click(select.toWidget())
      waitResponse()
      verifyEquals("0", l1.toWidget().get("value"))
      verifyEquals("A", l2.toWidget().get("value"))

    })
  }
}

