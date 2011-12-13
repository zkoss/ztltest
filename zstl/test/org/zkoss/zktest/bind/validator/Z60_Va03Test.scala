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
class Z60_Va03Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = {
      <window title="new page title" border="normal" apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.viewmodel.validator.Va03')">
        va3
        <label multiline="true">
          command argument, before, converter, validator argument, 
        1. input 1, not save 
        2. enter 28, click, show 18, Adult
        </label>
        age can NOT less 10 :<intbox id="ageBox" value="@init(vm.age) @save(vm.age, before='minus') @validator(vm.lowerBoundValidator, min=10)"/>
        <button id="minusButton" label="Minus 10" onClick="@command('minus' , decrement=10)"/>
        <label id="adultLabel" value="@bind(vm.age) @converter(vm.maturityIndicator)"/>
        <separator/>
        10 years ago :<label id="ageLabel" value="@load(vm.age, after='minus')"/>
      </window>
    }

    runZTL(zul, () => {

      val UNDER_AGE = "Under Age";
      val ADULT = "Adult";
      val NEGATIVE_ONE = "-1";

      val ageBox = engine $f "ageBox"
      val minusButton = engine $f "minusButton"
      val adultLabel = engine $f "adultLabel"
      val ageLabel = engine $f "ageLabel"

      `type`(ageBox, "1");
      click(minusButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals(UNDER_AGE, getText(adultLabel));

      `type`(ageBox, "28");
      click(minusButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals(ADULT, getText(adultLabel));
      ZKSeleneseTestCase.assertEquals("18", getText(ageLabel));

    })
  }
}