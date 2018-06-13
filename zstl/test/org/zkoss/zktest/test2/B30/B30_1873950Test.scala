/* B30_1873950Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1873950Test extends ZTL4ScalaTestCase {
  @Test
  def testWindowModal() = {
    var zscript =
      """
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
			It is wrong, when modals are nested, the inner one is positioned to the left of the screen center.(IE only)
				<button id="win1Btn" label="go" onClick="win1.doModal()" />
				<window id="win1" width="300px" height="200px" visible="false"
					title="1" style="overflow:visible" closable="true">
					<button id="win2Btn" label="go" onClick="win2.doModal()" />
					<window id="win2" width="300px" height="200px" visible="false"
						title="2" closable="true">
						<button label="go" disabled="true" />
					</window>
				</window>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val win1Btn = ztl$engine.$f("win1Btn")
    val win1 = ztl$engine.$f("win1")
    val win2Btn = ztl$engine.$f("win2Btn")
    val win2 = ztl$engine.$f("win2")
    runZTL(zscript, () => {
      click(win1Btn)
      waitResponse()
      click(win2Btn)
      waitResponse()
      // Check z-index exists or not.
      var win1ZIndex = jq(win1).css("z-index")
      var win2ZIndex = jq(win2).css("z-index")
      if (win1ZIndex == null || win1ZIndex.trim().length() == 0) {
        verifyTrue("CSS may be changed, please check again and modify test case.", false)
      }
      if (win2ZIndex == null || win2ZIndex.trim().length() == 0) {
        verifyTrue("CSS may be changed, please check again and modify test case.", false)
      }
      verifyTrue(parseInt(win2ZIndex) > parseInt(win1ZIndex))
    })
  }
}



