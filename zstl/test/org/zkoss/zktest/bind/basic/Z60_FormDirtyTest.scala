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
import org.zkoss.ztl.ClientWidget

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_FormDirtyTest extends ZTL4ScalaTestCase {
  @Test
  def testArg() = {
    val zul = {
      <include src="/bind/basic/form-dirty.zul"/>
    }

    runZTL(zul, () => {
      def `type` = (n: ClientWidget, input: String) => {
    	n.toElement().set("value", "")
        sendKeys(n, input)
    	waitResponse()
    	blur(n)
      }
      
      verifyEquals("false", jq("$dirty").toWidget().get("value"))
      verifyEquals("Dennis", jq("$l1").toWidget().get("value"))
      
      `type`(jq("$t1").toWidget(), "X")
      waitResponse()
      verifyEquals("true", jq("$dirty").toWidget().get("value"))
      verifyEquals("X", jq("$l1").toWidget().get("value"))
      
      `type`(jq("$t1").toWidget(), "Dennis")
      waitResponse()
      verifyEquals("true", jq("$dirty").toWidget().get("value"))
      verifyEquals("Dennis", jq("$l1").toWidget().get("value"))
      
      `type`(jq("$t1").toWidget(), "Y")
      waitResponse()
      verifyEquals("true", jq("$dirty").toWidget().get("value"))
      verifyEquals("Y", jq("$l1").toWidget().get("value"))
      
      click(jq("$btn2").toWidget())
      waitResponse()
      verifyEquals("old-name Dennis", jq("$msg").toWidget().get("value"))
      
      click(jq("$btn1").toWidget())
      waitResponse()
      verifyEquals("saved Y", jq("$msg").toWidget().get("value"))
      
      click(jq("$btn2").toWidget())
      waitResponse()
      verifyEquals("old-name Y", jq("$msg").toWidget().get("value"))
      verifyEquals("false", jq("$dirty").toWidget().get("value"))
      verifyEquals("Y", jq("$l1").toWidget().get("value"))
    })
  }
}