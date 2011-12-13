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
class Z60_Va07Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = {
      <window title="new page title" border="normal" apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.viewmodel.validator.Va07')">
        va7. validator + init:
        <separator/>
        <label multiline="true">
          1. input -1, click to change focus, show 0
        2. input 2, click, show 2
        </label>
        <intbox id="ageBox" value="@init(vm.negativeOne) @save(vm.age) @validator(vm.nonNegative)">
        </intbox>
        <separator/>
        you enter:<label id="ageLabel" value="@load(vm.age)"/>
      </window>
    }

    runZTL(zul, () => {

      val ageBox = engine $f "ageBox"
      val ageLabel = engine $f "ageLabel"

      `type`(ageBox, "-1");
      click(ageLabel);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("0", getText(ageLabel));

      `type`(ageBox, "2");
      click(ageLabel);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("2", getText(ageLabel));

    })
  }
}
