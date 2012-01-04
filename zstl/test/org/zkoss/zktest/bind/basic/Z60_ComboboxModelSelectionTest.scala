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
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_ComboboxModelSelectionTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = { //comboboxmodelselection.zul
      <window apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.basic.ComboboxModelSelectionVM')">
        <vbox>
          <label id="msg" value="@bind(vm.message1)"/>
          <combobox id="cb1" model="@bind(vm.items)" width="100px">
            <template name="model" var="item">
              <comboitem label="@bind(item.name)"/>
            </template>
          </combobox>
          <combobox id="cb2" model="@bind(vm.items)" width="100px" selectedItem="@bind(vm.selected)">
            <template name="model" var="item">
              <comboitem label="@bind(item.name)"/>
            </template>
          </combobox>
        </vbox>
        <hbox>
          <button id="btn1" label="reload" onClick="@command('reload')"/>
          <button id="btn2" label="select" onClick="@command('select')"/>
          <button label="Dump" onClick="binder.getTracker().dump()"/>
        </hbox>
      </window>
    }

    runZTL(zul, () => {
      var combobox1 = jq("$cb1")
      var combobox2 = jq("$cb2")
      verifyEquals("", jq("$msg").toWidget().get("value"))
      combobox1.toWidget().eval("open()") // has to wait for open
      waitResponse()
      var items = combobox1.find("@comboitem")
      combobox1.toWidget().eval("open()") // has to wait for open
      waitResponse()
      click(items.eq(1).toWidget())
      waitResponse()
      verifyEquals("B", combobox1.toWidget().get("value"))
      verifyEquals("A", combobox2.toWidget().get("value"))
      combobox1.toWidget().eval("open()") // has to wait for open
      waitResponse()
      click(items.eq(2).toWidget())
      waitResponse()
      verifyEquals("C", combobox1.toWidget().get("value"))
      verifyEquals("A", combobox2.toWidget().get("value"))
      click(jq("$btn1").toWidget())
      waitResponse()
      verifyEquals("reloaded", jq("$msg").toWidget().get("value"))
      verifyEquals("C", combobox1.toWidget().get("value"))
      verifyEquals("A", combobox2.toWidget().get("value"))
      click(jq("$btn2").toWidget())
      waitResponse()
      verifyEquals("selected", jq("$msg").toWidget().get("value"))
      verifyEquals("C", combobox1.toWidget().get("value"))
      verifyEquals("D", combobox2.toWidget().get("value"))
    })
  }
}