package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1535.zul")
class B65_ZK_1535Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
        <label multiline="true">
          1. Open datebox calendar.
	2. Change to December 2012 or March 2013, should see 6 weeks showed.
	3. check calendar also.
        </label>
        <hlayout>
          <datebox id="db"/>
          <calendar/>
        </hlayout>
      </zk>"""

    runZTL(zscript,
      () => {
        click(engine.$f("db").$n("btn"))
        waitResponse()
        List(1, 1) foreach { i =>
          val calendar = jq(".z-calendar:eq(" + i + ")")
          click(calendar.find(".z-calendar-text:eq(0)"))
          waitResponse()
          click(calendar.find(".z-calendar-month td:eq(2)"))
          waitResponse()
          verifyEquals("should see 6 weeks showed.", calendar.find(".z-calendar tbody tr").length(), 6)
          click(calendar.find(".z-calendar-weekday:contains(20)"))
          waitResponse()
        }

      })

  }
}
