/* B85_ZK_3641Test.java

        Purpose:

        Description:

        History:
                Thu Mar 29 14:34:38 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.F85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.JQuery

class B85_ZK_3641Test extends ZTL4ScalaTestCase {


	@Test
	def test(): Unit = {
		runZTL(() => {
			testIframeVisible(jq(".z-datebox-button"))
			testIframeVisible(jq(".z-chosenbox"))
			testIframeVisible(jq(".z-colorbox"))
		})
	}

	def testIframeVisible(wgt: JQuery): Unit = {
		click(wgt)
		waitResponse(true)

		verifyEquals(jq(".z-iframe").css("visibility"), "hidden")

		click(jq(".z-label"))
		waitResponse(true)
	}
}
