/* B50_3020565Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3020565Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
    <tabbox>
     <tabs>
      <tab label="a" />
      <tab label="b" id="b"/>
     </tabs>
     <tabpanels>
      <tabpanel>Click "header" and then "item" buttons. Then, click the "b" tab to see
      the listbox has a header and an item.</tabpanel>
      <tabpanel>
       <listbox id="lb" width="300px"></listbox>
      </tabpanel>
     </tabpanels>
    </tabbox>
    
    <button id="btn" label="header">
     <attribute name="onClick"><![CDATA[
   Listhead listhead = new Listhead();
   listhead.appendChild(new Listheader("header"));
   listhead.setParent(lb);
  ]]></attribute>
 </button>
 <button id="btn1" label="item">
     <attribute name="onClick"><![CDATA[
   lb.appendChild(new Listitem("item"));
  ]]></attribute>
 </button>
  <button id="btn2" label="all">
     <attribute name="onClick"><![CDATA[
   Listhead listhead = new Listhead();
   listhead.appendChild(new Listheader("header"));
   listhead.setParent(lb);
   
   for(int i = 0; i < 20;i++)
    lb.appendChild(new Listitem("item"));
   
  ]]></attribute>
 </button>
</zk>

		"""
    val ztl$engine = engine()
    val b = ztl$engine.$f("b")
    val lb = ztl$engine.$f("lb")
    val btn = ztl$engine.$f("btn")
    val btn1 = ztl$engine.$f("btn1")
    val btn2 = ztl$engine.$f("btn2")
    runZTL(zscript, () => {
      click(btn);
      waitResponse()
      click(btn1);
      waitResponse()
      click(b);
      waitResponse()
      verifyTrue(jq("@listbox @listheader").exists())
      verifyTrue(jq("@listbox @listitem").exists())
    })
  }
}



