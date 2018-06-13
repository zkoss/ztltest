/* B30_1773652Test.java

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


class B30_1773652Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
	abc.zs doesn't exist and it shall show up a more readable message, For example:
	<separator/>
	org.zkoss.zk.ui.UiException: File not found: abc.zs, at ...
	<separator/>
	<iframe id="frameid" src="/test2/B30-1773652_1.zul" width="500px" height="500px"/>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val frameid = ztl$engine.$f("frameid")
    runZTL(zscript, () => {
      selectFrame(frameid)
      verifyTrue(getHtmlSource().toLowerCase().contains("file not found") && getHtmlSource().toLowerCase().contains("abc.zs"))
    })
  }
}



