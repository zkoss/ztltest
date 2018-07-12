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
class Z60_F00771_2Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = """
      <include src="/bind/issue/F00771.zul"/>
"""

    runZTL(zul, () => {
      var val1 = jq("$val1")
      var val2 = jq("$val2")
      var val3 = jq("$val3")
      var t11 = jq("$t11")
      var l11 = jq("$l11")
      var l12 = jq("$l12")
      var t21 = jq("$t21")
      var l21 = jq("$l21")
      var l22 = jq("$l22")
      var t31 = jq("$t31")
      var l31 = jq("$l31")
      var l32 = jq("$l32")
      `type`(t11.toWidget(), "ab")
      waitResponse()
      `type`(t21.toWidget(), "de")
      waitResponse()
      `type`(t31.toWidget(), "xy")
      waitResponse()
      verifyEquals("", val1.toWidget().attr("value"))
      verifyEquals("", val2.toWidget().attr("value"))
      verifyEquals("", val3.toWidget().attr("value"))
      verifyEquals("value1 must equalsIgnoreCase to abc", l11.toWidget().attr("value"))
      verifyEquals("value1 must equalsIgnoreCase to abc - by key", l12.toWidget().attr("value"))
      verifyEquals("value2 must equalsIgnoreCase to def", l21.toWidget().attr("value"))
      verifyEquals("value1 must equalsIgnoreCase to abc - by key", l22.toWidget().attr("value"))
      verifyEquals("value3 must equalsIgnoreCase to xyz", l31.toWidget().attr("value"))
      verifyEquals("value3 must equalsIgnoreCase to xyz - by key", l32.toWidget().attr("value"))
      var t41 = jq("$t41")
      var t42 = jq("$t42")
      var t43 = jq("$t43")
      var l41 = jq("$l41")
      var l42 = jq("$l42")
      var l43 = jq("$l43")
      var submit = jq("$submit")
      `type`(t41.toWidget(), "ab")
      waitResponse()
      `type`(t42.toWidget(), "de")
      waitResponse()
      `type`(t43.toWidget(), "xy")
      waitResponse()
      click(submit.toWidget())
      waitResponse()
      verifyEquals("", val1.toWidget().attr("value"))
      verifyEquals("", val2.toWidget().attr("value"))
      verifyEquals("", val3.toWidget().attr("value"))
      verifyEquals("value1 must equalsIgnoreCase to abc - by key", l41.toWidget().attr("value"))
      verifyEquals("value2 must equalsIgnoreCase to def - by key", l42.toWidget().attr("value"))
      verifyEquals("value3 must equalsIgnoreCase to xyz - by key", l43.toWidget().attr("value"))
      `type`(t41.toWidget(), "ABC")
      waitResponse()
      click(submit.toWidget())
      waitResponse()
      verifyEquals("", val1.toWidget().attr("value"))
      verifyEquals("", val2.toWidget().attr("value"))
      verifyEquals("", val3.toWidget().attr("value"))
      verifyEquals("", l41.toWidget().attr("value"))
      verifyEquals("value2 must equalsIgnoreCase to def - by key", l42.toWidget().attr("value"))
      verifyEquals("value3 must equalsIgnoreCase to xyz - by key", l43.toWidget().attr("value"))
      `type`(t42.toWidget(), "DEF")
      waitResponse()
      click(submit.toWidget())
      waitResponse()
      verifyEquals("", val1.toWidget().attr("value"))
      verifyEquals("", val2.toWidget().attr("value"))
      verifyEquals("", val3.toWidget().attr("value"))
      verifyEquals("", l41.toWidget().attr("value"))
      verifyEquals("", l42.toWidget().attr("value"))
      verifyEquals("value3 must equalsIgnoreCase to xyz - by key", l43.toWidget().attr("value"))
      `type`(t43.toWidget(), "XYZ")
      waitResponse()
      click(submit.toWidget())
      waitResponse()
      verifyEquals("ABC", val1.toWidget().attr("value"))
      verifyEquals("DEF", val2.toWidget().attr("value"))
      verifyEquals("XYZ", val3.toWidget().attr("value"))
      verifyEquals("", l41.toWidget().attr("value"))
      verifyEquals("", l42.toWidget().attr("value"))
      verifyEquals("", l43.toWidget().attr("value"))
      verifyEquals("", l11.toWidget().attr("value"))
      verifyEquals("", l12.toWidget().attr("value"))
      verifyEquals("", l21.toWidget().attr("value"))
      verifyEquals("", l22.toWidget().attr("value"))
      verifyEquals("", l31.toWidget().attr("value"))
      verifyEquals("", l32.toWidget().attr("value"))

    })
  }
}

