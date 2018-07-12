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
class Z60_ELTagTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/basic/eltag.zul"/>
"""

    runZTL(zul, () => {

      var t1 = jq("$t1")
      var l1 = jq("$l1")
      var l2 = jq("$l2")

      `type`(t1.toWidget(), "AA")
      waitResponse()
      verifyEquals("AA:A", l1.toWidget().attr("value"))
      verifyEquals("AA-B", l2.toWidget().attr("value"))

      `type`(t1.toWidget(), "BB")
      waitResponse()
      verifyEquals("BB:A", l1.toWidget().attr("value"))
      verifyEquals("BB-B", l2.toWidget().attr("value"))

    })
  }
}
