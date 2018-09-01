/* B50_2928109Test.java

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


class B50_2928109Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<zk>
					If you see in the "my window" the content sentence "my window is here" is in
					the same line then it is OK; otherwise if the "here" is wrapped to the 2nd
					line because window is too narrow, it is bug.
					<window title="my window" border="normal" hflex="min">
					my window is here
					</window>
				</zk>
			"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      verifyTrue(jq(jq(".z-window-embedded").toWidget().$n("cave")).height() < 24)
    })
  }
}



