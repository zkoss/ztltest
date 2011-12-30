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
class Z60_LoadSavePromptCommandValidationTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = { // load-save-prompt-command-validation.zul
      <window apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.basic.LoadSavePromptCommandValidation')">
        <vbox>
          the value should only save to value1 and value 2 when it is ZZ. if you type XX, or YY, it should not save to
          <hbox>l1[<label id="l11" value="@load(vm.value1)"/>]=A</hbox>
          <hbox>l2[<label id="l12" value="@load(vm.value2)"/>]=B</hbox>
          <hbox>l2[<label id="l13" value="@load(vm.value3)"/>]=B</hbox>
          <label id="msg1" value="@load(vm.msg1)"/>
          <label id="msg2" value="@load(vm.msg2)"/>
          <hbox>
            <textbox id="t11" value="@save(vm.value1, v1=true) @save(vm.value2,v2=true,after='cmd1') @validator(vm.validator1)" onChange="@command('cmd1')"/>
            <textbox id="t12" value="@save(vm.value3,after='cmd1')"/>
          </hbox>
        </vbox>
        <button label="Dump" onClick="mybinder.getTracker().dump()"/>
      </window>
    }

    runZTL(zul, () => {
      verifyEquals("A", jq("$l11").toWidget().get("value"))
      verifyEquals("B", jq("$l12").toWidget().get("value"))
      verifyEquals("C", jq("$l13").toWidget().get("value"))
      `type`(jq("$t12").toWidget(), "GG")
      waitResponse()
      `type`(jq("$t11").toWidget(), "PP")
      waitResponse()
      verifyEquals("A", jq("$l11").toWidget().get("value"))
      verifyEquals("B", jq("$l12").toWidget().get("value"))
      verifyEquals("C", jq("$l13").toWidget().get("value"))
      verifyEquals("value 1 has to be XX or ZZ", jq("$msg1").toWidget().get("value"))
      verifyEquals("value 2 has to be YY or ZZ", jq("$msg2").toWidget().get("value"))
      `type`(jq("$t11").toWidget(), "XX")
      waitResponse()
      verifyEquals("A", jq("$l11").toWidget().get("value"))
      verifyEquals("B", jq("$l12").toWidget().get("value"))
      verifyEquals("C", jq("$l13").toWidget().get("value"))
      verifyEquals("", jq("$msg1").toWidget().get("value"))
      verifyEquals("value 2 has to be YY or ZZ", jq("$msg2").toWidget().get("value"))
      `type`(jq("$t11").toWidget(), "YY")
      waitResponse()
      verifyEquals("A", jq("$l11").toWidget().get("value"))
      verifyEquals("B", jq("$l12").toWidget().get("value"))
      verifyEquals("C", jq("$l13").toWidget().get("value"))
      verifyEquals("value 1 has to be XX or ZZ", jq("$msg1").toWidget().get("value"))
      verifyEquals("", jq("$msg2").toWidget().get("value"))
      `type`(jq("$t11").toWidget(), "ZZ")
      waitResponse()
      verifyEquals("ZZ", jq("$l11").toWidget().get("value"))
      verifyEquals("ZZ", jq("$l12").toWidget().get("value"))
      verifyEquals("GG", jq("$l13").toWidget().get("value"))
      verifyEquals("doCmd1", jq("$msg1").toWidget().get("value"))
      verifyEquals("", jq("$msg2").toWidget().get("value"))
    })
  }
}