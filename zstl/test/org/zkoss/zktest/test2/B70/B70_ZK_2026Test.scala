package org.zkoss.zktest.test2.B70

import java.util.Calendar

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2026.zul")
class B70_ZK_2026Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<window border="normal" width="500px">
	<label multiline="true">
		1. Pick a date with year other than the current year
		2. After close the calendar control, the year should not changes to the current year.
	</label>
	<datebox format="MM.yyyy"/>
</window>"""
    runZTL(zscript,
      () => {
        click(jq(".z-datebox").toWidget().$n("btn"))
        waitResponse()
        val calendar0 = jq(".z-calendar:eq(0)")
        click(calendar0.find(".z-calendar-title .z-calendar-text:eq(1)"))
        waitResponse()
        click(calendar0.find(".z-calendar-body td:contains(2013)"))
        waitResponse()
        click(calendar0.find(".z-calendar-body td:eq(9)"))
        waitResponse()
        click(calendar0.find(".z-calendar-body td:contains(20)"))
        waitResponse()
        val cal = Calendar.getInstance()
        verifyTrue("the year should not changes to the current year.", !jq(".z-datebox").toWidget().$n("real").get("value").contains("" + cal.get(Calendar.YEAR)))
      })

  }
}