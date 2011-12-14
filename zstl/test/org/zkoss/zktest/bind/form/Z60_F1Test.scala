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
import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.ZKSeleneseTestCase

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_F1 extends ZTL4ScalaTestCase {
  def testArg = {

    def zul = {
      <vbox apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.viewmodel.form.F1')" width="400px">
        <label multiline="true">
          f1.
    form, command+argument, validator+argument,notifychange
    1. click register, message doesn't change.
    2. input account "john", password "1", retype password "2"
    3. register, message no change.
    4. input "1" at "Retype password", register, message show account.
    5. input birthday 1978/1/1, register, message show "..are adult."
        </label>
        <grid form="@id('fx') @load(vm.user) @save(vm.user,before='register') @validator(vm.f1Validator)">
          <rows>
            <row>
              <label value="Account"/>
              <textbox id="accountBox" value="@bind(fx.account)"/>
            </row>
            <row>
              <label value="Password"/>
              <textbox id="passwordBox" type="password" value="@bind(fx.password) "/>
            </row>
            <row>
              <label value="Retype Password "/>
              <textbox id="passwordBox2" type="password" value="@bind(fx.password2) "/>
            </row>
            <row>
              Birthday
              <datebox id="birthdayBox" format="yyyy/MM/dd" value="@save(fx.adult) @converter(vm.birthdayAdultConverter)"/>
            </row>
            <row>
            </row>
            <row>
              <label value=""/>
              <button id="registerButton" label="Register" onClick="@command('register')"/>
            </row>
          </rows>
        </grid>
        <label id="message" value="@bind(vm.message)"/>
      </vbox>
    }

    runZTL(zul, () => {

      val registerButton = engine $f "registerButton"
      val message = engine $f "message"
      val accountBox = engine $f "accountBox"
      val passwordBox = engine $f "passwordBox"
      val passwordBox2 = engine $f "passwordBox2"
      val birthdayBox = engine $f "birthdayBox"

      click(registerButton);
      ZKSeleneseTestCase.assertEquals("NOT an adult.", jq(message).text());

      `type`(accountBox, "john");
      `type`(passwordBox, "1");
      `type`(passwordBox2, "2");
      click(registerButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("NOT an adult.", jq(message).text());

      `type`(passwordBox2, "1");
      click(registerButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("Hi, john: You are NOT an adult.", jq(message).text());

      `type`(birthdayBox.$n("real"), "1978/01/01");
      ZKSeleneseTestCase.assertEquals("1978/01/01", jq(birthdayBox.$n("real")).`val`());
      click(registerButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("Hi, john: You are an adult.", jq(message).text());
    })
  }
}