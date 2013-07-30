package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.util.Scripts
import org.junit.Test

@Tags(tags = "B65-ZK-1213.zul")
class B65_ZK_1213Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
                    1. Select Dec 16 2012 and click right arrow, should see Jan 16 2013
    				2. Select Jan 31 2012 and click right arrow, should see Feb 28 2013
                    <calendar/>
                  </zk>"""

    runZTL(zscript,
      () => {

        /**
         * 1. Select Dec 16 2012 and click right arrow, should see Jan 16 2013
         * Note: dont simplify it cuz opera will throw exception
         */
        val (year, month, day) = ("2012", "Dec", "16")
        val (yearMonth, dayOfNextMonth) = ("Jan 2013", "16")

        click(jq(".z-calendar").toWidget().$n("ty"))
        waitResponse(true) // wait for animation

        click(jq(".z-calendar-cell:contains(" + year + ")"))
        waitResponse(true) // wait for animation

        click(jq(".z-calendar-cell:contains(" + month + ")"))
        waitResponse(true) // wait for animation

        click(jq(".z-calendar-cell:contains(" + day + ")"))
        waitResponse(true) // wait for animation

        click(jq(".z-calendar").toWidget().$n("right"))
        waitResponse()

        verifyEquals(jq(".z-calendar-title").text(), yearMonth)
        verifyEquals(jq(".z-calendar-weekday.z-calendar-selected").text(), dayOfNextMonth)

        // 2. Select Jan 31 2012 and click right arrow, should see Feb 29 2012
        val (year1, month1, day1) = ("2012", "Jan", "31")
        val (yearMonth1, dayOfNextMonth1) = ("Feb 2012", "29")

        click(jq(".z-calendar").toWidget().$n("ty"))
        waitResponse(true) // wait for animation

        click(jq(".z-calendar-cell:contains(" + year1 + ")"))
        waitResponse(true) // wait for animation

        click(jq(".z-calendar-cell:contains(" + month1 + ")"))
        waitResponse(true) // wait for animation

        click(jq(".z-calendar-cell:contains(" + day1 + ")"))
        waitResponse(true) // wait for animation

        click(jq(".z-calendar").toWidget().$n("right"))
        waitResponse(true) // wait for animation

        verifyEquals(jq(".z-calendar-title").text(), yearMonth1)
        verifyEquals(jq(".z-calendar-weekday.z-calendar-selected").text(), dayOfNextMonth1)

      })

  }
}
