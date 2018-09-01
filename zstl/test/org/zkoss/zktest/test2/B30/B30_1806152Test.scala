/* B30_1806152Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1806152Test extends ZTL4ScalaTestCase {
  @Test
  def testModel() = {
    var zscript =
      """
<zk>
<html><![CDATA[
In IE, if model size is zero (start from zero or after clear)
then when add new one in to model, the listbox will miss the onRender au
event which should send to server,
but it is work in FF.<br/>
<br/>
]]></html>
<button id="btn" label="add" onClick="add()" />
<listbox id="lb"/>
<zscript>
ListModelList model = new ListModelList();
//model.add("Item 1");
lb.setModel(model);
public void add(){
if(model.size()>10){
model.clear();
}else{
model.add(">>Item Y :"+new java.util.Date());
}
}
</zscript>
</zk>
		"""
    val ztl$engine = engine()
    val btn = ztl$engine.$f("btn")
    val lb = ztl$engine.$f("lb")
    runZTL(zscript, () => {
      verifyEquals("0", lb.nChildren())
      click(btn)
      waitResponse()
      verifyEquals("1", lb.nChildren())
      verifyContains(lb.firstChild().attr("label"), ">>Item Y :")
      click(btn)
      waitResponse()
      verifyEquals("2", lb.nChildren())
      verifyContains(lb.lastChild().attr("label"), ">>Item Y :")
      click(btn)
      waitResponse()
      verifyEquals("3", lb.nChildren())
      // assumed the height of the label is 15px
      verifyTrue(jq(lb).outerHeight() > 15 * 3)
      verifyTrue(jq("@listitem:odd").hasClass("z-listbox-odd"))
    })
  }
}



