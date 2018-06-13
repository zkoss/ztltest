/* B50_3035897Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3035897Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<window>
<html><![CDATA[<ol>
<li>type or paste '100%', it shall become to '1'</li>
</ol>
	]]></html>
	<textbox value="100%" />
<longbox/>
</window>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      typeKeys(jq("@longbox"), "100%")
      waitResponse()
      verifyEquals("1", jq("@longbox").`val`())
    })
  }
}



