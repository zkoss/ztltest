package org.zkoss.zktest.test2.F65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "F65-ZK-1825.zul")
class F65_ZK_1825Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        val db = jq(".z-datebox").toWidget()
        val tb = jq(".z-timebox").toWidget()
        click(db.$n("btn"))
        waitResponse()

        val calendar0 = jq(".z-calendar:eq(0)")
        click(calendar0.find(".z-calendar-title .z-calendar-text:eq(1)"))
        waitResponse(true)
        click(calendar0.find(".z-calendar-title .z-calendar-text:eq(0)"))
        waitResponse(true)
        click(calendar0.find(".z-calendar-body td[data-value=\"2010\"]"))
        waitResponse(true)
        click(calendar0.find(".z-calendar-body td:contains(2013)"))
        waitResponse(true)
        click(calendar0.find(".z-calendar-body td:eq(9)"))
        waitResponse(true)
        click(calendar0.find(".z-calendar-body td:contains(20)"))
        waitResponse(true)
        click(jq(".z-button"))
        waitResponse(true)

        verifyTrue("It shouldn't be reset to today",
          jq(".z-messagebox-window .z-label:contains(Sun Oct 20)").exists)
      })

  }
}