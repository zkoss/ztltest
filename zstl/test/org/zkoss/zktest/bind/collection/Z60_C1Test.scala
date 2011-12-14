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
package org.zkoss.zktest.bind.collection

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.ZKSeleneseTestCase
import org.openqa.selenium.Keys
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_C1 extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = {
      <vbox apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.viewmodel.collection.C1')">
        <label multiline="true">
          c1.
        1. select combobox
        2. content of listbox shall change.
        </label>
        <combobox id="singleBox" visible="@load(vm.single)" model="@bind(vm.listNameList)" selectedItem="@bind(vm.selectedOne)">
          <template name="model" var="n">
            <comboitem label="@bind(n)" value="@bind(n)"></comboitem>
          </template>
        </combobox>
        <label value="List Content:"/>
        <listbox id="contentListbox" model="@bind(vm.selectedList)">
          <template name="model" var="f">
            <listitem>
              <listcell label="@bind(f)"></listcell>
            </listitem>
          </template>
        </listbox>
      </vbox>
    }
    runZTL(zul, () => {
    	
      val singleBox = engine $f "singleBox"
      val contentListbox = engine $f "contentListbox"
      
      `type`(singleBox.$n("real"), "Car Mark");
      sendKeys(singleBox.$n("real"), Keys.TAB);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("TOYOTA", contentListbox.firstChild().get("label"));

      `type`(singleBox.$n("real"), "Fruit");
      sendKeys(singleBox.$n("real"), Keys.TAB);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("Apple", contentListbox.firstChild().get("label"));
      
    })
  }
}