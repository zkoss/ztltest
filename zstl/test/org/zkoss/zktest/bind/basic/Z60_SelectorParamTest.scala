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
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_SelectorParamTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/basic/selectorparam.zul"/>
"""

    runZTL(zul, () => {
      verifyEquals("Init 0", jq("$l11").toWidget().get("value"))
      verifyEquals("Init 1", jq("$l12").toWidget().get("value"))
      verifyEquals("Init 2", jq("$l13").toWidget().get("value"))
      verifyEquals("Init 3:4", jq("$l14").toWidget().get("value"))
      click(jq("$cmd1").toWidget())
      waitResponse()
      verifyEquals("Command 0", jq("$l11").toWidget().get("value"))
      verifyEquals("Command 1", jq("$l12").toWidget().get("value"))
      verifyEquals("Command 2:3", jq("$l13").toWidget().get("value"))
      verifyEquals("Command 3", jq("$l14").toWidget().get("value"))
      click(jq("$cmd2").toWidget())
      waitResponse()
      verifyEquals("size 0", jq("$cmd2").toWidget().get("label"))
    })
  }
}
