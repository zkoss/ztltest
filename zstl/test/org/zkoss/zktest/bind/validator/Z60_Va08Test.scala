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
      <window title="new page title" border="normal" apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.viewmodel.validator.Va08')">
        va8. validator + arguments:<separator/>
        <label multiline="true">
          1. input 123, click, show 123
        2. input 1234, click, show 123
        </label>
        keyword (max length is 3):<textbox id="keywordBox" value="@save(vm.keyword) @validator(vm.maxLengthValidator, length=3)">
                                  </textbox>
        <separator/>
        you enter:<label id="keywordLabel" value="@load(vm.keyword)"/>
      </window>
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
