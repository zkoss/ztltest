/* B35_2081863Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B35_2081863Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			

	
<window id="win1" title="ztl" >
	After the page loaded, if you don't see any popup or alert , this bug fixed
<hbox spacing="0" width="150px">
<tabbox id="Tab1" onSelect="refresh()" width="780px">
<tabs>
<tab label="Tp1" />
<tab label="Tp2" />
<tab label="Exit" />
</tabs>
<tabpanels>

<tabpanel id="tp1">
</tabpanel>

<tabpanel id="tp2">
</tabpanel>

<tabpanel id="exit">
</tabpanel>
</tabpanels>
</tabbox>
</hbox>
<zscript>

public void refresh() {

if (Tab1.getSelectedPanel().getId().equals("tp1"))
{
alert("tp1");
}
if (Tab1.getSelectedPanel().getId().equals("tp2"))
{
alert("tp2");
}
if (Tab1.getSelectedPanel().getId().equals("exit"))
{
alert("exit");
}
}
</zscript>
</window>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val win1 = ztl$engine.$f("win1")
    val Tab1 = ztl$engine.$f("Tab1")
    val tp1 = ztl$engine.$f("tp1")
    val tp2 = ztl$engine.$f("tp2")
    val exit = ztl$engine.$f("exit")
    runZTL(zscript, () => {
      verifyFalse(jq("@window:not(@window[title=\"ztl\"])").exists())
      verifyFalse(jq(".z-popup").exists())
    })
  }
}



