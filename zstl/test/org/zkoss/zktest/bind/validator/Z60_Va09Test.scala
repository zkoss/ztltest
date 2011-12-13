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
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.ZKSeleneseTestCase

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_Va09Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = {
      <window title="new page title" border="normal" apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.viewmodel.validator.Va09')">
        va9. validator + arguments from another binding:<separator/>
        <label multiline="true">
          1. input max length is 3
        2. input 123, show 123
        3. input 1234, show 123
        4. input max length is 5
        5. input 12345, show 12345
        </label>
        max length is:<intbox id="lengthBox" value="@bind(vm.maxLength)"/>
        <separator/>
        intput:<textbox id="keywordBox" value="@save(vm.keyword) @validator(vm.maxLengthValidator, length=vm.maxLength)">
               </textbox>
        <separator/>
        you enter:<label id="keywordLabel" value="@load(vm.keyword)"/>
      </window>
    }

    runZTL(zul, () => {

      val keywordBox = engine $f "keywordBox"
      val keywordLabel = engine $f "keywordLabel"
      val lengthBox = engine $f "lengthBox"

      `type`(keywordBox, "123");
      click(lengthBox); //to change focus
      waitResponse();
      ZKSeleneseTestCase.assertEquals("123", getText(keywordLabel));

      `type`(keywordBox, "1234");
      click(lengthBox);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("123", getText(keywordLabel));

      `type`(lengthBox, "5");
      `type`(keywordBox, "12345");
      click(keywordLabel);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("12345", getText(keywordLabel));

    })
  }
}