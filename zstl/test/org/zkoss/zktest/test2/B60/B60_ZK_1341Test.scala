package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B60-ZK-1341.zul")
class B60_ZK_1341Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        click(engine.$f("db").$n("btn"))
        waitResponse()
        click(jq(".z-timebox").toWidget().$n("btn-up"))
        waitResponse()
        val timelongfmt = jq(jq(".z-timebox").toWidget().$n("real")).`val`()
        click(engine.$f("db").$n("btn"))
        waitResponse()
        val datetimelongfmt = jq(jq(".z-datebox:eq(0)").toWidget().$n("real")).`val`()
        println(datetimelongfmt, timelongfmt)
        verifyTrue("should see correct date time in datebox.", datetimelongfmt.contains(timelongfmt))
      })
  }
}
