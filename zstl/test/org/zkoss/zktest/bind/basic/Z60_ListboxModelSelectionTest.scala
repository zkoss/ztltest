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
import org.zkoss.ztl.Widget
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.ZKSeleneseTestCase
import org.openqa.selenium.Keys
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_ListboxModelSelectionTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = { // listboxmodel.zul
      <window apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.basic.ListboxModelVM')">
        <label id="msg" value="@bind(vm.message1)"/>
        <listbox id="outerbox" width="700px" model="@bind(vm.items)" rows="5">
          <listhead>
            <listheader label="index"/>
            <listheader label="name"/>
            <listheader label="options" width="200px"/>
            <listheader label="action" width="300px"/>
          </listhead>
          <template name="model" var="item" status="s">
            <listitem>
              <listcell label="@bind(s.index)"/>
              <listcell label="@bind(item.name)"/>
              <listcell>
                <listbox hflex="1" model="@bind(item.options)">
                  <listhead>
                    <listheader label="index"/>
                    <listheader label="previous-index"/>
                    <listheader label="name"/>
                  </listhead>
                  <template name="model" var="option">
                    <listitem>
                      <listcell label="@bind(optionStatus.index)"/>
                      <listcell label="@bind(s.index)"/>
                      <listcell label="@bind(option)"/>
                    </listitem>
                  </template>
                </listbox>
              </listcell>
              <listcell>
                <button label="Index" onClick="@command('showIndex', index=s.index)"/>
                <button label="Delete" onClick="@command('delete', item=item)"/>
                <button label="Add After" onClick="@command('addAfter', item=item)"/>
                <button label="Add Before" onClick="@command('addBefore', item=item)"/>
              </listcell>
            </listitem>
          </template>
        </listbox>
        <hbox>
          <button id="btn1" label="reload" onClick="@command('reload')"/>
          <button label="Dump" onClick="binder.getTracker().dump()"/>
        </hbox>
      </window>
    }

    runZTL(zul, () => {
      var msg = jq("$msg").toWidget()
      var outerbox = jq("$outerbox").toWidget()
      var outeritems = outerbox.firstChild() // include header
      outeritems = outeritems.nextSibling() // don't care header
      var outeritem = outeritems.nextSibling() // select 2nd
      click(outeritem.firstChild()) // click on listitem is not work if it has listbox inside, (it will click on the inside listbox)
      waitResponse()
      // verifyEquals("1", outerbox.get("selectedIndex"))
      verifyEquals(1, getListboxSelectedIndex(outerbox))
      verifyEquals("", msg.get("value"))
      click(jq("$btn1").toWidget())
      waitResponse()
      // verifyEquals(1L, outerbox.getAttribute("selectedIndex")) // fail in max
      outeritems = outerbox.firstChild() // include header
      outeritems = outeritems.nextSibling() // don't care header
      outeritem = outeritems.nextSibling() // select 2nd
      // verifyEquals(outeritem.uuid(), outerbox.eval("getSelectedItem().uuid"))
      verifyEquals(outeritem.uuid(), getListboxSelectedItem(outerbox).uuid())
      verifyEquals("reloaded", msg.get("value"))
    })
  }

  def getListboxSelectedItem(listbox: Widget): Widget = {
    var listitems = listbox.firstChild(); // include header
    for (i <- 0 to listbox.nChildren() - 2) {
      listitems = listitems.nextSibling();
      if (listitems.is("selected"))
        return listitems;
    }
    return null;
  }

  def getListboxSelectedIndex(listbox: Widget): Int = {
    var listitems = listbox.firstChild(); // include header
    var selectedIndex = -1;
    for (i <- 0 to listbox.nChildren() - 2) {
      listitems = listitems.nextSibling();
      if (listitems.is("selected"))
        selectedIndex = i;
    }
    return selectedIndex;
  }
}