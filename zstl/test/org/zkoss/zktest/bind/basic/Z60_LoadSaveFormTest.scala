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
package org.zkoss.zktest.bind.basic
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.ZKSeleneseTestCase
import org.openqa.selenium.Keys
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_LoadSaveFormTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = { // load-save-form.zul
      <window apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.basic.LoadSaveForm')">
        <vbox>
          <hbox>l1[<label id="l11" value="@init(vm.value1.value)"/>]=A</hbox>
          <hbox>l2[<label id="l12" value="@bind(vm.value2.value)"/>]=B</hbox>
          <hbox>l3[<label id="l13" value="@load(vm.value3.value)"/>]=C</hbox>
          <hbox>l4[<label id="l14" value="@load(vm.value1.value)"/>]=A</hbox>
          <hbox>l5[<label id="l15" value="@init(vm.value1.value) @load(vm.value2.value)"/>]=B</hbox>
          <hbox>]6[<label id="l16" value="@init(vm.value1.value) @load(vm.value2.value) @load(vm.value3.value)"/>]=C</hbox>
          <hbox form="@id('fx') @load(vm.value1) @save(vm.value2, before='cmd1') @save(vm.value3, before={'cmd2','cmd3'})">
            <textbox id="t21" value="@bind(fx.value)"/>
            [effect l2,l4,l5,l6]
          </hbox>
          <hbox>
            <button id="btn1" label="cmd1" onClick="@command('cmd1')"/>
            [effect l2, l5, l6]
          </hbox>
          <hbox>
            <button id="btn2" label="cmd2" onClick="@command('cmd2')"/>
            [effect l3, l6]
          </hbox>
          <hbox>
            <button id="btn3" label="cmd3" onClick="@command('cmd3')"/>
            [effect l3, l6]
          </hbox>
        </vbox>
        <button label="Dump" onClick="mybinder.getTracker().dump()"/>
      </window>
    }

    runZTL(zul, () => {
      `type`(jq("$t21").toWidget(), "X");
      waitResponse();
      verifyEquals("A", jq("$l11").toWidget().get("value"));
      verifyEquals("B", jq("$l12").toWidget().get("value"));
      verifyEquals("C", jq("$l13").toWidget().get("value"));
      verifyEquals("A", jq("$l14").toWidget().get("value"));
      verifyEquals("B", jq("$l15").toWidget().get("value"));
      verifyEquals("C", jq("$l16").toWidget().get("value"));
      click(jq("$btn1").toWidget());
      waitResponse();
      verifyEquals("A", jq("$l11").toWidget().get("value"));
      verifyEquals("X", jq("$l12").toWidget().get("value"));
      verifyEquals("C", jq("$l13").toWidget().get("value"));
      verifyEquals("A", jq("$l14").toWidget().get("value"));
      verifyEquals("X", jq("$l15").toWidget().get("value"));
      verifyEquals("X", jq("$l16").toWidget().get("value"));
      `type`(jq("$t21").toWidget(), "Y");
      waitResponse();
      verifyEquals("A", jq("$l11").toWidget().get("value"));
      verifyEquals("X", jq("$l12").toWidget().get("value"));
      verifyEquals("C", jq("$l13").toWidget().get("value"));
      verifyEquals("A", jq("$l14").toWidget().get("value"));
      verifyEquals("X", jq("$l15").toWidget().get("value"));
      verifyEquals("X", jq("$l16").toWidget().get("value"));
      click(jq("$btn2").toWidget());
      waitResponse();
      verifyEquals("A", jq("$l11").toWidget().get("value"));
      verifyEquals("X", jq("$l12").toWidget().get("value"));
      verifyEquals("Y", jq("$l13").toWidget().get("value"));
      verifyEquals("A", jq("$l14").toWidget().get("value"));
      verifyEquals("X", jq("$l15").toWidget().get("value"));
      verifyEquals("Y", jq("$l16").toWidget().get("value"));
      `type`(jq("$t21").toWidget(), "Z");
      waitResponse();
      verifyEquals("A", jq("$l11").toWidget().get("value"));
      verifyEquals("X", jq("$l12").toWidget().get("value"));
      verifyEquals("Y", jq("$l13").toWidget().get("value"));
      verifyEquals("A", jq("$l14").toWidget().get("value"));
      verifyEquals("X", jq("$l15").toWidget().get("value"));
      verifyEquals("Y", jq("$l16").toWidget().get("value"));
      click(jq("$btn3"));
      waitResponse();
      verifyEquals("A", jq("$l11").toWidget().get("value"));
      verifyEquals("X", jq("$l12").toWidget().get("value"));
      verifyEquals("Z", jq("$l13").toWidget().get("value"));
      verifyEquals("A", jq("$l14").toWidget().get("value"));
      verifyEquals("X", jq("$l15").toWidget().get("value"));
      verifyEquals("Z", jq("$l16").toWidget().get("value"));
    })
  }
}

