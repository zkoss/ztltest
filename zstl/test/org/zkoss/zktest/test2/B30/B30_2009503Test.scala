/* B30_2009503Test.java

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
import org.zkoss.ztl.Widget


class B30_2009503Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	1.Type "May/02/2008" into datebox , if no error , the bug fixed.
	<separator />
	format="MMM/dd/yyyy".<datebox  format="MMM/dd/yyyy"/>	
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      typeKeys(jq("@datebox").toWidget().$n("real"), "May/02/2008")
      waitResponse()
      verifyFalse(jq(".z-errorbox").exists())
      verifyFalse(jq(".z-error").exists())
      verifyFalse(jq("@window[title=\"ZK Test\"]").exists())
    })
  }
}



