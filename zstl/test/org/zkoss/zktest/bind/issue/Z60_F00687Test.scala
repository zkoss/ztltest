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
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_F00687Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = { // F00687.zul
      <window apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.issue.F00687')">
        <vbox>
          <hlayout>
            <label id="l11" value="@load(vm.value1)"/>
            <label id="l12" value="@load(vm.value2)"/>
            <label id="l13" value="@load(vm.value3)"/>
            <label id="l14" value="@load(vm.value4)"/>
          </hlayout>
          <hlayout>
            <textbox id="t11" value="@bind(vm.value1)"/>
            <textbox id="t12" value="@bind(vm.value2)"/>
            <textbox id="t13" value="@bind(vm.value3)"/>
            <textbox id="t14" value="@bind(vm.value4)"/>
          </hlayout>
          <button label="cmd1" id="btn1" onClick="@command('cmd1',val='command 1')"/>
        </vbox>
        <button label="Dump" onClick="binder.getTracker().dump()"/>
      </window>
    }
    runZTL(zul, () => {
      var l11 = jq("$l11").toWidget()
      var l12 = jq("$l12").toWidget()
      var l13 = jq("$l13").toWidget()
      var l14 = jq("$l14").toWidget()
      var t11 = jq("$t11").toWidget()
      var t12 = jq("$t12").toWidget()
      var t13 = jq("$t13").toWidget()
      var t14 = jq("$t14").toWidget()
      verifyEquals("A", l11.get("value"))
      verifyEquals("B", l12.get("value"))
      verifyEquals("C", l13.get("value"))
      verifyEquals("D", l14.get("value"))
      `type`(t11, "Q")
      waitResponse()
      verifyEquals("Q", l11.get("value"))
      verifyEquals("B", l12.get("value"))
      verifyEquals("C", l13.get("value"))
      verifyEquals("D", l14.get("value"))
      `type`(t12, "W")
      waitResponse()
      verifyEquals("Q", l11.get("value"))
      verifyEquals("B", l12.get("value"))
      verifyEquals("C", l13.get("value"))
      verifyEquals("D", l14.get("value"))
      `type`(t13, "E")
      waitResponse()
      verifyEquals("Q", l11.get("value"))
      verifyEquals("W", l12.get("value"))
      verifyEquals("E", l13.get("value"))
      verifyEquals("D", l14.get("value"))
      click(jq("$btn1").toWidget())
      waitResponse()
      verifyEquals("Q", l11.get("value"))
      verifyEquals("W", l12.get("value"))
      verifyEquals("E", l13.get("value"))
      verifyEquals("command 1", l14.get("value"))
      verifyEquals("command 1", t14.get("value"))
    })
  }
}
