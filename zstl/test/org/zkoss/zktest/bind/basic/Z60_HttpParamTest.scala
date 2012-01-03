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
class Z60_HttpParamTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = { // httpparam.zul
      <vbox>
        <vbox apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.basic.HttpParamVM')">
          <hbox><label id="l11" value="@load(vm.queryParam)"/> = your url parameter['param1']</hbox>
          <hbox><label id="l12" value="@load(vm.headerParam)"/> = your browser user-agent</hbox>
          <hbox><label id="l13" value="@load(vm.cookieParam)"/> = the jsession id value after you click the cmd1</hbox>
          <button id="cmd1" label="cmd1" onClick="@command('cmd1')"/>
          <button label="Dump" onClick="binder.getTracker().dump()"/>
        </vbox>
      </vbox>
    }

    runZTL(zul, () => {
      click(jq("$cmd1").toWidget())
      waitResponse()
      // verifyTrue(jq("$l11").toWidget().get("value") != null) // not available in ztltest
      verifyTrue(jq("$l12").toWidget().get("value") != null)
      verifyTrue(jq("$l13").toWidget().get("value") != null)
      // verifyFalse("".equals(jq("$l11").toWidget().get("value").trim())) // not available in ztltest
      verifyFalse("".equals(jq("$l12").toWidget().get("value").trim()))
      verifyFalse("".equals(jq("$l13").toWidget().get("value").trim()))
    })
  }
}