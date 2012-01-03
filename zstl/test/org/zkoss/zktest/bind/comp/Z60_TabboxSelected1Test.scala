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
package org.zkoss.zktest.bind.comp

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.ZKSeleneseTestCase
import org.openqa.selenium.Keys
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_TabboxSelected1Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = { // tabbox-selected.zul
      <window apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.comp.TabboxSelectedVM')" border="none">
        Single way
        <vbox>
          <listbox id="listbox1" selectedItem="@bind(vm.selectedTab1)">
            <listitem id="item1a" label="Tab A" value="tabA"/>
            <listitem id="item1b" label="Tab B" value="tabB"/>
            <listitem id="item1c" label="Tab C" value="tabC"/>
          </listbox>
          ==================================
          <tabbox id="tabbox1">
            <tabs>
              <tab id="tab1a" label="A" selected="@bind(vm.selectedTab1 eq 'tabA' ? true:false)"/>
              <tab id="tab1b" label="B" selected="@bind(vm.selectedTab1 eq 'tabB' ? true:false)"/>
              <tab id="tab1c" label="C" selected="@bind(vm.selectedTab1 eq 'tabC' ? true:false)"/>
            </tabs>
            <tabpanels>
              <tabpanel>Panel A</tabpanel>
              <tabpanel>Panel B</tabpanel>
              <tabpanel>Panel C</tabpanel>
            </tabpanels>
          </tabbox>
        </vbox>
        Two way (have to bind to tab's label)
        <vbox>
          <listbox id="listbox2" selectedItem="@bind(vm.selectedTab2)">
            <listitem id="item2a" label="Tab A" value="tabA"/>
            <listitem id="item2b" label="Tab B" value="tabB"/>
            <listitem id="item2c" label="Tab C" value="tabC"/>
          </listbox>
          ==================================
          <tabbox id="tabbox2" selectedTab="@bind(vm.selectedTab2)">
            <tabs>
              <tab id="tab2a" label="tabA"/>
              <tab id="tab2b" label="tabB"/>
              <tab id="tab2c" label="tabC"/>
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
      verifyEquals("2", jq("$listbox1").toWidget().get("selectedIndex"))
      verifyEquals("2", jq("$tabbox1").toWidget().get("selectedIndex"))
      verifyFalse(jq("$tab1a").toWidget().is("selected"))
      verifyFalse(jq("$tab1b").toWidget().is("selected"))
      verifyTrue(jq("$tab1c").toWidget().is("selected"))
      click(jq("$item1a"))
      waitResponse()
      verifyEquals("0", jq("$listbox1").toWidget().get("selectedIndex"))
      verifyEquals("0", jq("$tabbox1").toWidget().get("selectedIndex"))
      verifyEquals(true, jq("$tab1a").toWidget().get("selected"))
      verifyFalse(jq("$tab1b").toWidget().is("selected"))
      verifyFalse(jq("$tab1c").toWidget().is("selected"))
      click(jq("$item1b"))
      waitResponse()
      verifyEquals("1", jq("$listbox1").toWidget().get("selectedIndex"))
      verifyEquals("1", jq("$tabbox1").toWidget().get("selectedIndex"))
      verifyFalse(jq("$tab1a").toWidget().is("selected"))
      verifyEquals(true, jq("$tab1b").toWidget().get("selected"))
      verifyFalse(jq("$tab1c").toWidget().is("selected"))
    })
  }
}


