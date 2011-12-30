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
class Z60_FormDirtyTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = { // form-dirty.zul
      <window apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.basic.FormDirty')">
        <vbox form="@id('fx') @load(vm.person) @save(vm.person, before='save')">
          <label id="dirty" value="@load(fxStatus.dirty)"/>
          <grid width="500px">
            <rows>
              <row>
                <textbox id="t1" value="@bind(fx.name)"/>
                <label id="l1" value="@bind(fx.name)"/>
              </row>
            </rows>
          </grid>
        </vbox>
        <hbox>
          <button id="btn1" label="save form" onClick="@command('save')"/>
          <button id="btn2" label="show" onClick="@command('show')"/>
        </hbox>
        <label id="msg" value="@bind(vm.msg)"/>
        <button label="Dump" onClick="binder.getTracker().dump()"/>
      </window>
    }
    runZTL(zul, () => {
      verifyEquals("false", jq("$dirty").toWidget().get("value"))
      verifyEquals("Dennis", jq("$l1").toWidget().get("value"))
      `type`(jq("$t1").toWidget(), "X")
      waitResponse()
      verifyEquals("true", jq("$dirty").toWidget().get("value"))
      verifyEquals("Dennis", jq("$l1").toWidget().get("value"))
      `type`(jq("$t1").toWidget(), "Dennis")
      waitResponse()
      verifyEquals("false", jq("$dirty").toWidget().get("value"))
      verifyEquals("Dennis", jq("$l1").toWidget().get("value"))
      `type`(jq("$t1").toWidget(), "Y")
      waitResponse()
      verifyEquals("true", jq("$dirty").toWidget().get("value"))
      verifyEquals("Dennis", jq("$l1").toWidget().get("value"))
      click(jq("$btn2").toWidget())
      waitResponse()
      verifyEquals("old-name Dennis", jq("$msg").toWidget().get("value"))
      click(jq("$btn1").toWidget())
      waitResponse()
      verifyEquals("saved Y", jq("$msg").toWidget().get("value"))
      click(jq("$btn2").toWidget())
      waitResponse()
      verifyEquals("old-name Y", jq("$msg").toWidget().get("value"))
      verifyEquals("false", jq("$dirty").toWidget().get("value"))
      verifyEquals("Y", jq("$l1").toWidget().get("value"))
    })
  }
}