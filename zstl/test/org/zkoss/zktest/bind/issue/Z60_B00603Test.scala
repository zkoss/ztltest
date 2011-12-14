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
class Z60_B00603Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = { // B00603.zul
      <window apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.issue.B00603')">
        the nested listbox(option) should render correctly
        <listbox id="outsidebox" width="500px" model="@bind(vm.items)" rows="3" sclass="outside">
          <custom-attributes mark="outside"/>
          <listhead>
            <listheader label="name"/>
            <listheader label="options" width="200px"/>
          </listhead>
          <template name="model" var="item">
            <listitem>
              <listcell label="@bind(item.name)"/>
              <listcell>
                <listbox hflex="1" model="@bind(item.options)" sclass="inside">
                  <custom-attributes mark="inside"/>
                  <listhead>
                    <listheader label="name"/>
                    <listheader label="value"/>
                  </listhead>
                  <template name="model" var="option">
                    <listitem>
                      <listcell label="@bind(option.name)"/>
                      <listcell label="@bind(option.value)"/>
                    </listitem>
                  </template>
                </listbox>
              </listcell>
            </listitem>
          </template>
        </listbox>
        <hbox>
          <button label="Dump" onClick="binder.getTracker().dump()"/>
        </hbox>
      </window>
    }

    runZTL(zul, () => {
      val outerbox = engine.$f("outsidebox") 
      verifyEquals(outerbox.nChildren(), 4)  // include header
      val itemLabel = Array("A", "B", "C") 
      val optionLabel = Array("A", "B") 
      var outeritem = outerbox.firstChild()  // will skip header
      for (i <- 0 to 2) {
        outeritem = outeritem.nextSibling() 
        val outerl = itemLabel(i) 
        var cell = outeritem.firstChild() 
        verifyEquals(outerl, cell.get("label")) 
        val innerbox = jq(outeritem).find("@listbox") 
        verifyTrue(innerbox != null) 
        val inneritems = jq(innerbox).find("@listitem") 
        verifyEquals(2, inneritems.length()) 
        var inneritem = inneritems.first() 
        for (j <- 0 to 1) {
          val innerl = optionLabel(j) 
          cell = inneritem.toWidget().firstChild() 
          verifyEquals(outerl + " " + innerl, cell.get("label")) 
          cell = cell.nextSibling() 
          verifyEquals(outerl + " " + innerl + innerl, cell.get("label")) 
          inneritem = inneritem.next() 
        }
      }
    })
  }
}