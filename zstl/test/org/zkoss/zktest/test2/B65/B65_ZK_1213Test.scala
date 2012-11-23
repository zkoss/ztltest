package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

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

        val (year, month, day) = ("2012", "Jan", "31") 
        val (yearMonth, dayOfNextMonth) = ("Feb 2012", "29")

        click(jq(".z-calendar-title"))
        waitResponse()

        click(jq("td:contains(2012):eq(1)").toElement())
        waitResponse()

        click(jq(".z-calendar-calmon td:contains(" + month + ")"))
        waitResponse()

        click(jq(".z-calendar-caldayrow td:contains(" + day + ")"))
        waitResponse()

        click(jq(".z-calendar-right-icon"))
        waitResponse()

        verifyEquals(jq(".z-calendar-title").text(), yearMonth)
        verifyEquals(jq(".z-calendar-wkday.z-calendar-seld").text(), dayOfNextMonth)
        
        // dont simplify it cuz opera will throw exception
        val (year1, month1, day1) = ("2012", "Dec", "16")
        val (yearMonth1, dayOfNextMonth1) = ("Jan 2013", "16")
        
        click(jq(".z-calendar-title"))
        waitResponse()

        click(jq("td:contains(2012):eq(1)").toElement())
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
