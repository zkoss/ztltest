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
class Z60_SelectboxModelSelectionTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = { // selectboxmodelselection.zul
      <window apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.basic.SelectboxModelSelectionVM')">
        <vbox>
          <label id="msg" value="@bind(vm.message1)"/>
          <selectbox id="sb1" model="@bind(vm.items)" width="100px">
            <template name="model" var="item">
              <label value="@bind(vm.cat('Item',item.name))"/>
            </template>
          </selectbox>
          <selectbox id="sb2" model="@bind(vm.items)" width="100px">
            <template name="model" var="item">
              <label value="@bind(item.name)"/>
            </template>
          </selectbox>
          <selectbox id="sb3" model="@bind(vm.items)" width="100px" selectedIndex="@bind(vm.selected)">
            <template name="model" var="item">
              <label value="@bind(item.name)"/>
            </template>
          </selectbox>
        </vbox>
        <hbox>
          <button id="btn1" label="reload" onClick="@command('reload')"/>
          <button id="btn2" label="select" onClick="@command('select')"/>
          <button label="Dump" onClick="binder.getTracker().dump()"/>
        </hbox>
      </window>
    }

    runZTL(zul, () => {
      var sb1 = engine.$f("sb1")
      var sb2 = engine.$f("sb2")
      var sb3 = engine.$f("sb3")
      var msg = engine.$f("msg")
      var btn1 = engine.$f("btn1")
      var btn2 = engine.$f("btn2")
      verifyEquals("", msg.get("value"))
      verifyEquals("-1", sb1.get("selectedIndex"))
      verifyEquals("-1", sb2.get("selectedIndex"))
      verifyEquals("1", sb3.get("selectedIndex"))
      click(jq(sb1).find("option").eq(0).toElement())
      waitResponse()
      click(jq(sb2).find("option").eq(1).toElement())
      waitResponse()
      click(jq(sb3).find("option").eq(2).toElement())
      waitResponse()
      verifyEquals("0", sb1.get("selectedIndex"))
      verifyEquals("1", sb2.get("selectedIndex"))
      verifyEquals("2", sb3.get("selectedIndex"))
      click(btn1)
      waitResponse()
      verifyEquals("0", sb1.get("selectedIndex"))
      verifyEquals("1", sb2.get("selectedIndex"))
      verifyEquals("2", sb3.get("selectedIndex"))
      click(btn2)
      waitResponse()
      verifyEquals("0", sb1.get("selectedIndex"))
      verifyEquals("1", sb2.get("selectedIndex"))
      verifyEquals("3", sb3.get("selectedIndex"))
    })
  }
}
