/* B50_3242925Test.java

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


class B50_3242925Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	<html><![CDATA[
		<ol>
		 <li>IE8 only</li>
		 <li>Dragging the splitter several times.</li>
		 <li>The splitter shall not became small.</li>
		</ol>
	]]></html>
	<hbox height="500px" sizedByContent="false">
		<cell style="background-color:blue;" />
		<splitter />
		<cell style="background-color:red;" />
	</hbox>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      var x = jq("@splitter").width()
      dragdropTo(jq("@splitter"), "3,3", "50,3")
      waitResponse()
      dragdropTo(jq("@splitter"), "3,3", "-150,3")
      waitResponse()
      dragdropTo(jq("@splitter"), "3,3", "100,3")
      waitResponse()
      var x1 = jq("@splitter").width()
      verifyEquals(x, x1)
    })
  }
}



