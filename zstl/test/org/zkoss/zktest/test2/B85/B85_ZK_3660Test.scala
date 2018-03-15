package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.JQuery

class B85_ZK_3660Test extends ZTL4ScalaTestCase {

	@Test
	def test() = {
		runZTL(() => {
			runFittingTest(jq(".z-column").eq(0), jq(".z-row-inner").eq(0))
			runFittingTest(jq(".z-listheader").eq(0), jq(".z-listcell").eq(0))
			runFittingTest(jq(".z-treecol").eq(0), jq(".z-treecell").eq(0))
		})
	}

	def runFittingTest(header: JQuery, body: JQuery) = {

		val clickPosition = (header.offsetLeft() + header.width() - 3) + "," + (header.offsetTop() + 5)

		doubleClickAt(header, clickPosition)
		waitResponse(true)

		click(body)
		waitResponse(true)

		doubleClickAt(header, clickPosition)
		waitResponse(true)
	}
}
