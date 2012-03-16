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
import org.zkoss.ztl.Widget

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_F00864ValidationContextEasierTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = {
      <include src="/bind/issue/F00864ValidationContextEasier.zul"/>
    }

    runZTL(zul, () => {

      var msg1 = jq("$msg1")
      var msg2 = jq("$msg2")
      var inp1 = jq("$inp1")
      var inp2 = jq("$inp2")
      var save1 = jq("$save1")
      var err = jq("$err")

      verifyEquals("", err.toWidget().get("value"))
      `type`(inp1.toWidget(), "Dennis")
      waitResponse()
      `type`(inp2.toWidget(), "100")
      waitResponse()
      click(save1.toWidget())
      waitResponse()

      verifyEquals("", err.toWidget().get("value"))
      verifyEquals("Dennis", msg1.toWidget().get("value"))
      verifyEquals("100", msg2.toWidget().get("value"))

    })
  }
}
