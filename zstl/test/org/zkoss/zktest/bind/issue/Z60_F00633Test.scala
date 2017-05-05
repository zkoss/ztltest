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
class Z60_F00633Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = """
      <include src="/bind/issue/F00633.zul"/>
"""

    runZTL(zul, () => {
      verifyEquals("onCreate 1", jq("$l11").toWidget().get("value"))
      verifyEquals("onCreate 2", jq("$l12").toWidget().get("value"))
      click(jq("$btn1").toWidget())
      waitResponse()
      verifyEquals("doCommand1", jq("$l11").toWidget().get("value"))
      click(jq("$btn2").toWidget())
      waitResponse()
      verifyEquals("doCommand2", jq("$l11").toWidget().get("value"))
      click(jq("$btn3").toWidget())
      waitResponse()
      verifyEquals("doCommand3 btn3 true", jq("$l11").toWidget().get("value"))
      click(jq("$btn4").toWidget())
      waitResponse()
      verifyEquals("doCommand4 3 false null btn4 true", jq("$l11").toWidget().get("value"))
      click(jq("$btn5").toWidget())
      waitResponse()
      verifyEquals("doCommand5 99 true XYZ btn5 true", jq("$l11").toWidget().get("value"))
      click(jq("$btn6").toWidget())
      waitResponse()
      verifyEquals("doCommand6 9 true ABCD btn6 true", jq("$l11").toWidget().get("value"))
      click(jq("$btn7").toWidget())
      waitResponse()
      verifyEquals("doCommandX 9 true XYZ cmd7", jq("$l11").toWidget().get("value"))
      click(jq("$btn8").toWidget())
      waitResponse()
      verifyEquals("doCommandX 22 true ABCD cmd8", jq("$l11").toWidget().get("value"))
      click(jq("$btn9").toWidget())
      waitResponse()
      verifyEquals("doCommandX 9 false EFG cmd9", jq("$l11").toWidget().get("value"))
      click(jq("$btn10").toWidget())
      waitResponse()
      verifyEquals("object is btn10", jq("$l12").toWidget().get("value"))
      click(jq("$btn11").toWidget())
      waitResponse()
      verifyEquals("object is desktop", jq("$l12").toWidget().get("value"))
      click(jq("$btn12").toWidget())
      waitResponse()
      verifyEquals("object is h11", jq("$l12").toWidget().get("value"))
    })
  }
}