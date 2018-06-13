/* B30_2090731Test.java

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


class B30_2090731Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	Click the change button, and the image of the button shall change.
	Then, click the reset button, and the image shall change back.
	<separator/>
	<button id="b" label="Left" image="/test2/img/m1.gif" width="125px"/>
	<separator/>
	<zscript>
	import org.zkoss.image.*;
	</zscript>
	<button label="change"
		onClick='b.setImageContent(new AImage("t", desktop.webApp.getResourceAsStream("/test2/img/folder.gif")))'/>
	<button label="reset" 
		onClick='b.setImage("/test2/img/m1.gif"); '/>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val b = ztl$engine.$f("b")
    runZTL(zscript, () => {
      var ori = jq("@button:eq(0) img").attr("src")
      click(jq("@button[label=\"change\"]"))
      waitResponse()
      var aft = jq("@button:eq(0) img").attr("src")
      verifyNotEquals(ori, aft)
      click(jq("@button[label=\"reset\"]"))
      waitResponse()
      var ori1 = jq("@button:eq(0) img").attr("src")
      verifyEquals(ori, ori1)
    })
  }
}



