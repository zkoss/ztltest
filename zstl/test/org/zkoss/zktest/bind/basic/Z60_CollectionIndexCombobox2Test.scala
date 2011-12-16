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
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_CollectionIndexCombobox2 extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = { //collection-index-combobox.zul
      <window apply="org.zkoss.zktest.bind.basic.CollectionIndexComboboxComposer">
        <custom-attributes composerName="vm"/>
        <label id="msg" value="@bind(vm.message1)"/>
        <grid id="outergrid" width="700px" model="@bind(vm.items)">
          <columns>
            <column label="index"/>
            <column label="name"/>
            <column label="options" width="200px"/>
            <column label="action" width="300px"/>
          </columns>
          <template name="model" var="item" status="s">
            <row>
              <label value="@bind(s.index)"/>
              <label value="@bind(item.name)"/>
              <combobox hflex="1" model="@bind(item.options)">
                <template name="model" var="option">
                  <comboitem label="@bind(optionStatus) @converter(vm.statusConverter,name=option,si=s.index,ssi=optionStatus.index)" description="@bind(option)"/>
                </template>
              </combobox>
              <hbox>
                <button label="Index" onClick="@command('showIndex', index=s.index)"/>
                <button label="Delete" onClick="@command('delete', item=item)"/>
                <button label="Add After" onClick="@command('addAfter', item=item)"/>
                <button label="Add Before" onClick="@command('addBefore', item=item)"/>
              </hbox>
            </row>
          </template>
        </grid>
        <hbox>
          <button label="reload" onClick="@command('reload')"/>
          <button label="detach" onClick="grid.detach()"/>
          <button label="Dump" onClick="binder.getTracker().dump()"/>
        </hbox>
      </window>
    }

    runZTL(zul, () => {
      var outerbox = jq("$outergrid")
      var outerrows = outerbox.find("@rows").children()
      // =================================delete 2rd row
      var outeritem = outerrows.eq(1)
      click(outeritem.find("@button").get(1)) // click the delete button on 2nd row
      waitResponse()
      outerbox = jq("$outergrid")
      outerrows = outerbox.find("@rows").children()
      var itemLabel = Array("A", "C", "D")
      verifyEquals(itemLabel.length, outerrows.length())

      for (i <- 0 to itemLabel.length - 1) {
        var outerrow = outerrows.eq(i)
        var combobox = outerrow.find("@combobox")
        var comboitems = combobox.find("@comboitem")
        verifyEquals(2, comboitems.length())

        for (j <- 0 to 1) {
          var comboitem = comboitems.eq(j)
          verifyEquals(itemLabel(i) + " " + j + "-" + j + "-" + i, comboitem.toWidget().get("label"))
          verifyEquals(itemLabel(i) + " " + j, comboitem.toWidget().get("description"))
        }
        var btn = outerrow.find("@button") // index button
        var msg = jq("$msg")
        click(btn.toWidget())
        waitResponse()
        verifyEquals("item index " + i, msg.toWidget().get("value"))
      }
      // =================================add after 2rd row
      outeritem = outerrows.eq(1)
      click(outeritem.find("@button").get(2)) // click the add after button on 2nd row
      waitResponse()
      outerbox = jq("$outergrid")
      outerrows = outerbox.find("@rows").children()
      itemLabel = Array("A", "C", "C1", "D")
      verifyEquals(itemLabel.length, outerrows.length())
      for (i <- 0 to itemLabel.length - 1) {
        var outerrow = outerrows.eq(i)
        var combobox = outerrow.find("@combobox")
        var comboitems = combobox.find("@comboitem")
        verifyEquals(2, comboitems.length())
        for (j <- 0 to 1) {
          var comboitem = comboitems.eq(j)
          verifyEquals(itemLabel(i) + " " + j + "-" + j + "-" + i, comboitem.toWidget().get("label"))
          verifyEquals(itemLabel(i) + " " + j, comboitem.toWidget().get("description"))
        }
        var btn = outerrow.find("@button") // index button
        var msg = jq("$msg")
        click(btn.toWidget())
        waitResponse()
        verifyEquals("item index " + i, msg.toWidget().get("value"))
      }
      // =================================add before 2rd row
      outeritem = outerrows.eq(2)
      click(outeritem.find("@button").get(3)) // click the add before button on 2nd row
      waitResponse()
      outerbox = jq("$outergrid")
      outerrows = outerbox.find("@rows").children()
      itemLabel = Array("A", "C", "C12", "C1", "D")
      verifyEquals(itemLabel.length, outerrows.length())
      for (i <- 0 to itemLabel.length - 1) {
        var outerrow = outerrows.eq(i)
        var combobox = outerrow.find("@combobox")
        var comboitems = combobox.find("@comboitem")
        verifyEquals(2, comboitems.length())
        for (j <- 0 to 1) {
          var comboitem = comboitems.eq(j)
          verifyEquals(itemLabel(i) + " " + j + "-" + j + "-" + i, comboitem.toWidget().get("label"))
          verifyEquals(itemLabel(i) + " " + j, comboitem.toWidget().get("description"))
        }
        var btn = outerrow.find("@button") // index button
        var msg = jq("$msg")
        click(btn.toWidget())
        waitResponse()
        verifyEquals("item index " + i, msg.toWidget().get("value"))
      }
    })
  }
}
