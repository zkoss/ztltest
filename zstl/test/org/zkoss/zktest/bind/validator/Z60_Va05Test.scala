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
class Z60_Va05Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = {
      <window title="new page title" border="normal" apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.viewmodel.validator.Va05')">
        <label multiline="true">
          va5.
        command, before, converter output with argument
        1. input -1, click, not save
        2. input 11, click, over age 10
        3. change limit to 20, click, "Under Age 20"
        4. input age 22, click, "Over age 20"
        </label>
        Age :
        <intbox id="ageBox" value="@init(vm.negativeOne) @save(vm.age, before='submit') @validator(vm.nonNegative)"/>
        limit:<intbox id="limitBox" value="10"/>
        <button id="submitButton" label="submit" onClick="@command('submit')"/>
        <label id="messageLabel" value="@bind(vm.age) @converter(vm.ageLimitIndicator, limit=limitBox.value)"/>
      </window>
    }

    runZTL(zul, () => {
      val UNDER_AGE = "Under Age";
      val OVER_AGE = "Over Age";
      val ADULT = "Adult";
      val NEGATIVE_ONE = "-1";

      val ageBox = engine $f "ageBox"
      val submitButton = engine $f "submitButton"
      val limitBox = engine $f "limitBox"
      val messageLabel = engine $f "messageLabel"

      `type`(ageBox, "-1");
      click(submitButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals(UNDER_AGE + " " + getValue(limitBox), getText(messageLabel));

      `type`(ageBox, "11");
      click(submitButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals(OVER_AGE + " " + getValue(limitBox), getText(messageLabel));

      `type`(limitBox, "20");
      click(submitButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals(UNDER_AGE + " " + getValue(limitBox), getText(messageLabel));

      `type`(ageBox, "22");
      click(submitButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals(OVER_AGE + " " + getValue(limitBox), getText(messageLabel));

    })
  }
}