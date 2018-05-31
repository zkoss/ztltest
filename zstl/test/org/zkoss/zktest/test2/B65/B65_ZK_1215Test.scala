package org.zkoss.zktest.test2.B65

import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1215.zul")
class B65_ZK_1215Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
	<label multiline="true">
	1. Click a date (suppose 10/20), and keep cursor on it.
	2. Use arrow keys to change the selected date, the selected css of "10/20" must be removed.
	
	Note: This test case is focus on "Use mouse and keyboard to control Calendar at the same time."
		  Other Calendar's behavior (like change style when mouseOver, mouseOut) must be the same as original.
	</label>
    <calendar id="cal" onChange="in.value = cal.value" />
</zk>"""
    runZTL(zscript,
      () => {
        click(jq(".z-calendar-title .z-calendar-text:eq(1)"))
        waitResponse(true) //wait animation
        click(jq("td:contains(2013)"))
        waitResponse(true) //wait animation
        click(jq(".z-calendar-month td:eq(9)"))
        waitResponse(true) //wait animation
        val day = jq(".z-calendar tbody td:contains(20)")
        click(day)
        waitResponse(true) //wait animation

        sendKeys(day, Keys.RIGHT)
        waitResponse()

        verifyTrue("the selected css of '10/20' must be removed.", !day.hasClass("z-calendar-selected"))
      })

  }
}