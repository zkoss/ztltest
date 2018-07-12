/* B30_1823278Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1823278Test extends ZTL4ScalaTestCase {
  @Test
  def testKeyDownUp() = {
    var zscript =
      """
<zk>
<zscript><![CDATA[
	import java.util.ArrayList;
	ArrayList list = new ArrayList();

	for(int i=1;i<=50;i++)
	{
		list.add("entry "+i);
	}
]]></zscript>
	<listbox id="listbox" width="250px" rows="6">
		<listhead sizable="true">
			<listheader label="name" sort="auto"/>
		</listhead>
		<listitem forEach="${list}" label="${each}"/>
	</listbox>
</zk>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val listbox = ztl$engine.$f("listbox")
    runZTL(zscript, () => {
      click(jq(".z-listitem:eq(0)"))
      waitResponse()
      var temp = 0
      for (i <- 0 until 15) {
        sendKeys(jq(listbox), Keys.DOWN)
        sleep(30)
        temp = i
      }
      var scrollTop = listbox.$n("body").attr("scrollTop").toInt
      verifyTrue("Times of pressing Down: " + temp + ", scrollTop: " + scrollTop, 150 < scrollTop)
      temp = 0
      for (i <- 0 until 15) {
        sendKeys(jq(listbox), Keys.UP)
        sleep(30)
        temp = i
      }
      scrollTop = listbox.$n("body").attr("scrollTop").toInt
      verifyTrue("Times of pressing Down: " + temp + ", scrollTop: " + scrollTop, 3 > scrollTop)
    })
  }
}



