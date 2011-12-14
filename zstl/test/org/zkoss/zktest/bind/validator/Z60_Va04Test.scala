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
class Z60_Va04Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = {
      <window title="new page title" border="normal" apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.viewmodel.validator.Va04')">
        va4
        <label multiline="true">
          argument command, after,converter,argument validator 
        1. input 1,click , save and show 1 and 11 
        2. enter 22, click button, become "adult"
        4. enter 33, click button, not change
        </label>
        Age can not over 30:<intbox id="ageBox" value="@init(vm.positiveOne) @save(vm.age, before='add') @validator(vm.upperBoundValidator, max=30)"/>
        <button id="addButton" label="Add 10" onClick="@command('add', increment=10)"/>
        <label id="adultLabel" value="@bind(vm.age) @converter(vm.maturityIndicator)"/>
        <separator/>
        original age:<label id="originalAge" value="@load(vm.age, before='add')"/>
        <separator/>
        10 years after:<label id="afterAge" value="@load(vm.age, after='add')"/>
      </window>
    }

    runZTL(zul, () => {
      val UNDER_AGE = "Under Age";
      val ADULT = "Adult";
      val NEGATIVE_ONE = "-1";

      val ageBox = engine $f "ageBox"
      val addButton = engine $f "addButton"
      val originalAge = engine $f "originalAge"
      val afterAge = engine $f "afterAge"
      val adultLabel = engine $f "adultLabel"

      `type`(ageBox, "1");
      click(addButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("1", getText(originalAge));
      ZKSeleneseTestCase.assertEquals("11", getText(afterAge));

      `type`(ageBox, "22");
      click(addButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals(ADULT, getText(adultLabel));

      `type`(ageBox, "33");
      click(addButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals(ADULT, getText(adultLabel));

    })
  }
}
