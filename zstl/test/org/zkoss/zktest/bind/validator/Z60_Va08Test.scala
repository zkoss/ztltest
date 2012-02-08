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
package org.zkoss.zktest.bind.validator
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.ZKSeleneseTestCase

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_Va08Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = {
      <include src="/bind/validator/va08.zul"/>
    }

    runZTL(zul, () => {

      val keywordBox = engine $f "keywordBox"
      val keywordLabel = engine $f "keywordLabel"

      `type`(keywordBox, "123");
      sendKeys(keywordBox, Keys.TAB); //change focus
      waitResponse();
      ZKSeleneseTestCase.assertEquals("123", getText(keywordLabel));

      `type`(keywordBox, "1234");
      sendKeys(keywordBox, Keys.TAB);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("123", getText(keywordLabel));

    })
  }
}
