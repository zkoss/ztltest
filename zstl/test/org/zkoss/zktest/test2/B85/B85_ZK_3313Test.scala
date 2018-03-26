package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B85_ZK_3313Test extends ZTL4ScalaTestCase {

	@Test
	def test() = {
		runZTL(() => {
			verifyEquals(jq(".z-listbox").eq(0).find("td > div").text(), "")
			verifyEquals(jq(".z-grid").eq(0).find("td > div").text(), "")
			verifyEquals(jq(".z-tree").eq(0).find("tbody").text(), "")

			verifyEquals(jq(".z-listbox").eq(1).find("td > div").text(), "no items here")
			verifyEquals(jq(".z-grid").eq(1).find("td > div").text(), "no items here")

			verifyEquals(jq(".z-listbox").eq(2).find("td > div > span").text(), "squeeze")
			verifyEquals(jq(".z-grid").eq(2).find("td > div > span").text(), "squeeze")
			verifyEquals(jq(".z-tree").eq(1).find("td > div > span").eq(1).text(), "squeeze")
		})
	}
}
