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
import org.zkoss.ztl.ZKSeleneseTestCase
import org.openqa.selenium.Keys
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_Va01 extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = {
      <window title="new page title" border="normal" apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.viewmodel.validator.Va01')">
        va1.
        <label multiline="true">
          Validator + Command. save before submit.
        
        1. input a number >= 18, label=Adult
        2. input a negative number, click submit.
        3. input a number  >=0, less than 8
        </label>
        Age :<intbox id="ageBox" value="@init(vm.negativeOne) @save(vm.age, before='submit') @validator(vm.nonNegative)"/>
        <button id="submitButton" label="submit" onClick="@command('submit')"/>
        <label id="adultLabel" value="@bind(vm.age) @converter(vm.maturityIndicator)"/>
      </window>
    }

    runZTL(zul, () => {
      val UNDER_AGE = "Under Age";
      val ADULT = "Adult";
      val NEGATIVE_ONE = "-1";

      val ageBox = engine $f "ageBox"
      val submitButton = engine $f "submitButton"
      val adultLabel = engine $f "adultLabel"

      ZKSeleneseTestCase.assertEquals(NEGATIVE_ONE, getValue(ageBox));

      `type`(ageBox, "22");
      click(submitButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals(ADULT, getText(adultLabel));

      `type`(ageBox, "-1");
      click(submitButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals(ADULT, getText(adultLabel));

      `type`(ageBox, "11");
      click(submitButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals(UNDER_AGE, getText(adultLabel));

    })
  }
}