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
class Z60_Va11Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = {
      <window title="va11" border="normal" apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.viewmodel.validator.Va11')">
        va11.
        <label multiline="true">
          Validator + Command. save before submit.

            1. input a negative number, not save
            2. input 1, label is "Less than 13 Less than 18"
            3. input 15, label is "less than 18"
            4. input 22, label is "over 18"
        </label>
        Age :
        <intbox id="ageBox" value="@init(vm.negativeOne) @save(vm.age, before='classify') @validator(vm.nonNegative)"/>
        <button id="submitButton" label="classify" onClick="@command('classify')"/>
        <separator/>
        CLASSIFY:
        <label id="less13" value="Less than 13" visible="@load(vm.lessThanThirteen, after='classify')"/>
        <label id="less18" value="Less than 18" visible="@load(vm.lessThanEighteen, after='classify')"/>
        <label id="over18" value="Over 18" visible="@init(vm.overEighteen) @load(vm.overEighteen,after='classify')"/>
        <separator/>
      </window>
    }

    runZTL(zul, () => {

      val LESS_13 = "Less than 13";
      val LESS_18 = "Less than 18";
      val OVER_18 = "Over 18";

      val ageBox = engine $f "ageBox"
      val submitButton = engine $f "submitButton"
      val less13 = engine $f "less13"
      val less18 = engine $f "less18"
      val over18 = engine $f "over18"

      `type`(ageBox, "-1");
      click(submitButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals(true, isVisible(less13));
      ZKSeleneseTestCase.assertEquals(true, isVisible(less18));
      ZKSeleneseTestCase.assertEquals(false, isVisible(over18));

      `type`(ageBox, "1");
      click(submitButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals(true, isVisible(less13));
      ZKSeleneseTestCase.assertEquals(true, isVisible(less18));
      ZKSeleneseTestCase.assertEquals(false, isVisible(over18));

      `type`(ageBox, "15");
      click(submitButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals(false, isVisible(less13));
      ZKSeleneseTestCase.assertEquals(true, isVisible(less18));
      ZKSeleneseTestCase.assertEquals(false, isVisible(over18));

      `type`(ageBox, "18");
      click(submitButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals(false, isVisible(less13));
      ZKSeleneseTestCase.assertEquals(false, isVisible(less18));
      ZKSeleneseTestCase.assertEquals(true, isVisible(over18));

    })
  }
}