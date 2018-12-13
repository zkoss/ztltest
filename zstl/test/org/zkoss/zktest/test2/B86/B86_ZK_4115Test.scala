/* B86_ZK_4115Test.java

        Purpose:

        Description:

        History:
                Tue Dec 04 17:25:14 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.JQuery

class B86_ZK_4115Test extends ZTL4ScalaTestCase {
	var listbox: JQuery = _

	@Test
	def test() = {
		runZTL(() => {
			listbox = jq(".z-listbox")
			scrollToRightAndLeft()
			windowResizeTo(getWindowWidth + 100, getWindowHeight)
			waitResponse()

			var headers = jq(".z-listheader")
			val length = headers.length()
			val headersWidth = new Array[Int](length)
			for (i <- 0 until length) {
				headersWidth(i) = headers.eq(i).width()
			}

			scrollToRightAndLeft()
			headers = jq(".z-listheader")
			for (i <- 0 until length) {
				verifyTolerant(headersWidth(i), headers.eq(i).width(), 2)
			}
		})
	}

	def scrollToRightAndLeft() = {
		frozenScroll(listbox, 1)
		waitResponse()
		frozenScroll(listbox, 0)
		waitResponse()
	}
}
