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
class Z60_ValidationMessagesTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = { // validationmessages.zul
      <window apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.basic.ValidationMessagesVM')" validationMessages="@id('vmsgs')">
        <vbox>
          <hbox>Value1:<label id="l11" value="@bind(vm.value1)"></label></hbox>
          <hbox>Value2:<label id="l12" value="@bind(vm.value2)"></label></hbox>
        </vbox>
        <vbox>
          Prompt:
          <hlayout>Value1:<textbox id="t21" value="@bind(vm.value1) @validator(vm.validator1)" errorMessage="@bind(vmsgs[self])"/></hlayout>
          <hlayout>Value2:<intbox id="t22" value="@bind(vm.value2) @validator(vm.validator2)" errorMessage="@bind(vmsgs[self])"/></hlayout>
        </vbox>
        <vbox>
          Command:
          <hlayout>
            Value1:
            <textbox id="t31" value="@load(vm.value1) @save(vm.value1 ,before='cmd1') @validator(vm.validator1)"/>
            <label id="m31" value="@bind(vmsgs[t31])"/>
          </hlayout>
          <hlayout>
            Value2:
            <intbox id="t32" value="@load(vm.value2) @save(vm.value2 ,before='cmd1') @validator(vm.validator2)"/>
            <label id="m32" value="@bind(vmsgs[self.previousSibling])"/>
          </hlayout>
        </vbox>
        <hbox>
          <button id="btn1" label="cmd1" onClick="@command('cmd1')"/>
        </hbox>
        <vbox form="@id('fx') @load(vm) @save(vm ,before='cmd2') @validator(vm.validator3)">
          Form:
          <hlayout>
            Value1:
            <textbox id="t41" value="@bind(fx.value1) @validator(vm.validator1)"/>
            <label id="m41" value="@bind(vmsgs[t41])"/>
          </hlayout>
          <hlayout>
            Value2:
            <intbox id="t42" value="@bind(fx.value2) @validator(vm.validator2)"/>
            <label id="m42" value="@bind(vmsgs[self.previousSibling])"/>
          </hlayout>
          <label id="m43" value="@bind(vmsgs[self.parent])"/>
          <label id="m44" value="@bind(vmsgs.getMessages(self.parent,'fx')[0])"/>
          <label id="m45" value="@bind(vmsgs.multiple[self.parent][0])"/>
          <label id="m46" value="@bind(vmsgs.multiple[self.parent][1])"/>
          <grid id="msggrid" model="@bind(vmsgs.multiple[self.parent])" visible="@bind(not empty vmsgs.multiple[self.parent])">
            <template name="model" var="msg">
              <row>
                <label value="@bind(msg)"/>
              </row>
            </template>
          </grid>
        </vbox>
        <hbox>
          <button id="btn2" label="cmd2" onClick="@command('cmd2')"/>
          <button id="btn3" label="cmd3" onClick="@command('cmd3')"/>
        </hbox>
      </window>
    }

    runZTL(zul, () => {
      var l11 = jq("$l11")
      var l12 = jq("$l12")
      var t21 = jq("$t21")
      var t22 = jq("$t22")
      var t31 = jq("$t31")
      var t32 = jq("$t32")
      var m31 = jq("$m31")
      var m32 = jq("$m32")
      var btn1 = jq("$btn1")
      var t41 = jq("$t41")
      var t42 = jq("$t42")
      var m41 = jq("$m41")
      var m42 = jq("$m42")
      var m43 = jq("$m43")
      var m44 = jq("$m44")
      var m45 = jq("$m45")
      var m46 = jq("$m46")
      var btn2 = jq("$btn2")
      var btn3 = jq("$btn3")
      verifyEquals("ABC", l11.toWidget().get("value"))
      verifyEquals("10", l12.toWidget().get("value"))
      verifyEquals("ABC", t21.toWidget().get("value"))
      verifyEquals("10", t22.toWidget().get("value"))
      verifyEquals("ABC", t31.toWidget().get("value"))
      verifyEquals("10", t32.toWidget().get("value"))
      verifyEquals("", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("ABC", t41.toWidget().get("value"))
      verifyEquals("10", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("", m43.toWidget().get("value"))
      verifyEquals("", m44.toWidget().get("value"))
      `type`(t21.toWidget(), "ABCD")
      waitResponse()
      `type`(t22.toWidget(), "6")
      waitResponse()
      verifyEquals("ABC", l11.toWidget().get("value"))
      verifyEquals("10", l12.toWidget().get("value"))
      verifyEquals("ABCD", t21.toWidget().get("value"))
      verifyEquals("6", t22.toWidget().get("value"))
      verifyEquals("ABC", t31.toWidget().get("value"))
      verifyEquals("10", t32.toWidget().get("value"))
      verifyEquals("", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("ABC", t41.toWidget().get("value"))
      verifyEquals("10", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("", m43.toWidget().get("value"))
      verifyEquals("", m44.toWidget().get("value"))
      `type`(t21.toWidget(), "Abc")
      waitResponse()
      `type`(t22.toWidget(), "33")
      waitResponse()
      verifyEquals("Abc", l11.toWidget().get("value"))
      verifyEquals("33", l12.toWidget().get("value"))
      verifyEquals("Abc", t21.toWidget().get("value"))
      verifyEquals("33", t22.toWidget().get("value"))
      verifyEquals("Abc", t31.toWidget().get("value"))
      verifyEquals("33", t32.toWidget().get("value"))
      verifyEquals("", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("ABC", t41.toWidget().get("value"))
      verifyEquals("10", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("", m43.toWidget().get("value"))
      verifyEquals("", m44.toWidget().get("value"))
      `type`(t31.toWidget(), "XXX")
      waitResponse()
      `type`(t32.toWidget(), "1") // intbox has reset issue...too bad
      waitResponse()
      verifyEquals("Abc", l11.toWidget().get("value"))
      verifyEquals("33", l12.toWidget().get("value"))
      verifyEquals("Abc", t21.toWidget().get("value"))
      verifyEquals("33", t22.toWidget().get("value"))
      verifyEquals("XXX", t31.toWidget().get("value"))
      verifyEquals("1", t32.toWidget().get("value"))
      verifyEquals("", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("ABC", t41.toWidget().get("value"))
      verifyEquals("10", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("", m43.toWidget().get("value"))
      verifyEquals("", m44.toWidget().get("value"))
      click(btn1.toWidget())
      waitResponse()
      verifyEquals("Abc", l11.toWidget().get("value"))
      verifyEquals("33", l12.toWidget().get("value"))
      verifyEquals("Abc", t21.toWidget().get("value"))
      verifyEquals("33", t22.toWidget().get("value"))
      verifyEquals("XXX", t31.toWidget().get("value"))
      verifyEquals("1", t32.toWidget().get("value"))
      verifyEquals("value must equals ignore case 'abc', but is XXX", m31.toWidget().get("value"))
      verifyEquals("value must not < 10 or > 100, but is 1", m32.toWidget().get("value"))
      verifyEquals("ABC", t41.toWidget().get("value"))
      verifyEquals("10", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("", m43.toWidget().get("value"))
      verifyEquals("", m44.toWidget().get("value"))
      `type`(t32.toWidget(), "55") // intbox has reset issue...too bad
      waitResponse()
      verifyEquals("Abc", l11.toWidget().get("value"))
      verifyEquals("33", l12.toWidget().get("value"))
      verifyEquals("Abc", t21.toWidget().get("value"))
      verifyEquals("33", t22.toWidget().get("value"))
      verifyEquals("XXX", t31.toWidget().get("value"))
      verifyEquals("55", t32.toWidget().get("value"))
      verifyEquals("value must equals ignore case 'abc', but is XXX", m31.toWidget().get("value"))
      verifyEquals("value must not < 10 or > 100, but is 1", m32.toWidget().get("value"))
      verifyEquals("ABC", t41.toWidget().get("value"))
      verifyEquals("10", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("", m43.toWidget().get("value"))
      verifyEquals("", m44.toWidget().get("value"))
      click(btn1.toWidget())
      waitResponse()
      verifyEquals("Abc", l11.toWidget().get("value"))
      verifyEquals("33", l12.toWidget().get("value"))
      verifyEquals("Abc", t21.toWidget().get("value"))
      verifyEquals("33", t22.toWidget().get("value"))
      verifyEquals("XXX", t31.toWidget().get("value"))
      verifyEquals("55", t32.toWidget().get("value"))
      verifyEquals("value must equals ignore case 'abc', but is XXX", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("ABC", t41.toWidget().get("value"))
      verifyEquals("10", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("", m43.toWidget().get("value"))
      verifyEquals("", m44.toWidget().get("value"))
      `type`(t31.toWidget(), "aBC") // intbox has reset issue...too bad
      waitResponse()
      verifyEquals("Abc", l11.toWidget().get("value"))
      verifyEquals("33", l12.toWidget().get("value"))
      verifyEquals("Abc", t21.toWidget().get("value"))
      verifyEquals("33", t22.toWidget().get("value"))
      verifyEquals("aBC", t31.toWidget().get("value"))
      verifyEquals("55", t32.toWidget().get("value"))
      verifyEquals("value must equals ignore case 'abc', but is XXX", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("ABC", t41.toWidget().get("value"))
      verifyEquals("10", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("", m43.toWidget().get("value"))
      verifyEquals("", m44.toWidget().get("value"))
      click(btn1.toWidget())
      waitResponse()
      verifyEquals("aBC", l11.toWidget().get("value"))
      verifyEquals("55", l12.toWidget().get("value"))
      verifyEquals("aBC", t21.toWidget().get("value"))
      verifyEquals("55", t22.toWidget().get("value"))
      verifyEquals("aBC", t31.toWidget().get("value"))
      verifyEquals("55", t32.toWidget().get("value"))
      verifyEquals("", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("ABC", t41.toWidget().get("value"))
      verifyEquals("10", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("", m43.toWidget().get("value"))
      verifyEquals("", m44.toWidget().get("value"))
      // ///////
      `type`(t41.toWidget(), "YYY")
      waitResponse()
      `type`(t42.toWidget(), "1999") // intbox has reset issue...too bad
      waitResponse()
      verifyEquals("aBC", l11.toWidget().get("value"))
      verifyEquals("55", l12.toWidget().get("value"))
      verifyEquals("aBC", t21.toWidget().get("value"))
      verifyEquals("55", t22.toWidget().get("value"))
      verifyEquals("aBC", t31.toWidget().get("value"))
      verifyEquals("55", t32.toWidget().get("value"))
      verifyEquals("", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("YYY", t41.toWidget().get("value"))
      verifyEquals("1999", t42.toWidget().get("value"))
      verifyEquals("value must equals ignore case 'abc', but is YYY", m41.toWidget().get("value"))
      verifyEquals("value must not < 10 or > 100, but is 1999", m42.toWidget().get("value"))
      verifyEquals("", m43.toWidget().get("value"))
      verifyEquals("", m44.toWidget().get("value"))
      click(btn2.toWidget())
      waitResponse()
      verifyEquals("aBC", l11.toWidget().get("value"))
      verifyEquals("55", l12.toWidget().get("value"))
      verifyEquals("aBC", t21.toWidget().get("value"))
      verifyEquals("55", t22.toWidget().get("value"))
      verifyEquals("aBC", t31.toWidget().get("value"))
      verifyEquals("55", t32.toWidget().get("value"))
      verifyEquals("", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("YYY", t41.toWidget().get("value"))
      verifyEquals("1999", t42.toWidget().get("value"))
      verifyEquals("value must equals ignore case 'abc', but is YYY", m41.toWidget().get("value"))
      verifyEquals("value must not < 10 or > 100, but is 1999", m42.toWidget().get("value"))
      verifyEquals("value must equals 'AbC', but is ABC", m43.toWidget().get("value"))
      verifyEquals("value must equals 'AbC', but is ABC", m44.toWidget().get("value"))
      verifyEquals("value must equals 'AbC', but is ABC", m45.toWidget().get("value"))
      verifyEquals("extra validation info ABC", m46.toWidget().get("value"))
      `type`(t41.toWidget(), "abc")
      waitResponse()
      `type`(t42.toWidget(), "77") // intbox has reset issue...too bad
      waitResponse()
      verifyEquals("aBC", l11.toWidget().get("value"))
      verifyEquals("55", l12.toWidget().get("value"))
      verifyEquals("aBC", t21.toWidget().get("value"))
      verifyEquals("55", t22.toWidget().get("value"))
      verifyEquals("aBC", t31.toWidget().get("value"))
      verifyEquals("55", t32.toWidget().get("value"))
      verifyEquals("", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("abc", t41.toWidget().get("value"))
      verifyEquals("77", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("value must equals 'AbC', but is ABC", m43.toWidget().get("value"))
      verifyEquals("value must equals 'AbC', but is ABC", m44.toWidget().get("value"))
      verifyEquals("value must equals 'AbC', but is ABC", m45.toWidget().get("value"))
      verifyEquals("extra validation info ABC", m46.toWidget().get("value"))
      click(btn2.toWidget())
      waitResponse()
      verifyEquals("aBC", l11.toWidget().get("value"))
      verifyEquals("55", l12.toWidget().get("value"))
      verifyEquals("aBC", t21.toWidget().get("value"))
      verifyEquals("55", t22.toWidget().get("value"))
      verifyEquals("aBC", t31.toWidget().get("value"))
      verifyEquals("55", t32.toWidget().get("value"))
      verifyEquals("", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("abc", t41.toWidget().get("value"))
      verifyEquals("77", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("value must equals 'AbC', but is abc", m43.toWidget().get("value"))
      verifyEquals("value must equals 'AbC', but is abc", m44.toWidget().get("value"))
      verifyEquals("value must equals 'AbC', but is abc", m45.toWidget().get("value"))
      verifyEquals("extra validation info abc", m46.toWidget().get("value"))
      `type`(t41.toWidget(), "AbC")
      waitResponse()
      click(btn2.toWidget())
      waitResponse()
      verifyEquals("AbC", l11.toWidget().get("value"))
      verifyEquals("77", l12.toWidget().get("value"))
      verifyEquals("AbC", t21.toWidget().get("value"))
      verifyEquals("77", t22.toWidget().get("value"))
      verifyEquals("AbC", t31.toWidget().get("value"))
      verifyEquals("77", t32.toWidget().get("value"))
      verifyEquals("", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("AbC", t41.toWidget().get("value"))
      verifyEquals("77", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("", m43.toWidget().get("value"))
      verifyEquals("", m44.toWidget().get("value"))
      `type`(t31.toWidget(), "YYY")
      waitResponse()
      `type`(t32.toWidget(), "2") // intbox has reset issue...too bad
      waitResponse()
      click(btn1.toWidget())
      waitResponse()
      verifyEquals("YYY", t31.toWidget().get("value"))
      verifyEquals("2", t32.toWidget().get("value"))
      verifyEquals("value must equals ignore case 'abc', but is YYY", m31.toWidget().get("value"))
      verifyEquals("value must not < 10 or > 100, but is 2", m32.toWidget().get("value"))
      click(btn3.toWidget())
      waitResponse()
      verifyEquals("AbC", t31.toWidget().get("value"))
      verifyEquals("2", t32.toWidget().get("value"))
      verifyEquals("", m31.toWidget().get("value"))
      verifyEquals("value must not < 10 or > 100, but is 2", m32.toWidget().get("value"))
    })
  }
}