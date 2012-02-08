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
class Z60_B00678Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = {
      <include src="/bind/issue/B00678.zul"/>
    }

    runZTL(zul, () => {
      verifyEquals("Value A", jq("$l1").toWidget().get("value"))
      verifyEquals("msg A", jq("$l2").toWidget().get("value"))
      click(jq("$btn1").toWidget())
      waitResponse()
      verifyEquals("Value B", jq("$l1").toWidget().get("value"))
      verifyEquals("msg B", jq("$l2").toWidget().get("value"))
      click(jq("$btn2").toWidget())
      waitResponse()
      verifyEquals("Value C", jq("$l1").toWidget().get("value"))
      verifyEquals("msg C", jq("$l2").toWidget().get("value"))
    })
  }
}