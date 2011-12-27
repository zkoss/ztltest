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
import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_TabboxSelected2Test extends ZTL4ScalaTestCase {
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
      verifyEquals("1", jq("$listbox2").toWidget().get("selectedIndex"))
      verifyEquals("1", jq("$tabbox2").toWidget().get("selectedIndex"))
      verifyFalse(jq("$tab2a").toWidget().is("selected"))
      verifyTrue(jq("$tab2b").toWidget().is("selected"))
      verifyFalse(jq("$tab2c").toWidget().is("selected"))
      click(jq("$item2a"))
      waitResponse()
      verifyEquals("0", jq("$listbox2").toWidget().get("selectedIndex"))
      verifyEquals("0", jq("$tabbox2").toWidget().get("selectedIndex"))
      verifyTrue(jq("$tab2a").toWidget().is("selected"))
      verifyFalse(jq("$tab2b").toWidget().is("selected"))
      verifyFalse(jq("$tab2c").toWidget().is("selected"))
      click(jq("$tab2c"))
      waitResponse()
      verifyEquals("2", jq("$listbox2").toWidget().get("selectedIndex"))
      verifyEquals("2", jq("$tabbox2").toWidget().get("selectedIndex"))
      verifyFalse(jq("$tab2a").toWidget().is("selected"))
      verifyFalse(jq("$tab2b").toWidget().is("selected"))
      verifyTrue(jq("$tab2c").toWidget().is("selected"))
    })
  }
}
