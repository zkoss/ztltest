package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1213.zul")
class B65_ZK_1213Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {

        /**
          * 1. Select Dec 16 2012 and click right arrow, should see Jan 16 2013
          * Note: dont simplify it cuz opera will throw exception
          */
        val year = "2012"
        val month = "Dec"
        val day = "16"
        val yearMonth = "Jan 2013"
        val dayOfNextMonth = "16"

        click(jq(".z-calendar").toWidget().$n("ty"))
        waitResponse(true) // wait for animation
        sleep(200);

        click(jq(".z-calendar").toWidget().$n("tyd"))
        waitResponse(true) // wait for animation
        sleep(200);

        click(jq(".z-calendar-cell[data-value=\"2010\"]"))
        waitResponse(true) // wait for animation
        sleep(200);

        click(jq(".z-calendar-cell:contains(" + year + ")"))
        waitResponse(true) // wait for animation
        sleep(200);

        click(jq(".z-calendar-cell:contains(" + month + ")"))
        waitResponse(true) // wait for animation
        sleep(200);

        click(jq(".z-calendar-cell:contains(" + day + ")"))
        waitResponse(true) // wait for animation
        sleep(200);

        click(jq(".z-calendar").toWidget().$n("right"))
        waitResponse(true)

        sleep(500)
        verifyEquals(jq(".z-calendar-title").text(), yearMonth)

        verifyEquals(jq(".z-calendar-weekday.z-calendar-selected").text(), dayOfNextMonth)

        // 2. Select Jan 31 2012 and click right arrow, should see Feb 29 2012
        val year1 = "2012"
        val month1 = "Jan"
        val day1 = "31"
        val yearMonth1 = "Feb 2012"
        val dayOfNextMonth1 = "29"

        click(jq(".z-calendar").toWidget().$n("ty"))
        waitResponse(true) // wait for animation
        sleep(200);

        click(jq(".z-calendar").toWidget().$n("tyd"))
        waitResponse(true) // wait for animation
        sleep(200);

        click(jq(".z-calendar-cell[data-value=\"2010\"]"))
        waitResponse(true) // wait for animation
        sleep(200);

        click(jq(".z-calendar-cell:contains(" + year1 + ")"))
        waitResponse(true) // wait for animation
        sleep(200);

        click(jq(".z-calendar-cell:contains(" + month1 + ")"))
        waitResponse(true) // wait for animation
        sleep(200);

        click(jq(".z-calendar-cell:contains(" + day1 + ")"))
        waitResponse(true) // wait for animation
        sleep(200);

        click(jq(".z-calendar").toWidget().$n("right"))
        waitResponse(true) // wait for animation
        sleep(200);

        verifyEquals(jq(".z-calendar-title").text(), yearMonth1)
        verifyEquals(jq(".z-calendar-weekday.z-calendar-selected").text(), dayOfNextMonth1)

      })

  }
}
