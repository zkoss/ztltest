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
import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_ExecutionParamTest extends ZTL4ScalaTestCase {
  @Test
  def testArg() = {
    val zul = """
      <include src="/bind/basic/executionparam.zul"/>
"""

    runZTL(zul, () => {
      click(jq("$btn1").toWidget())
      waitResponse()
      verifyEquals("foo", jq("$w1").find("$l11").toWidget().attr("value"))
      verifyEquals("bar", jq("$w1").find("$l12").toWidget().attr("value"))
      click(jq("$w1").find("$cmd1").toWidget())
      waitResponse()
      verifyEquals("", jq("$w1").find("$l11").toWidget().attr("value"))
      verifyEquals("", jq("$w1").find("$l12").toWidget().attr("value"))
      click(jq("$btn2").toWidget())
      waitResponse()
      verifyEquals("abc", jq("$w2").find("$l11").toWidget().attr("value"))
      verifyEquals("goo", jq("$w2").find("$l12").toWidget().attr("value"))
      click(jq("$w2").find("$cmd1").toWidget())
      waitResponse()
      verifyEquals("", jq("$w2").find("$l11").toWidget().attr("value"))
      verifyEquals("", jq("$w2").find("$l12").toWidget().attr("value"))
    })
  }
}
