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
class Z60_Va12Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = {
      <window border="normal" width="400px" apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.viewmodel.validator.Va12')">
        va12
        <label multiline="true">
          argument Validator + argument Command, dependsOn

            1. initail input, compute, 30
            2. input 10 for quantity A, subtotal 100 
            3. input 11 for quantity B, subtotal unchanged
            4. input 10 for quantity B, subtoal 200, compute, total 300
            5. input 90% off, compute, 270
        </label>
        <grid>
          <columns>
            <column label="Name"/>
            <column label="Price"/>
            <column label="Quantity (less than 10)" width="150px"/>
            <column label="Subtotal"/>
          </columns>
          <rows>
            <row>
              <label value="Item A"/>
              <label value="10"/>
              <intbox id="quantityABox" value="@bind(vm.quantityA) @validator(vm.upperBoundValidator, max=10)"/>
              <label id="subtotalA" value="@bind(vm.subtotalA)"/>
            </row>
            <row>
              <label value="Item B"/>
              <label value="20"/>
              <intbox id="quantityBBox" value="@bind(vm.quantityB) @validator(vm.upperBoundValidator, max=10)"/>
              <label id="subtotalB" value="@bind(vm.subtotalB)"/>
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
              <label id="total" value="@load(vm.total, after='compute')"/>
            </row>
          </rows>
        </grid>
      </window>
    }

    runZTL(zul, () => {

      val computeButton = engine $f "computeButton"
      val total = engine $f "total"
      val quantityABox = engine $f "quantityABox"
      val quantityBBox = engine $f "quantityBBox"
      val subtotalA = engine $f "subtotalA"
      val subtotalB = engine $f "subtotalB"
      val offBox = engine $f "offBox"

      click(computeButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("30", getText(total));

      `type`(quantityABox, "10");
      click(subtotalA);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("100", getText(subtotalA));

      `type`(quantityBBox, "11");
      click(subtotalB);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("20", getText(subtotalB));

      `type`(quantityBBox, "10");
      click(subtotalB);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("200", getText(subtotalB));

      click(computeButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("300", getText(total));

      `type`(offBox.$n("real"), "90");
      click(computeButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("270", getText(total));

    })
  }
}