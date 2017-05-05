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
class Z60_MVP2MVVMTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/basic/mvp2mvvm_mvp.zul"/>
"""

    runZTL(zul, () => {
      verifyEquals("true", jq("$textA").toWidget().get("disabled"))
      click(jq("$outerToggle1").toWidget())
      waitResponse()
      verifyEquals("false", jq("$textA").toWidget().get("disabled"))
      click(jq("$outerToggle2").toWidget())
      waitResponse()
      verifyEquals("true", jq("$textA").toWidget().get("disabled"))
      click(jq("$innerToggle").toWidget())
      waitResponse()
      verifyEquals("false", jq("$textA").toWidget().get("disabled"))
    })
  }
}