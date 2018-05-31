/* B36_2721780Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B36_2721780Test extends ZTL4ScalaTestCase {
  @Test
  def testsize() = {
    var zscript =
      """
			<zk>
			Resize the outer window, the inner most window should not change.
			<window id="out" border="normal" title="." sizable="true"
			  mode="overlapped" width="500px" height="500px">
			  <window id="middle" border="normal" width="300px" height="300px">
			    <window id="innermost" border="normal" width="100px"
			      height="100px" sizable="true" mode="overlapped">
			
			    </window>
			  </window>
			</window>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val out = ztl$engine.$f("out")
    val middle = ztl$engine.$f("middle")
    val innermost = ztl$engine.$f("innermost")
    runZTL(zscript, () => {
      var br = jq("$out")
      var innerWin = jq(innermost)
      var oldHeight = innerWin.outerHeight()
      var oldWidth = innerWin.outerWidth()
      dragdropTo(jq("$out").toWidget().$n("cap"), "2,2", "100,100")
      verifyEquals(oldHeight, innerWin.outerHeight())
      verifyEquals(oldWidth, innerWin.outerWidth())
    })
  }
}



