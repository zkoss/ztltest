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
class Z60_B00722Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = { // B00722.zul

      <zk>
        <label multiline="true">
          1.type abcd and tab, you will see a validation message
2.click the save, the validation message is still here
3.click the reload, the value of textbox should become abc and the validation message should disappear
        </label>
        <vbox apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.issue.B00722')" width="400px" validationMessages="@id('vmsgs')">
          <label>
          </label>
          <label id="l11" value="@bind(vm.value1)"/>
          <vbox form="@id('fx') @load(vm) @save(vm,before='save')">
            <textbox id="t21" value="@bind(fx.value1) @validator(vm.validator)"/>
            <label id="m21" value="@load(vmsgs[t21])"/>
          </vbox>
          <button id="cmd1" label="save" onClick="@command('save')"/>
          <button id="cmd2" label="reload" onClick="@command('reload')"/>
        </vbox>
      </zk>
    }

    runZTL(zul, () => {
      var l11 = jq("$l11")
      var t21 = jq("$t21")
      var m21 = jq("$m21")
      var cmd1 = jq("$cmd1")
      var cmd2 = jq("$cmd2")
      verifyEquals("abc", l11.toWidget().get("value"))
      verifyEquals("abc", t21.toWidget().get("value"))
      verifyEquals("", m21.toWidget().get("value"))
      `type`(t21.toWidget(), "efg")
      waitResponse()
      verifyEquals("abc", l11.toWidget().get("value"))
      verifyEquals("efg", t21.toWidget().get("value"))
      verifyEquals("the value has to be 'abc' or 'ABC'", m21.toWidget().get("value"))
      click(cmd1.toWidget())
      waitResponse()
      verifyEquals("abc", l11.toWidget().get("value"))
      verifyEquals("efg", t21.toWidget().get("value"))
      verifyEquals("the value has to be 'abc' or 'ABC'", m21.toWidget().get("value"))
      `type`(t21.toWidget(), "ABC")
      waitResponse()
      verifyEquals("abc", l11.toWidget().get("value"))
      verifyEquals("ABC", t21.toWidget().get("value"))
      verifyEquals("", m21.toWidget().get("value"))
      click(cmd1.toWidget())
      waitResponse()
      verifyEquals("ABC:saved", l11.toWidget().get("value"))
      verifyEquals("ABC", t21.toWidget().get("value"))
      verifyEquals("", m21.toWidget().get("value"))
      `type`(t21.toWidget(), "kkk")
      waitResponse()
      verifyEquals("ABC:saved", l11.toWidget().get("value"))
      verifyEquals("kkk", t21.toWidget().get("value"))
      verifyEquals("the value has to be 'abc' or 'ABC'", m21.toWidget().get("value"))
      click(cmd2.toWidget())
      waitResponse()
      verifyEquals("ABC:saved", l11.toWidget().get("value"))
      verifyEquals("ABC:saved", t21.toWidget().get("value"))
      verifyEquals("", m21.toWidget().get("value"))
    })
  }
}