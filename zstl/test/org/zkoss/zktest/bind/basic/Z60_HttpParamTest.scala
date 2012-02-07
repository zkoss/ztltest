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
class Z60_HttpParamTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = {
      <include src="/bind/basic/httpparam.zul"/>
    }

    runZTL(zul, () => {
      click(jq("$cmd1").toWidget())
      waitResponse()
      // verifyTrue(jq("$l11").toWidget().get("value") != null) // not available in ztltest
      verifyTrue(jq("$l12").toWidget().get("value") != null)
      verifyTrue(jq("$l13").toWidget().get("value") != null)
      // verifyFalse("".equals(jq("$l11").toWidget().get("value").trim())) // not available in ztltest
      verifyFalse("".equals(jq("$l12").toWidget().get("value").trim()))
      verifyFalse("".equals(jq("$l13").toWidget().get("value").trim()))
    })
  }
}