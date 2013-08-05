package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B60-ZK-1341.zul")
class B60_ZK_1341Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
                    <label multiline="true">
                      1. Change default language of browser to zh_TW.
	2. Change AM/PM (zh_TW) in timebox.
	3. Close the popup calendar and you should see correct date time in datebox.
                    </label>
                    <datebox id="db" format="long+medium" width="300px"/>
                  </zk>"""

    runZTL(zscript,
      () => {
        click(engine.$f("db").$n("btn"))
        waitResponse()

        click(jq(".z-timebox").toWidget().$n("btn-up"))
        waitResponse()

        val timelongfmt = jq(jq(".z-timebox").toWidget().$n("real")).`val`()

        click(jq(".z-calendar-selected"))
        waitResponse()

        val datetimelongfmt = jq(jq(".z-datebox:eq(0)").toWidget().$n("real")).`val`()

        val Pattern1 = """.*(\d\d):(\d\d):(\d\d).*""".r
        val Pattern2 = """.*( \d):(\d\d):(\d\d).*""".r

        val long2short = (shtfmt: String) => shtfmt match {
          case Pattern1(hh, mm, ss) => hh + ":" + mm + ":" + ss
          case Pattern2(h, mm, ss) => h.replace(" ", "0").concat(":").concat(mm).concat(":").concat(ss)
          case _ => "00:00:00"
        }

        val time = long2short(timelongfmt)
        val dateTime = long2short(datetimelongfmt)

        verifyEquals("should see correct date time in datebox.", time, dateTime)
      })

  }
}
