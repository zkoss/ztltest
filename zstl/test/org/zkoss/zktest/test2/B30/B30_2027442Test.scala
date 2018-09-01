/* B30_2027442Test.java

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


class B30_2027442Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<window id="wnd" width="100%" title="Model and Paging">
<html><![CDATA[
<p>1. Yous shall see a button "Load".<br/>
2. Click "Load" button.<br/>
3. You shall see a list with "0", "1", "2", "3"  and so on in order.<br/>
4. If not in order, it is a bug.<br/>
5. Done.
</p>
]]></html>
	<zscript><![CDATA[
		void load() { 
			int num = 16;
		    String[] entries = new String[num];
		    for(int j=0; j < num; ++j) {
		    	entries[j] = ""+j;
		    }
			lbx.setModel(new SimpleListModel(entries));
		} 
	]]></zscript>

	<button id="load" label="Load" onClick="load()" />
	<listbox id="lbx" mold="paging" pageSize="5">
	</listbox>
</window>

		"""
    val ztl$engine = engine()
    val wnd = ztl$engine.$f("wnd")
    val load = ztl$engine.$f("load")
    val lbx = ztl$engine.$f("lbx")
    runZTL(zscript, () => {
      click(jq("@button[label=\"Load\"]"))
      waitResponse()
      verifyEquals("0", jq("@listitem:eq(0)").text())
      verifyEquals("1", jq("@listitem:eq(1)").text())
      verifyEquals("2", jq("@listitem:eq(2)").text())
      verifyEquals("3", jq("@listitem:eq(3)").text())
      verifyEquals("4", jq("@listitem:eq(4)").text())
    })
  }
}



