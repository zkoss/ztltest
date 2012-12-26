package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-1341.zul")
class B60_ZK_1341Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
                    <label multiline="true">
                      1. Change default language of browser to zh_TW.
	2. Change AM/PM (zh_TW) in timebox.
	3. Close the popup calendar and you should see correct date time in datebox.
                    </label>
                    <datebox format="long+medium" width="300px"/>
                  </zk>"""

    runZTL(zscript,
      () => {
        click(jq(".z-datebox-btn"))
        waitResponse()

        click(jq(".z-timebox-btn-upper"))
        waitResponse()

        val time = jq(".z-datebox-pp .z-timebox-inp").`val`()

        click(jq(".z-calendar-seld"))
        waitResponse()

        val datetime = jq(".z-datebox-inp:eq(0)").`val`()
        val newDatetime = if (datetime.charAt(0) == ' ') datetime.replaceFirst(" ", "0") else datetime
        verifyEquals(newDatetime.substring(newDatetime.length() - 11, newDatetime.length()), time.substring(time.length() - 11, time.length()))
      })

  }
}
