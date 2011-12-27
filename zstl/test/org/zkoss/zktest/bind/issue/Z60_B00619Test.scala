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
class Z60_B00619Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = { // B00619.zul
      <window apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.issue.B00619')" border="none">
        1.select listbox, the label and tab selection should change
		2.select tab, the the label and listbox selection should change
        <vbox>
          <label id="msg" value="@bind(vm.selectedTab)"/>
          <listbox id="listbox" selectedItem="@bind(vm.selectedTab)">
            <listitem id="itema" label="Tab A" value="tabA"/>
            <listitem id="itemb" label="Tab B" value="tabB"/>
            <listitem id="itemc" label="Tab C" value="tabC"/>
          </listbox>
          ==================================
          <tabbox id="tabbox" selectedTab="@bind(vm.selectedTab)">
            <tabs>
              <tab id="taba" label="tabA"/>
              <tab id="tabb" label="tabB"/>
              <tab id="tabc" label="tabC"/>
            </tabs>
            <tabpanels>
              <tabpanel>Panel A</tabpanel>
              <tabpanel>Panel B</tabpanel>
              <tabpanel>Panel C</tabpanel>
            </tabpanels>
          </tabbox>
        </vbox>
        <button label="Dump" onClick="binder.getTracker().dump()"/>
      </window>
    }

    runZTL(zul, () => {
      verifyEquals("1", jq("$listbox").toWidget().get("selectedIndex"))
      verifyEquals("1", jq("$tabbox").toWidget().get("selectedIndex"))
      verifyFalse(jq("$taba").toWidget().is("selected"))
      verifyTrue(jq("$tabb").toWidget().is("selected"))
      verifyFalse(jq("$tabc").toWidget().is("selected"))
      click(jq("$itema").toWidget())
      waitResponse()
      verifyEquals("0", jq("$listbox").toWidget().get("selectedIndex"))
      verifyEquals("0", jq("$tabbox").toWidget().get("selectedIndex"))
      verifyTrue(jq("$taba").toWidget().is("selected"))
      verifyFalse(jq("$tabb").toWidget().is("selected"))
      verifyFalse(jq("$tabc").toWidget().is("selected"))
      click(jq("$tabc").toWidget())
      waitResponse()
      verifyEquals("2", jq("$listbox").toWidget().get("selectedIndex"))
      verifyEquals("2", jq("$tabbox").toWidget().get("selectedIndex"))
      verifyFalse(jq("$taba").toWidget().is("selected"))
      verifyFalse(jq("$tabb").toWidget().is("selected"))
      verifyTrue(jq("$tabc").toWidget().is("selected"))
    })
  }
}