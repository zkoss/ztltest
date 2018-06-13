/* B30_1868454Test.java

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


class B30_1868454Test extends ZTL4ScalaTestCase {
  @Test
  def testZIndex() = {
    var zscript =
      """
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>If a modal window is nested within another modal window, the inner one
			is "NOT" shown only inside the borders of the outer one.
			It means you should able to see window 2.</n:p>
				<button id="goBtn" label="go" onClick="win1.doModal()" />
				<window title="window 1" width="400px" height="400px" id="win1"
					visible="false">
					<button id="win2Btn" label="open window 2" onClick="win2.doModal()" />		
					<button id="detachBtn1" label="close window 1" onClick="win1.detach()" />
					<window title="window 2" id="win2" visible="false" width="400px">
						<label value="window 2" />	
						<button id="detachBtn2" label="close window 2" onClick="win2.detach()" />
					</window>
				</window>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val goBtn = ztl$engine.$f("goBtn")
    val win1 = ztl$engine.$f("win1")
    val win2Btn = ztl$engine.$f("win2Btn")
    val detachBtn1 = ztl$engine.$f("detachBtn1")
    val win2 = ztl$engine.$f("win2")
    val detachBtn2 = ztl$engine.$f("detachBtn2")
    runZTL(zscript, () => {
      click(goBtn)
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



