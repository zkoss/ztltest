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
class Z60_Va06Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = {
      <window title="new page title" border="normal" apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.viewmodel.validator.Va06')">
        <label multiline="true">
          v6.command, before, converter input with argument
        1. input -1, not save
        2. input 22, adult is checked
        3. input 1, adult no checked
        </label>
        <intbox id="ageBox" value="@init(vm.negativeOne) @save(vm.adult, before='checkAdult') @converter(vm.adultConverter) @validator(vm.booleanValidator)"/>
        <button id="checkButton" label="checkAdult" onClick="@command('checkAdult')"/>
        <checkbox id="adultBox" checked="@load(vm.adult)" label="Is Adult"/>
      </window>
    }

    runZTL(zul, () => {
      val UNDER_AGE = "Under Age";
      val ADULT = "Adult";
      val NEGATIVE_ONE = "-1";

      val checkBox = engine $f "adultBox"
      val ageBox = engine $f "ageBox"
      val checkButton = engine $f "checkButton"

      `type`(ageBox, "-1");
      click(checkButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("false", checkBox.get("checked"));

      `type`(ageBox, "22");
      click(checkButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("true", checkBox.get("checked"));

      `type`(ageBox, "1");
      click(checkButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("false", checkBox.get("checked"));
    })
  }
}