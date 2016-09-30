package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
 * 
 * @author Sefi
 */
@Tags(tags = "")
class B80_ZK_3099Test extends ZTL4ScalaTestCase {
	@Test
	def test() = {
		runZTL(() => {
			click(jq("@button").eq(0))
			val input = jq("@textbox")
			jq(".z-window-content").toElement.set("scrollTop", input.eq(0).positionTop() - 100)
			waitResponse()
			verifyTrue(jq(".z-errorbox").offsetLeft() < input.offsetLeft())
		})
	}
}
