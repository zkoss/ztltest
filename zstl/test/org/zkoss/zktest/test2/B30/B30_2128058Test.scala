/* B30_2128058Test.java

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


class B30_2128058Test extends ZTL4ScalaTestCase {
  @Test
  def testtestRun() = {
    var zscript =
      """
			


<borderlayout height="500px">
	<north  id="west" visible="false" maxsize="300" size="50%" splittable="true" collapsible="true">
	</north>
	<center border="0">
		
<button label="Click me, then you should see the North region." onClick='west.visible = !west.visible'/>
	</center>
</borderlayout>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val west = ztl$engine.$f("west")
    runZTL(zscript, () => {
      verifyFalse("west.isVisible() is true!", jq(west).isVisible())
      click(jq("@button"))
      waitResponse()
      verifyTrue("west.isVisible() is not found.", jq(west).isVisible())
    })
  }
}



