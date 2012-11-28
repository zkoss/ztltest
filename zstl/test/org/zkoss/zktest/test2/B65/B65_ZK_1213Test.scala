package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.util.Scripts

@Tags(tags = "B65-ZK-1213.zul")
class B65_ZK_1213Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = <zk>
                    1. Select Dec 16 2012 and click right arrow, should see Jan 16 2013
    				2. Select Jan 31 2012 and click right arrow, should see Feb 28 2013
                    <calendar/>
                  </zk>

    runZTL(zscript,
      () => {

        /**
         * 1. Select Dec 16 2012 and click right arrow, should see Jan 16 2013
         * Note: dont simplify it cuz opera will throw exception
         */
        val (year, month, day) = ("2012", "Dec", "16")
        val (yearMonth, dayOfNextMonth) = ("Jan 2013", "16")

        click(jq(".z-calendar-ctrler:eq(1)"))
        waitResponse()

        val yearWidget = jq("td:contains(2012):eq(1)")
        click(yearWidget)
        waitResponse()

        click(jq(".z-calendar-calmon td:contains(" + month + ")"))
        waitResponse()

        click(jq(".z-calendar-caldayrow td:contains(" + day + ")"))

        click(jq(".z-calendar-right-icon"))
        waitResponse()

        verifyEquals(jq(".z-calendar-title").text(), yearMonth)
        verifyEquals(jq(".z-calendar-wkday.z-calendar-seld").text(), dayOfNextMonth)

        // 2. Select Jan 31 2012 and click right arrow, should see Feb 29 2012
        val (year1, month1, day1) = ("2012", "Jan", "31")
        val (yearMonth1, dayOfNextMonth1) = ("Feb 2012", "29")

        click(jq(".z-calendar-ctrler:eq(1)"))
        waitResponse()

        val yearWidget1 = jq("td:contains(2012):eq(1)")
        click(yearWidget1)
        waitResponse()

        click(jq(".z-calendar-calmon td:contains(" + month1 + ")"))
        waitResponse()

        click(jq(".z-calendar-caldayrow td:contains(" + day1 + ")"))
        waitResponse()

        click(jq(".z-calendar-right-icon"))
        waitResponse()

        verifyEquals(jq(".z-calendar-title").text(), yearMonth1)
        verifyEquals(jq(".z-calendar-wkday.z-calendar-seld").text(), dayOfNextMonth1)

      })

  }
}
