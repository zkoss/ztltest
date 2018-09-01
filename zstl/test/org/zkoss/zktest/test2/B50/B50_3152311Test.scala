/* B50_3152311Test.java

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


class B50_3152311Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	<html><![CDATA[
		<ol>
		 <li>If you see the datebox, the bug has been fixed.</li>
		</ol>
	]]></html>
	<datebox constraint="between 20071225 and 20071203"/>
</zk>

		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      verifyTrue(jq("@datebox").exists())
      verifyTrue(isVisible(jq("@datebox")))
    })
  }
}



