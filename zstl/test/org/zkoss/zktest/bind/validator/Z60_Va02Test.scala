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
class Z60_Va02Test extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = {
      <window title="va2" border="normal" apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.viewmodel.validator.Va02')">
        va2
        <label multiline="true">
          1. input negative, click, not save 
        2. enter 1, click, add 10, label show 1 and 11
        4. input 18, adult
        </label>
        Age :<intbox id="ageBox" value="@init(vm.negativeOne) @save(vm.age, before='add10') @validator(vm.nonNegative)"/>
        <button id="addButton" label="Add 10" onClick="@command('add10')"/>
        <label id="adultLabel" value="@bind(vm.age) @converter(vm.maturityIndicator)"/>
        <separator/>
        age before added:<label id="beforeAge" value="@load(vm.age,before='add10')"/>
        <separator/>
        current age:<label id="ageLabel" value="@load(vm.age, after='add10')"/>
      </window>
    }

    runZTL(zul, () => {
      val UNDER_AGE = "Under Age";
      val ADULT = "Adult";
      val NEGATIVE_ONE = "-1";

      val ageBox = engine $f "ageBox"
      val addButton = engine $f "addButton"
      val adultLabel = engine $f "adultLabel"
      val beforeAge = engine $f "beforeAge"
      val ageLabel = engine $f "ageLabel"

      ZKSeleneseTestCase.assertEquals(NEGATIVE_ONE, getValue(ageBox));
      click(addButton);
      ZKSeleneseTestCase.assertEquals(UNDER_AGE, getText(adultLabel));

      `type`(ageBox, "1");
      click(addButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("1", getText(beforeAge));
      ZKSeleneseTestCase.assertEquals("11", getText(ageLabel));
      ZKSeleneseTestCase.assertEquals(UNDER_AGE, getText(adultLabel));

      `type`(ageBox, "18");
      click(addButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals(ADULT, getText(adultLabel));

    })
  }
}
