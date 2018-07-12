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
class Z60_ImmutableTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/basic/immutable.zul"/>
"""

    runZTL(zul, () => {

      var l1 = jq("$l1")
      var l2 = jq("$l2")
      var l3 = jq("$l3")
      var l4 = jq("$l4")
      var l5 = jq("$l5")
      var cmd1 = jq("$cmd1")
      var cmd2 = jq("$cmd2")

      verifyEquals("A", l1.toWidget().attr("value"))
      verifyEquals("A-option", l2.toWidget().attr("value"))
      verifyEquals("A-option", l3.toWidget().attr("value"))
      verifyEquals("A-option", l4.toWidget().attr("value"))
      verifyEquals("A-option", l5.toWidget().attr("value"))

      click(cmd1.toWidget())
      waitResponse()
      verifyEquals("A", l1.toWidget().attr("value"))
      verifyEquals("A-option", l2.toWidget().attr("value"))
      verifyEquals("A-option", l3.toWidget().attr("value"))
      verifyEquals("A-option", l4.toWidget().attr("value"))
      verifyEquals("A-option", l5.toWidget().attr("value"))

      click(cmd2.toWidget())
      waitResponse()
      verifyEquals("A", l1.toWidget().attr("value"))
      verifyEquals("A-option", l2.toWidget().attr("value"))
      verifyEquals("A-option", l3.toWidget().attr("value"))
      verifyEquals("B-option", l4.toWidget().attr("value"))
      verifyEquals("B-option", l5.toWidget().attr("value"))

    })
  }
}
