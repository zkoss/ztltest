/* B50_3284976Test.java

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
import org.zkoss.ztl.Widget


class B50_3284976Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
	<html><![CDATA[
		<ol>
			<li>Type "1-2" in longbox and click on somewhere else. You should see an errorbox. If not, it is a bug.</li>
		</ol>
	]]></html>
	<longbox />
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      typeKeys(jq("@longbox"), "1-2")
      verifyTrue(jq(".z-errorbox").exists())
    })
  }
}



