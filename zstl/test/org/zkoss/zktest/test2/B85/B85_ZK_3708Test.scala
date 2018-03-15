/* B85_ZK_3708Test.java

        Purpose:

        Description:

        History:
                Thu Mar 15 14:46:05 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B85_ZK_3708Test extends ZTL4ScalaTestCase {

	@Test
	def test() = {
		runZTL(() => {
			val splitlayouts = jq(".z-splitlayout")

			val firstSplitlayout = splitlayouts.eq(0)
			verifyEquals(firstSplitlayout.width(), firstSplitlayout.children().eq(1).width())

			val secondSplitlayout = splitlayouts.eq(1)
			verifyEquals(secondSplitlayout.height(), secondSplitlayout.children().eq(1).height())
		})
	}
}