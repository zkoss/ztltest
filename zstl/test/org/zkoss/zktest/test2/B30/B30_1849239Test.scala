/* B30_1849239Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1849239Test extends ZTL4ScalaTestCase {
  @Test
  def testInserting() = {
    var zscript =
      """
				<zk>
					<window>
					<html><![CDATA[
					1. Press button "Insert at index 0", this program will insert a new Listitem at index 0.<br/>
					2. The new inserted item should be always the first child of the Listbox but it is not.<br/>
					3. You can check the sequence of Listitem.getItems() by pressing the button "Listitem.getItems()" and it is correct.<br/>
					4. The issue should be in the ZK client engine.<br/>
					5. Take away the &lt;listhead> will make it works correct so it has something to do with the &lt;listhead>.<br/>
					]]></html>
					<listbox id="lbx">
						<listhead>
							<listheader label="header"/>
						</listhead>
						<listitem label="Mark"/>
					</listbox>
					<zscript>
					 int x = 0;
					</zscript>
					<button label="Insert at index 0">
						<attribute name="onClick">
						Listitem li = new Listitem("NewItem"+ ++x);
						lbx.insertBefore(li, lbx.getItemAtIndex(0));
						</attribute>
					</button>
					<button label="Listitem.getItems()">
						<attribute name="onClick"><![CDATA[
							StringBuffer sb = new StringBuffer(124);
							for(Iterator it = lbx.getItems().iterator(); it.hasNext();) {
								Listitem li = (Listitem) it.next();
								sb.append(li.getLabel()+",");
							}
							alert(sb.toString());
						]]></attribute>
					</button>
					</window>
				</zk>
			 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val lbx = ztl$engine.$f("lbx")
    runZTL(zscript, () => {
      click(jq(".z-button:eq(0)"))
      waitResponse()
      click(jq(".z-button:eq(1)"))
      waitResponse()
      var result = jq(".z-window-highlighted .z-messagebox").text().trim()
      // System.out.println(result)
      verifyTrue("NewItem1,Mark,".equals(result))
    })
  }
}



