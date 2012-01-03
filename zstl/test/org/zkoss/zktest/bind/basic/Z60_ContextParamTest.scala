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
class Z60_ContextParamTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = { // contextparam.zul
      <vbox>
        <zscript>
          <![CDATA[
          applicationScope.put("applicationScopeVar","applicationScope-A");
		sessionScope.put("sessionScopeVar","sessionScope-A");
		desktopScope.put("desktopScopeVar","desktopScope-A");
		pageScope.put("pageScopeVar","pageScope-A");
		spaceScope.put("componentScopeVar","spaceScope-X");
		requestScope.put("requestScopeVar","requestScope-A");
    		]]>
        </zscript>
        <window id="w1">
          <custom-attributes componentScopeVar="spaceScope-A"/>
          <vbox id="vbox1" apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.basic.ContextParamVM')">
            <custom-attributes componentScopeVar="componentScope-B"/>
            <hbox><label id="l11" value="@load(vm.applicationScope)"/>= applicationScope-A ||var2 by Desktop |applicationScope-A</hbox>
            <hbox><label id="l12" value="@load(vm.sessionScope)"/>= sessionScope-A ||var1 by Desktop|sessionScope-A</hbox>
            <hbox><label id="l13" value="@load(vm.desktopScope)"/>= desktopScope-A |||</hbox>
            <hbox><label id="l14" value="@load(vm.spaceScope)"/>= spaceScope-A ||spaceScope-Y|</hbox>
            <hbox><label id="l15" value="@load(vm.requestScope)"/>= requestScope-A | empty ||</hbox>
            <hbox><label id="l16" value="@load(vm.componentScope)"/>= componentScope-B | componentScope-C ||</hbox>
            <hbox><label id="l17" value="@load(vm.bindComponentId)"/>= vbox1 | cmd1 | cmd2 | cmd3 ; bindComponentId</hbox>
            <hbox><label id="l18" value="@load(vm.bindViewId)"/>= vbox1 | vbox1 | vbox1 | vbox1 ; bindViewId</hbox>
            <hbox><label id="l19" value="@load(vm.bindContext)"/>= true | false ||; bindContext</hbox>
            <hbox><label id="l1a" value="@load(vm.bindBinder)"/>= true | false ||; binder</hbox>
            <button id="cmd1" label="cmd1" onClick="@command('cmd1')">
              <custom-attributes componentScopeVar="componentScope-C"/>
            </button>
            <button id="cmd2" label="cmd2" onClick="@command('cmd2')"/>
            <button id="cmd3" label="cmd3" onClick="@command('cmd3')"/>
            <button label="Dump" onClick="binder.getTracker().dump()"/>
          </vbox>
        </window>
      </vbox>
    }

    runZTL(zul, () => {
      verifyEquals("applicationScope-A", jq("$l11").toWidget().get("value"))
      verifyEquals("sessionScope-A", jq("$l12").toWidget().get("value"))
      verifyEquals("desktopScope-A", jq("$l13").toWidget().get("value"))
      verifyEquals("spaceScope-A", jq("$l14").toWidget().get("value"))
      verifyEquals("requestScope-A", jq("$l15").toWidget().get("value"))
      verifyEquals("componentScope-B", jq("$l16").toWidget().get("value"))
      verifyEquals("vbox1", jq("$l17").toWidget().get("value"))
      verifyEquals("vbox1", jq("$l18").toWidget().get("value"))
      verifyEquals("true", jq("$l19").toWidget().get("value"))
      verifyEquals("true", jq("$l1a").toWidget().get("value"))
      click(jq("$cmd1").toWidget())
      waitResponse()
      verifyEquals("applicationScope-A", jq("$l11").toWidget().get("value"))
      verifyEquals("sessionScope-A", jq("$l12").toWidget().get("value"))
      verifyEquals("desktopScope-A", jq("$l13").toWidget().get("value"))
      verifyEquals("spaceScope-A", jq("$l14").toWidget().get("value"))
      verifyEquals("", jq("$l15").toWidget().get("value"))
      verifyEquals("componentScope-C", jq("$l16").toWidget().get("value"))
      verifyEquals("cmd1", jq("$l17").toWidget().get("value"))
      verifyEquals("vbox1", jq("$l18").toWidget().get("value"))
      verifyEquals("false", jq("$l19").toWidget().get("value"))
      verifyEquals("false", jq("$l1a").toWidget().get("value"))
      click(jq("$cmd2").toWidget())
      waitResponse()
      verifyEquals("var2 by Desktop", jq("$l11").toWidget().get("value"))
      verifyEquals("var1 by Desktop", jq("$l12").toWidget().get("value"))
      verifyEquals("desktopScope-A", jq("$l13").toWidget().get("value"))
      verifyEquals("spaceScope-Y", jq("$l14").toWidget().get("value"))
      verifyEquals("", jq("$l15").toWidget().get("value"))
      verifyEquals("componentScope-C", jq("$l16").toWidget().get("value"))
      verifyEquals("cmd2", jq("$l17").toWidget().get("value"))
      verifyEquals("vbox1", jq("$l18").toWidget().get("value"))
      verifyEquals("false", jq("$l19").toWidget().get("value"))
      verifyEquals("false", jq("$l1a").toWidget().get("value"))
      click(jq("$cmd3").toWidget())
      waitResponse()
      verifyEquals("applicationScope-A", jq("$l11").toWidget().get("value"))
      verifyEquals("sessionScope-A", jq("$l12").toWidget().get("value"))
      verifyEquals("desktopScope-A", jq("$l13").toWidget().get("value"))
      verifyEquals("spaceScope-Y", jq("$l14").toWidget().get("value"))
      verifyEquals("", jq("$l15").toWidget().get("value"))
      verifyEquals("componentScope-C", jq("$l16").toWidget().get("value"))
      verifyEquals("cmd3", jq("$l17").toWidget().get("value"))
      verifyEquals("vbox1", jq("$l18").toWidget().get("value"))
      verifyEquals("false", jq("$l19").toWidget().get("value"))
      verifyEquals("false", jq("$l1a").toWidget().get("value"))
    })
  }
}