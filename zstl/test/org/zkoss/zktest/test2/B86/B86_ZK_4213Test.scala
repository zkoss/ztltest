/* B86_ZK_4213Test.java

		Purpose:

		Description:

		History:
				Thu Feb 21 10:19:54 CST 2019, Created by charlesqiu

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B86_ZK_4213Test extends ZTL4ScalaTestCase {
	@Test
	def test(): Unit = {
		runZTL(() => {
			verifyWidth()
			windowResizeTo(800, 800)
			waitResponse()
			verifyWidth()
			verScroll(jq(".z-grid"), 100)
			waitResponse()
			verifyWidth()
		})
	}

	def verifyWidth(): Unit = {
		val columns = jq(".z-columns").children()
		var columnsWidth = 0
		for (i <- 0 until columns.length()) {
			columnsWidth += columns.eq(i).outerWidth()
		}
		verifyTolerant(columnsWidth, jq(".z-grid").outerWidth(), 2)
	}
}
