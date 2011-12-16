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

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_CollectionIndexGrid1 extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = { //collection-index-grid.zul
      <window apply="org.zkoss.zktest.bind.basic.CollectionIndexGridComposer">
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
              <grid hflex="1" model="@bind(item.options)">
                <columns>
                  <column label="index"/>
                  <column label="previous-index"/>
                  <column label="name"/>
                </columns>
                <template name="model" var="option">
                  <row>
                    <label value="@bind(optionStatus.index)"/>
                    <label value="@bind(s.index)"/>
                    <label value="@bind(option)"/>
                  </row>
                </template>
              </grid>
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
      var outerbox = jq("$outergrid").toWidget()
      var outerrows = jq(outerbox).find("@rows").toWidget()
      val itemLabel = Array("A", "B", "C", "D")
      verifyEquals(itemLabel.length, outerrows.nChildren())
      var outerrow = outerrows.firstChild()
      for (i <- 0 to itemLabel.length - 1) {
        var outerl = itemLabel(i)
        var rowkid = outerrow.firstChild()
        verifyEquals("" + i, rowkid.get("value")) // verify the index on label
        rowkid = rowkid.nextSibling()
        verifyEquals(outerl, rowkid.get("value")) // verify the label on label
        var innergrid = rowkid.nextSibling()
        verifyTrue(innergrid.exists())
        var innerrows = jq(innergrid).find("@row")
        verifyEquals(2, innerrows.length())
        var innerrow = innerrows.first()
        for (j <- 0 to 1) {
          rowkid = innerrow.toWidget().firstChild()
          verifyEquals("" + j, rowkid.get("value"))
          rowkid = rowkid.nextSibling()
          verifyEquals("" + i, rowkid.get("value"))
          var innerl = itemLabel(i) + " " + j
          rowkid = rowkid.nextSibling()
          verifyEquals(innerl, rowkid.get("value"))
          innerrow = innerrows.next()
        }
        rowkid = outerrow.lastChild()
        var btn = jq(rowkid).find("@button").toWidget() // index button
        var msg = jq("$msg").toWidget()
        click(btn)
        waitResponse()
        verifyEquals("item index " + i, msg.get("value"))
        outerrow = outerrow.nextSibling()
      }
    })
  }
}