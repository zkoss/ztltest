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
class Z60_ScopeParamTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = { // scopeparam.zul
      <vbox>
        <zscript>
          <![CDATA[
          applicationScope.put("applicationScopeVar","applicationScope-A");
		sessionScope.put("sessionScopeVar","sessionScope-A");
		desktopScope.put("desktopScopeVar","desktopScope-A");
		pageScope.put("pageScopeVar","pageScope-A");
		spaceScope.put("spaceScopeVar","spaceScopeScope-A");
		requestScope.put("requestScopeVar","requestScope-A");
    		]]>
        </zscript>
        <window>
          <custom-attributes componentScopeVar="A" componentScopeVar1="C" componentScopeVar2="D"/>
          <vbox apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.basic.ScopeParamVM')">
            <custom-attributes componentScopeVar="B" componentScopeVar2="E"/>
            <hbox><label id="l11" value="@load(vm.applicationScope)"/>= applicationScope-A | var2 by Desktop, after click twice on cmd2</hbox>
            <hbox><label id="l12" value="@load(vm.sessionScope)"/>= sessionScope-A | var1 by Desktop, after click twice on cmd2</hbox>
            <hbox><label id="l13" value="@load(vm.desktopScope)"/>= desktopScope-A</hbox>
            <hbox><label id="l14" value="@load(vm.spaceScope)"/>= spaceScope-A</hbox>
            <hbox><label id="l15" value="@load(vm.requestScope)"/>= requestScope-A</hbox>
            <hbox><label id="l16" value="@load(vm.componentScope)"/>= B | F after click</hbox>
            <hbox><label id="l17" value="@load(vm.componentScope1)"/>= C</hbox>
            <hbox><label id="l18" value="@load(vm.componentScope2)"/>= E | D after click</hbox>
            <hbox><label id="l19" value="@load(vm.componentScope3)"/>= empty | G after click</hbox>
            <button id="cmd1" label="cmd1" onClick="@command('cmd1')">
              <custom-attributes componentScopeVar="F" componentScopeVar3="G"/>
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
      verifyEquals("spaceScopeScope-A", jq("$l14").toWidget().get("value"))
      verifyEquals("requestScope-A", jq("$l15").toWidget().get("value"))
      verifyEquals("B", jq("$l16").toWidget().get("value"))
      verifyEquals("C", jq("$l17").toWidget().get("value"))
      verifyEquals("E", jq("$l18").toWidget().get("value"))
      verifyEquals("", jq("$l19").toWidget().get("value"))
      click(jq("$cmd1").toWidget())
      waitResponse()
      verifyEquals("applicationScope-A", jq("$l11").toWidget().get("value"))
      verifyEquals("sessionScope-A", jq("$l12").toWidget().get("value"))
      verifyEquals("desktopScope-A", jq("$l13").toWidget().get("value"))
      verifyEquals("spaceScopeScope-A", jq("$l14").toWidget().get("value"))
      verifyEquals("", jq("$l15").toWidget().get("value"))
      verifyEquals("F", jq("$l16").toWidget().get("value"))
      verifyEquals("C", jq("$l17").toWidget().get("value"))
      verifyEquals("E", jq("$l18").toWidget().get("value"))
      verifyEquals("G", jq("$l19").toWidget().get("value"))
      click(jq("$cmd2").toWidget())
      waitResponse()
      verifyEquals("var2 by Desktop", jq("$l11").toWidget().get("value"))
      verifyEquals("var1 by Desktop", jq("$l12").toWidget().get("value"))
      verifyEquals("desktopScope-A", jq("$l13").toWidget().get("value"))
      verifyEquals("spaceScopeScope-A", jq("$l14").toWidget().get("value"))
      verifyEquals("", jq("$l15").toWidget().get("value"))
      verifyEquals("F", jq("$l16").toWidget().get("value"))
      verifyEquals("C", jq("$l17").toWidget().get("value"))
      verifyEquals("E", jq("$l18").toWidget().get("value"))
      verifyEquals("G", jq("$l19").toWidget().get("value"))
      click(jq("$cmd3").toWidget())
      waitResponse()
      verifyEquals("applicationScope-A", jq("$l11").toWidget().get("value"))
      verifyEquals("sessionScope-A", jq("$l12").toWidget().get("value"))
      verifyEquals("desktopScope-A", jq("$l13").toWidget().get("value"))
      verifyEquals("spaceScopeScope-A", jq("$l14").toWidget().get("value"))
      verifyEquals("", jq("$l15").toWidget().get("value"))
      verifyEquals("F", jq("$l16").toWidget().get("value"))
      verifyEquals("C", jq("$l17").toWidget().get("value"))
      verifyEquals("E", jq("$l18").toWidget().get("value"))
      verifyEquals("G", jq("$l19").toWidget().get("value"))
      click(jq("$cmd2").toWidget())
      waitResponse()
      verifyEquals("var2 by Desktop", jq("$l11").toWidget().get("value"))
      verifyEquals("var1 by Desktop", jq("$l12").toWidget().get("value"))
      verifyEquals("desktopScope-A", jq("$l13").toWidget().get("value"))
      verifyEquals("spaceScopeScope-A", jq("$l14").toWidget().get("value"))
      verifyEquals("", jq("$l15").toWidget().get("value"))
      verifyEquals("F", jq("$l16").toWidget().get("value"))
      verifyEquals("C", jq("$l17").toWidget().get("value"))
      verifyEquals("E", jq("$l18").toWidget().get("value"))
      verifyEquals("G", jq("$l19").toWidget().get("value"))
    })
  }
}