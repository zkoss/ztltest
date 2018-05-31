/* B50_2980383Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_2980383Test extends ZTL4ScalaTestCase {
  @Test
  def testTabscroll() = {
    var zscript =
      """
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
			You should see the "Tab Last" is selected and scroll to the right-most
			closed to the "->" icon.
			<n:table width="100%" style="table-layout:fixed">
			<n:tr>
			<n:td>
			<div width="100%"><div><tabbox width="100%">
			<tabs id="tabs">
			<tab label="Tab 12222222222222222222" closable="true"/>
			<tab label="Tab 22222222222222222222222222" closable="true"/>
			<tab label="Tab 32222222222222222" closable="true"/>
			<tab label="Tab 4222222222222222222222" closable="true"/>

			<tab label="Tab 522222222222222222222222" closable="true"/>
			<tab label="Tab 522222222222222222222222" closable="true"/>
			<tab label="Tab 522222222222222222222222" closable="true"/>
			<tab label="Tab 522222222222222222222222" closable="true"/>
			<tab label="Tab 522222222222222222222222" closable="true"/>
			<tab label="Tab 522222222222222222222222" closable="true"/>

			<tab label="Tab 522222222222222222222222" closable="true"/>
			<tab label="Tab 522222222222222222222222" closable="true"/>
			<tab label="Tab 522222222222222222222222" closable="true"/>

			<tab label="Tab 522222222222222222222222" closable="true"/>
			<tab label="Tab 522222222222222222222222" closable="true"/>
			<tab label="Tab 522222222222222222222222" closable="true"/>
			<tab label="Tab 522222222222222222222222" closable="true"/>
			<tab label="Tab 522222222222222222222222" closable="true"/>
			<tab label="Tab 522222222222222222222222" closable="true"/>
			<tab label="Tab 522222222222222222222222" closable="true"/>
			<tab id="last" label="Tab Last" closable="true" selected="true"/>
			</tabs>
			<tabpanels>
			<tabpanel>This is panel 1</tabpanel>
			<tabpanel>This is panel 2
			The second panel</tabpanel>
			<tabpanel>This is panel 3</tabpanel>
			<tabpanel>This is panel 4</tabpanel>
			<tabpanel>This is panel 5</tabpanel>
			</tabpanels>
			</tabbox>
			</div></div>
			</n:td>
			</n:tr>
			</n:table>
			</zk>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tabs = ztl$engine.$f("tabs")
    val last = ztl$engine.$f("last")
    runZTL(zscript, () => {
      waitResponse(true)
      var header = tabs.$n()
      var tab = last.$n()
      // one px tolerant would be ok .
      verifyTolerant(header.get("scrollLeft").toInt + header.get("offsetWidth").toInt,
        tab.get("offsetLeft").toInt + tab.get("offsetWidth").toInt, 1)
    })
  }
}



