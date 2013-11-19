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
import org.zkoss.ztl.ZKSeleneseTestCase
import org.openqa.selenium.Keys
import org.zkoss.ztl.Tags
import org.junit.Test

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_LoadSavePromptCommandValidationTest extends ZTL4ScalaTestCase {
  @Test
  def testArg() = {
    val zul = { 
      <include src="/bind/basic/load-save-prompt-command-validation.zul" />
    }

    runZTL(zul, () => {
      verifyEquals("A", jq("$l11").toWidget().get("value"))
      verifyEquals("B", jq("$l12").toWidget().get("value"))
      verifyEquals("C", jq("$l13").toWidget().get("value"))
      `type`(jq("$t12").toWidget(), "GG")
      waitResponse()
      `type`(jq("$t11").toWidget(), "PP")
      waitResponse()
      verifyEquals("A", jq("$l11").toWidget().get("value"))
      verifyEquals("B", jq("$l12").toWidget().get("value"))
      verifyEquals("C", jq("$l13").toWidget().get("value"))
      verifyEquals("value 1 has to be XX or ZZ", jq("$msg1").toWidget().get("value"))
      verifyEquals("value 2 has to be YY or ZZ", jq("$msg2").toWidget().get("value"))
      `type`(jq("$t11").toWidget(), "XX")
      waitResponse()
      verifyEquals("XX", jq("$l11").toWidget().get("value"))
      verifyEquals("B", jq("$l12").toWidget().get("value"))
      verifyEquals("C", jq("$l13").toWidget().get("value"))
      verifyEquals("", jq("$msg1").toWidget().get("value"))
      verifyEquals("value 2 has to be YY or ZZ", jq("$msg2").toWidget().get("value"))
      `type`(jq("$t11").toWidget(), "YY")
      waitResponse()
      verifyEquals("XX", jq("$l11").toWidget().get("value"))
      verifyEquals("YY", jq("$l12").toWidget().get("value"))
      verifyEquals("GG", jq("$l13").toWidget().get("value"))
      verifyEquals("doCmd1", jq("$msg1").toWidget().get("value"))
      verifyEquals("", jq("$msg2").toWidget().get("value"))
      `type`(jq("$t11").toWidget(), "ZZ")
      waitResponse()
      verifyEquals("ZZ", jq("$l11").toWidget().get("value"))
      verifyEquals("ZZ", jq("$l12").toWidget().get("value"))
      verifyEquals("GG", jq("$l13").toWidget().get("value"))
      verifyEquals("doCmd1", jq("$msg1").toWidget().get("value"))
      verifyEquals("", jq("$msg2").toWidget().get("value"))
    })
  }
}