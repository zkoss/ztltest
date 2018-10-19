/* B86_ZK_3588Test.java

        Purpose:

        Description:

        History:
                Thu Aug 23 17:42:06 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B86_ZK_3588Test extends ZTL4ScalaTestCase {

	@Test
	def test(): Unit = {
		runZTL(() => {
			val button = jq(".z-button")
			click(button)
			waitResponse()
      verifyTolerant(jq(".z-listheader:eq(0)").width(), jq(".z-frozen-body:eq(0)").width(), 2)
      verifyTolerant(jq(".z-column:eq(0)").width(), jq(".z-frozen-body:eq(1)").width(), 2)

			nativeFrozenScroll(jq(".z-listbox"), 600)
			waitResponse()
			nativeFrozenScroll(jq(".z-grid"), 600)
			waitResponse()
			click(button)
			waitResponse()
			verifyTrue(jq(".z-listheader-content:contains(5)").width() > 0)
			verifyTrue(jq(".z-column-content:contains(5)").width() > 0)
		})
	}
}
