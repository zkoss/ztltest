package org.zkoss.zktest.test2.B65

import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1215.zul")
class B65_ZK_1215Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(() => {
        click(jq(".z-calendar-title .z-calendar-text:eq(1)"))
        waitResponse(true) //wait animation
        click(jq(".z-calendar-title .z-calendar-text:eq(0)"))
        waitResponse(true) //wait animation
        click(jq("td:contains(2010-2019)"))
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

        verifyFalse("the selected css of '10/20' must be removed.", day.hasClass("z-calendar-selected"))
      })

  }
}