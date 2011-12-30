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
class Z60_listboxModelTest extends ZTL4ScalaTestCase {
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
      var outerbox = jq("$outerbox")
      // =================================delete 2rd row
      var outeritems = outerbox.toWidget().firstChild() // include header
      outeritems = outeritems.nextSibling() // don't care header
      var outeritem = outeritems.nextSibling()
      click(jq(outeritem).find("@button").eq(1).toWidget()) // click the delete button on 2nd row
      waitResponse()
      outerbox = jq("$outerbox")
      outeritems = outerbox.toWidget().firstChild() // include header
      outeritems = outeritems.nextSibling() // don't care header
      var itemLabel = Array("A", "C", "D");
      verifyEquals(itemLabel.length, outerbox.toWidget().nChildren() - 1)
      outeritem = outeritems
      for (i <- 0 to itemLabel.length - 1) {
        var outerl = itemLabel(i)
        var cell = outeritem.firstChild()
        verifyEquals("" + i, cell.get("label")) // verify the index
        cell = cell.nextSibling()
        verifyEquals(outerl, cell.get("label")) // verify the label
        var innerbox = jq(outeritem).find("@listbox")
        verifyTrue(innerbox.toWidget().exists())
        var inneritems = jq(innerbox).find("@listitem")
        verifyEquals(2, inneritems.length())
        for (j <- 0 to 1) {
          var inneritem = inneritems.eq(j).toWidget()
          cell = inneritem.firstChild()
          verifyEquals("" + j, cell.get("label"))
          cell = cell.nextSibling()
          verifyEquals("" + i, cell.get("label"))
          var innerl = itemLabel(i) + " " + j
          cell = cell.nextSibling()
          verifyEquals(innerl, cell.get("label"))
        }
        cell = outeritem.lastChild()
        var btn = jq(cell).find("@button") // index button
        click(btn.toWidget())
        waitResponse()
        var msg = jq("$msg")
        verifyEquals("item index " + i, msg.toWidget().get("value"))
        outeritem = outeritem.nextSibling()
      }
      // ===============================add after row
      outeritems = outerbox.toWidget().firstChild() // include header
      outeritems = outeritems.nextSibling() // don't care header
      outeritem = outeritems.nextSibling()
      click(jq(outeritem).find("@button").eq(2).toWidget()) // click the add after button on 2nd row
      waitResponse()
      outerbox = jq("$outerbox")
      outeritems = outerbox.toWidget().firstChild() // include header
      outeritems = outeritems.nextSibling() // don't care header
      itemLabel = Array("A", "C", "C1", "D")
      verifyEquals(itemLabel.length, outerbox.toWidget().nChildren() - 1)
      outeritem = outeritems
      for (i <- 0 to itemLabel.length - 1) {
        var outerl = itemLabel(i)
        var cell = outeritem.firstChild()
        verifyEquals("" + i, cell.get("label")) // verify the index
        cell = cell.nextSibling()
        verifyEquals(outerl, cell.get("label")) // verify the label
        var innerbox = jq(outeritem).find("@listbox")
        verifyTrue(innerbox.toWidget().exists())
        var inneritems = jq(innerbox).find("@listitem")
        verifyEquals(2, inneritems.length())

        for (j <- 0 to 1) {
          var inneritem = inneritems.eq(j).toWidget()
          cell = inneritem.firstChild()
          verifyEquals("" + j, cell.get("label"))
          cell = cell.nextSibling()
          verifyEquals("" + i, cell.get("label"))
          var innerl = itemLabel(i) + " " + j
          cell = cell.nextSibling()
          verifyEquals(innerl, cell.get("label"))
        }
        cell = outeritem.lastChild()
        var btn = jq(cell).find("@button") // index button
        click(btn.toWidget())
        waitResponse()
        var msg = jq("$msg")
        verifyEquals("item index " + i, msg.toWidget().get("value"))
        outeritem = outeritem.nextSibling()
      }
      // ===============================add add before row
      outeritems = outerbox.toWidget().firstChild() // include header
      outeritems = outeritems.nextSibling() // don't care header
      outeritem = outeritems.nextSibling().nextSibling()
      click(jq(outeritem).find("@button").eq(3).toWidget()) // click the add before button on 2nd row
      waitResponse()
      outerbox = jq("$outerbox")
      outeritems = outerbox.toWidget().firstChild() // include header
      outeritems = outeritems.nextSibling() // don't care header
      itemLabel = Array("A", "C", "C12", "C1", "D")
      verifyEquals(itemLabel.length, outerbox.toWidget().nChildren() - 1)
      outeritem = outeritems
      for (i <- 0 to itemLabel.length - 1) {
        var outerl = itemLabel(i)
        var cell = outeritem.firstChild()
        verifyEquals("" + i, cell.get("label")) // verify the index
        cell = cell.nextSibling()
        verifyEquals(outerl, cell.get("label")) // verify the label
        var innerbox = jq(outeritem).find("@listbox")
        verifyTrue(innerbox.toWidget().exists())
        var inneritems = jq(innerbox).find("@listitem")
        verifyEquals(2, inneritems.length())
        for (j <- 0 to 1) {
          var inneritem = inneritems.eq(j).toWidget()
          cell = inneritem.firstChild()
          verifyEquals("" + j, cell.get("label"))
          cell = cell.nextSibling()
          verifyEquals("" + i, cell.get("label"))
          var innerl = itemLabel(i) + " " + j
          cell = cell.nextSibling()
          verifyEquals(innerl, cell.get("label"))
        }
        cell = outeritem.lastChild()
        var btn = jq(cell).find("@button") // index button
        click(btn.toWidget())
        waitResponse()
        var msg = jq("$msg")
        verifyEquals("item index " + i, msg.toWidget().get("value"))
        outeritem = outeritem.nextSibling()
      }
    })
  }
}