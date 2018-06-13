/* B50_3245960Test.java

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


class B50_3245960Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk xmlns:h="xhtml">
	<html><![CDATA[
		<ol>
			<li>You should see only "text" in the textarea, otherwise it is a bug.</li>
		</ol>
	]]></html>
	<h:textarea>text</h:textarea>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      verifyEquals("text", jq("textarea").text())
    })
  }
}



