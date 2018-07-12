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
class Z60_F00771_1Test extends ZTL4ScalaTestCase {
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
      var reload1 = jq("$reload1")
      var reload2 = jq("$reload2")
      verifyEquals("", val1.toWidget().attr("value"))
      verifyEquals("", val2.toWidget().attr("value"))
      verifyEquals("", val3.toWidget().attr("value"))
      `type`(t11.toWidget(), "ab")
      waitResponse() 
      `type`(t11.toWidget(), "ab")
      waitResponse()
      verifyEquals("", val1.toWidget().attr("value"))
      verifyEquals("", val2.toWidget().attr("value"))
      verifyEquals("", val3.toWidget().attr("value"))
      verifyEquals("value1 must equalsIgnoreCase to abc", l11.toWidget().attr("value"))
      verifyEquals("value1 must equalsIgnoreCase to abc - by key", l12.toWidget().attr("value"))
      verifyEquals("", l21.toWidget().attr("value"))
      verifyEquals("value1 must equalsIgnoreCase to abc - by key", l22.toWidget().attr("value"))
      verifyEquals("", l31.toWidget().attr("value"))
      verifyEquals("", l32.toWidget().attr("value"))
      `type`(t21.toWidget(), "de")
      waitResponse() 
      verifyEquals("", val1.toWidget().attr("value"))
      verifyEquals("", val2.toWidget().attr("value"))
      verifyEquals("", val3.toWidget().attr("value"))
      verifyEquals("value1 must equalsIgnoreCase to abc", l11.toWidget().attr("value"))
      verifyEquals("value1 must equalsIgnoreCase to abc - by key", l12.toWidget().attr("value"))
      verifyEquals("value2 must equalsIgnoreCase to def", l21.toWidget().attr("value"))
      verifyEquals("value1 must equalsIgnoreCase to abc - by key", l22.toWidget().attr("value"))
      verifyEquals("", l31.toWidget().attr("value"))
      verifyEquals("", l32.toWidget().attr("value"))
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
      `type`(t11.toWidget(), "abc")
      waitResponse() 
      verifyEquals("abc", val1.toWidget().attr("value"))
      verifyEquals("", val2.toWidget().attr("value"))
      verifyEquals("", val3.toWidget().attr("value"))
      verifyEquals("", l11.toWidget().attr("value"))
      verifyEquals("value2 must equalsIgnoreCase to def - by key", l12.toWidget().attr("value"))
      verifyEquals("value2 must equalsIgnoreCase to def", l21.toWidget().attr("value"))
      verifyEquals("value2 must equalsIgnoreCase to def - by key", l22.toWidget().attr("value"))
      verifyEquals("value3 must equalsIgnoreCase to xyz", l31.toWidget().attr("value"))
      verifyEquals("value3 must equalsIgnoreCase to xyz - by key", l32.toWidget().attr("value"))
      `type`(t21.toWidget(), "def")
      waitResponse() 
      verifyEquals("abc", val1.toWidget().attr("value"))
      verifyEquals("def", val2.toWidget().attr("value"))
      verifyEquals("", val3.toWidget().attr("value"))
      verifyEquals("", l11.toWidget().attr("value"))
      verifyEquals("value3 must equalsIgnoreCase to xyz - by key", l12.toWidget().attr("value"))
      verifyEquals("", l21.toWidget().attr("value"))
      verifyEquals("value3 must equalsIgnoreCase to xyz - by key", l22.toWidget().attr("value"))
      verifyEquals("value3 must equalsIgnoreCase to xyz", l31.toWidget().attr("value"))
      verifyEquals("value3 must equalsIgnoreCase to xyz - by key", l32.toWidget().attr("value"))
      `type`(t31.toWidget(), "xyz")
      waitResponse() 
      verifyEquals("abc", val1.toWidget().attr("value"))
      verifyEquals("def", val2.toWidget().attr("value"))
      verifyEquals("xyz", val3.toWidget().attr("value"))
      verifyEquals("", l11.toWidget().attr("value"))
      verifyEquals("", l12.toWidget().attr("value"))
      verifyEquals("", l21.toWidget().attr("value"))
      verifyEquals("", l22.toWidget().attr("value"))
      verifyEquals("", l31.toWidget().attr("value"))
      verifyEquals("", l32.toWidget().attr("value"))
      `type`(t11.toWidget(), "ab")
      waitResponse() 
      `type`(t21.toWidget(), "de")
      waitResponse() 
      `type`(t31.toWidget(), "xy")
      waitResponse() 
      verifyEquals("abc", val1.toWidget().attr("value"))
      verifyEquals("def", val2.toWidget().attr("value"))
      verifyEquals("xyz", val3.toWidget().attr("value"))
      verifyEquals("value1 must equalsIgnoreCase to abc", l11.toWidget().attr("value"))
      verifyEquals("value1 must equalsIgnoreCase to abc - by key", l12.toWidget().attr("value"))
      verifyEquals("value2 must equalsIgnoreCase to def", l21.toWidget().attr("value"))
      verifyEquals("value1 must equalsIgnoreCase to abc - by key", l22.toWidget().attr("value"))
      verifyEquals("value3 must equalsIgnoreCase to xyz", l31.toWidget().attr("value"))
      verifyEquals("value3 must equalsIgnoreCase to xyz - by key", l32.toWidget().attr("value"))
      click(reload1.toWidget())
      waitResponse()
      verifyEquals("abc", t11.toWidget().attr("value"))
      verifyEquals("de", t21.toWidget().attr("value"))
      verifyEquals("xy", t31.toWidget().attr("value"))
      verifyEquals("", l11.toWidget().attr("value"))
      verifyEquals("value2 must equalsIgnoreCase to def - by key", l12.toWidget().attr("value"))
      verifyEquals("value2 must equalsIgnoreCase to def", l21.toWidget().attr("value"))
      verifyEquals("value2 must equalsIgnoreCase to def - by key", l22.toWidget().attr("value"))
      verifyEquals("value3 must equalsIgnoreCase to xyz", l31.toWidget().attr("value"))
      verifyEquals("value3 must equalsIgnoreCase to xyz - by key", l32.toWidget().attr("value"))
      click(reload2.toWidget())
      waitResponse()
      verifyEquals("abc", t11.toWidget().attr("value"))
      verifyEquals("def", t21.toWidget().attr("value"))
      verifyEquals("xy", t31.toWidget().attr("value"))
      verifyEquals("", l11.toWidget().attr("value"))
      verifyEquals("value3 must equalsIgnoreCase to xyz - by key", l12.toWidget().attr("value"))
      verifyEquals("", l21.toWidget().attr("value"))
      verifyEquals("value3 must equalsIgnoreCase to xyz - by key", l22.toWidget().attr("value"))
      verifyEquals("value3 must equalsIgnoreCase to xyz", l31.toWidget().attr("value"))
      verifyEquals("value3 must equalsIgnoreCase to xyz - by key", l32.toWidget().attr("value"))

    })
  }
}
