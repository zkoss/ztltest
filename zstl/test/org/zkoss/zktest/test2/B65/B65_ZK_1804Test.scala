package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1804.zul")
class B65_ZK_1804Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	<hbox>
		<calendar id="cal" />
		<label>Should not be able to select year less than 1900 or greater than 2099</label>
	</hbox>
</zk>"""
    runZTL(zscript,
      () => {
        click(jq(".z-calendar-title .z-calendar-text:eq(1)"))
        waitResponse()
        val cal = jq(".z-calendar").toWidget()
        for (n <- 1 to 8) {
          click(cal.$n("right"))
        }
        waitResponse()
        verifyFalse("Should not be able to select year greater than 2099", jq("td:contains(2100)").exists)

        for (n <- 1 to 19) {
          click(cal.$n("left"))
        }
        waitResponse()
        verifyFalse("Should not be able to select year less than 1900", jq("td:contains(1899)").exists)
      })

  }
}