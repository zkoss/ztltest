package org.zkoss.zktest.test2.F80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class F80_ZK_1983Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        val calendarTitle = jq(".z-calendar").toWidget.$n("title")
        var title = jq(calendarTitle).text()
        val calendarToday = jq(".z-calendar").toWidget.$n("today")
        val prev = jq(".z-calendar").toWidget.$n("left")
        click(prev)
        waitResponse()
        click(calendarToday)
        waitResponse()
        verifyEquals(title, jq(calendarTitle).text())

        click(jq(".z-datebox-button"))
        val dtitle = jq("@calendar").toWidget.$n("title")
        val dtoday = jq("@calendar").toWidget.$n("today")
        val dprev = jq("@calendar").toWidget.$n("left")
        title = jq(dtitle).text()
        click(dprev)
        waitResponse()
        click(dtoday)
        waitResponse()
        verifyEquals(title, jq(dtitle).text())
      })

  }
}
