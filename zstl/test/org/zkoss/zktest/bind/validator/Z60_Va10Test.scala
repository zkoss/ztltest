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
class Z60_Va10Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = {
      <groupbox apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.viewmodel.validator.Va10')">
        <caption label="va10. multiple field validation"/>
        <label multiline="true">
          va10.
        end day should be later than start date
        1. input start date 2011/11/02, end date 2011/11/03, click ok, display date
        2. change end date to 2011/11/01, click ok, display unchaged.
        </label>
        start:<datebox id="start" format="yyyy/MM/dd" value="@save(vm.startDate, before='ok')"/>
        end:<datebox id="end" format="yyyy/MM/dd" value="@save(vm.endDate, before='ok') @validator(vm.durationValidator, start='startDate', end='endDate'))"/>
        <button id="okButton" label="OK" onClick="@command('ok')"/><separator/>
        start:<label id="startLabel" value="@bind(vm.startDate)"/><separator/>
        end:<label id="endLabel" value="@bind(vm.endDate)"/>
      </groupbox>
    }

    runZTL(zul, () => {

      val start = engine $f "start"
      val end = engine $f "end"
      val okButton = engine $f "okButton"
      val startLabel = engine $f "startLabel"
      val endLabel = engine $f "endLabel"

      `type`(start.$n("real"), "2011/11/02");
      `type`(end.$n("real"), "2011/11/03");
      //check input is correct
      ZKSeleneseTestCase.assertEquals("2011/11/02", jq(start.$n("real")).`val`());
      ZKSeleneseTestCase.assertEquals("2011/11/03", jq(end.$n("real")).`val`());
      click(okButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("Wed Nov 02 00:00:00 CST 2011", jq(startLabel).text());
      ZKSeleneseTestCase.assertEquals("Thu Nov 03 00:00:00 CST 2011", jq(endLabel).text());

      `type`(end.$n("real"), "2011/11/01");
      ZKSeleneseTestCase.assertEquals("2011/11/01", jq(end.$n("real")).`val`());
      click(okButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("Wed Nov 02 00:00:00 CST 2011", jq(startLabel).text());
      ZKSeleneseTestCase.assertEquals("Thu Nov 03 00:00:00 CST 2011", jq(endLabel).text());

    })
  }
}
