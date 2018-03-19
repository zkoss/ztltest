/* B85_ZK_3608Test.java

        Purpose:

        Description:

        History:
                Mon Mar 19 12:13:32 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B85_ZK_3608Test extends ZTL4ScalaTestCase {
	@Test
	def test() = {
		runZTL(() => {
			click(jq(".z-nav-content"))
			waitResponse(true)

			jq(".z-west-body").scrollTop(1914)
			waitResponse(true)

			val lastItem = jq(".z-navitem:last-of-type")

			click(lastItem)
			waitResponse(true)

			verifyEquals("z-navitem z-navitem-selected", lastItem.attr("class"))

			click(jq(".z-hlayout-inner > button"))
			waitResponse(true)

			click(jq(".z-menu").eq(0))
			waitResponse(true)
		})
	}
}
