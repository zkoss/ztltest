/* B36_2710830Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2710830Test extends ZTL4ScalaTestCase {
  @Test
  def testposition() = {
    var zscript =
      """
			<zk>
				You should see the window displays on the center.
				<window id="win" title="Position Issue" closable="true" position="center"
				border="normal" mode="overlapped" width="300px">
				<label value="Hello world!" />
				</window>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val win = ztl$engine.$f("win")
    runZTL(zscript, () => {
      var node = win.$n()
      var $node = jq(node)
      var screenWidth = jq(node.parentNode()).outerWidth()
      var screenHeight = jq(node.parentNode()).innerHeight()
      var offsetLeft = $node.offsetLeft()
      var offsetTop = $node.offsetTop()
      var winWidth = $node.outerWidth()
      var winHeight = $node.outerHeight()
      var widthDiff = Math.abs(((screenWidth - winWidth) / 2) - offsetLeft)
      var heightDiff = Math.abs(((screenHeight - winHeight) / 2) - offsetTop)
      verifyTrue(widthDiff <= 3 && widthDiff >= 0)
      verifyTrue(heightDiff <= 3 && heightDiff >= 0)
    })
  }
}



