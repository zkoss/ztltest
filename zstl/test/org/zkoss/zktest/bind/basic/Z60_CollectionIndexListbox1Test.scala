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
import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_CollectionIndexListbox1Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = { //collection-index-listbox.zul
      <window apply="org.zkoss.zktest.bind.basic.CollectionIndexListboxComposer">
        <custom-attributes composerName="vm"/>
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
          <button label="reload" onClick="@command('reload')"/>
          <button label="detach" onClick="listbox.detach()"/>
          <button label="Dump" onClick="binder.getTracker().dump()"/>
        </hbox>
      </window>
    }

    runZTL(zul, () => {
      val outerbox = jq("$outerbox").toWidget()
      var outeritem = outerbox.firstChild() // header should be skipped
      val itemLabel = Array("A", "B", "C", "D")
      verifyEquals(itemLabel.length, outerbox.nChildren() - 1) // skip header
      for (i <- 0 to itemLabel.length - 1) {
        outeritem = outeritem.nextSibling()
        val outerl = itemLabel(i)
        var cell = outeritem.firstChild()
        verifyEquals("" + i, cell.get("label")) // verify the index
        cell = cell.nextSibling()
        verifyEquals(outerl, cell.get("label")) // verify the label
        val innerbox = jq(outeritem).find("@listbox").toWidget()
        verifyTrue(innerbox.exists())
        val inneritems = jq(innerbox).find("@listitem")
        verifyEquals(2, inneritems.length())
        var inneritem = inneritems.first()
        for (j <- 0 to 1) {
          cell = inneritem.toWidget().firstChild()
          verifyEquals("" + j, cell.get("label"))
          cell = cell.nextSibling()
          verifyEquals("" + i, cell.get("label"))
          val innerl = itemLabel(i) + " " + j
          cell = cell.nextSibling()
          verifyEquals(innerl, cell.get("label"))
          inneritem = inneritem.next()
        }
        cell = outeritem.lastChild()
        val btn = jq(cell).find("@button").toWidget() // index button
        val msg = jq("$msg").toWidget()
        click(btn)
        waitResponse()
        verifyEquals("item index " + i, msg.get("value"))
      }
    })
  }
}