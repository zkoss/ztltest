package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.openqa.selenium.Keys

@Tags(tags = "B65-ZK-1215.zul")
class B65_ZK_1215Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
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
        click(jq(".z-calendar-title .z-calendar-ctrler:eq(1)"))
        waitResponse()
        click(jq(".z-calendar-calyear td:contains(2013)"))
        waitResponse()
        click(jq(".z-calendar-calmon td:eq(9)"))
        waitResponse()
        val day = jq(".z-calendar-calday td:contains(20)")
        click(day)
        waitResponse()
        
        sendKeys(day, Keys.RIGHT)
        waitResponse()
        
        verifyTrue("the selected css of '10/20' must be removed.", !day.hasClass("z-calendar-seld"))
      })

  }
}