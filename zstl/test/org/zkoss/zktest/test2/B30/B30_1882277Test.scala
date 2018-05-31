/* B30_1882277Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B30_1882277Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
<n:p>Click tab1 and then click tab2, you should see the tabpanel of tab2 with scrollbar(Safari only).</n:p>
<tabbox width="400px" mold="accordion">
	<tabs>
		<tab label="Tab 1"/>
		<tab label="Tab 2" selected="true"/>
	</tabs>
	<tabpanels>
		<tabpanel height="100px" style="background:yellow">This
		is panel 1</tabpanel>
		<tabpanel height="100px"
		style="background:blue;overflow:auto">This is panel 2
		<div height="200px">___</div>The second panel
		</tabpanel>
	</tabpanels>
</tabbox>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      click(jq(".z-tab").eq(0))
      waitResponse(true)
      //I leave some time let animate works ,
      //make sure it works.
      var $cave = jq(".z-tabpanel-content:eq(0)")
      verifyTrue($cave.outerHeight() >= $cave.scrollHeight())
      click(jq(".z-tab").eq(1))
      waitResponse(true)
      //I leave some time let animate works ,
      //make sure it works.
      $cave = jq(".z-tabpanel-content:eq(1)")
      verifyTrue($cave.outerHeight() < $cave.scrollHeight());
    })
  }
}



