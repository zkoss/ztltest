/* B50_2951182Test.java

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


class B50_2951182Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<zk>
    <window id="testWindow" width="200px">
If you can see the words, the bug is fixed.
          <button id="addBtn" label="Add" />
    </window>
    <zscript>
        testWindow.doHighlighted();
        testWindow.getFellow("addBtn").visible = false;

    </zscript>


</zk>
			"""
    val ztl$engine = engine()
    val testWindow = ztl$engine.$f("testWindow")
    val addBtn = ztl$engine.$f("addBtn")
    runZTL(zscript, () => {
      sleep(500)
      verifyFalse(jq(".z-error").exists())
      verifyTrue(isVisible(jq("$testWindow")));
    })
  }
}



