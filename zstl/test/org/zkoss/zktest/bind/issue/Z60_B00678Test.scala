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
class Z60_B00678Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = { // B00678.zul
	<window apply="org.zkoss.bind.BindComposer"
		viewModel="@id('vm') @init('org.zkoss.zktest.bind.issue.B00678')">
		Click cmd1, the value should become B, click cmd2, the value should become C
		<hbox>
		
		<label id="l1" value="@bind(vm.map.value)"/>
		<label id="l2" value="@bind(vm.msg)"/>
		<button id="btn1" label="cmd1" onClick="@command('cmd1')" />
		<button id="btn2" label="cmd2" onClick="@command('cmd2')" />
		</hbox>
	</window>
    }

    runZTL(zul, () => {
      verifyEquals("Value A", jq("$l1").toWidget().get("value"))
      verifyEquals("msg A", jq("$l2").toWidget().get("value"))
      click(jq("$btn1").toWidget())
      waitResponse()
      verifyEquals("Value B", jq("$l1").toWidget().get("value"))
      verifyEquals("msg B", jq("$l2").toWidget().get("value"))
      click(jq("$btn2").toWidget())
      waitResponse()
      verifyEquals("Value C", jq("$l1").toWidget().get("value"))
      verifyEquals("msg C", jq("$l2").toWidget().get("value"))
    })
  }
}