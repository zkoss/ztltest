package org.zkoss.zktest.test2.B60

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B60-ZK-1322.zul")
class B60_ZK_1322Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
                    <zscript>
                      Date d = new Date();
		public void setValueForDatebox(){
                        d = null;
                        tm.setValue(d);
                      }
                    </zscript>
                    <div>
                      1. Click on the timebox and modify the time on the screen.<separator/>
                      2. Click on the button, setting value to null -> timebox should be blank.
                    </div>
                    <button label="Date to null" onClick="setValueForDatebox()"/>
                    <timebox id="tm" value="${d}"/>
                  </zk>"""

    runZTL(zscript,
      () => {
        click(jq("@timebox"))
        waitResponse()
        val timebox = jq(".z-timebox").toWidget().$n("real")
        val time = timebox.get("value")

        if (time.matches(""".*[1-5][0-9]""")) {
          sendKeys(timebox, Keys.END + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "00")
        } else {
          sendKeys(timebox, Keys.END + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "33")
        }
        sleep(1000)
        waitResponse

        click(jq("@button"))
        waitResponse()

        verifyEquals(timebox.get("value"), "")
      })

  }
}
