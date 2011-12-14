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
package org.zkoss.zktest.bind.form
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.ZKSeleneseTestCase
import org.openqa.selenium.Keys
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_F2 extends ZTL4ScalaTestCase {
  def testArg() = {

    val zul = {
      <vbox apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.viewmodel.form.F2')" width="400px">
        <label multiline="true">
          f1.
    form, command+argument, validator+argument,notifychange
    1. input 5 in quantity of item A and item B
    2. click compute, subtotal updated, total should be 150
    3. input 11 in quantity of item A, compute, total not changed
    4. input 5 in quantity of item A, select off% 50
    5. compute, total should be 75
        </label>
        <grid form="@id('fx') @load(vm.order) @save(vm.order, before='compute') @validator(vm.f2Validator, max=10)">
          <columns>
            <column label="Name"/>
            <column label="Price"/>
            <column label="Quantity (less than 10)" width="140px"/>
            <column label="Subtotal"/>
          </columns>
          <rows>
            <row>
              <label value="Item A"/>
              <label value="10"/>
              <intbox id="quantityABox" value="@bind(fx.quantityA)"/>
              <label id="subtotalA" value="@bind(vm.order.subtotalA)"/>
            </row>
            <row>
              <label value="Item B"/>
              <label value="20"/>
              <intbox id="quantityBBox" value="@bind(fx.quantityB) "/>
              <label id="subtotalB" value="@bind(vm.order.subtotalB)"/>
            </row>
            <row>
              <label value=""/>
              <label value="Off %"/>
              <combobox id="offBox" width="80px">
                <comboitem label="90" value="90"/>
                <comboitem label="80" value="80"/>
                <comboitem label="70" value="70"/>
                <comboitem label="60" value="60"/>
                <comboitem label="50" value="50"/>
              </combobox>
              <button id="computeButton" label="Compute" onClick="@command('compute', off=offBox.selectedItem.value)"/>
            </row>
            <row>
              <label value="Total"/>
              <label value=""/>
              <label value=""/>
              <label id="total" value="@load(vm.order.total,after='compute')"/>
            </row>
          </rows>
        </grid>
      </vbox>
    }

    runZTL(zul, () => {

      val quantityABox = engine $f "quantityABox"
      val quantityBBox = engine $f "quantityBBox"
      val computeButton = engine $f "computeButton"
      val subtotalA = engine $f "subtotalA"
      val subtotalB = engine $f "subtotalB"
      val total = engine $f "total"
      val offBox = engine $f "offBox"

      `type`(quantityABox, "5");
      `type`(quantityBBox, "5");
      click(computeButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("50", getText(subtotalA));
      ZKSeleneseTestCase.assertEquals("100", getText(subtotalB));
      ZKSeleneseTestCase.assertEquals("150", getText(total));

      `type`(quantityABox, "11");
      click(computeButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("150", getText(total));

      `type`(quantityABox, "5");
      `type`(offBox.$n("real"), "50");
      click(computeButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("75", getText(total));
    })

  }
}