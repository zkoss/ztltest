package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.openqa.selenium.Keys

@Tags(tags = "B60-ZK-1322.zul")
class B60_ZK_1322Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
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
        val timebox = jq(".z-timebox-inp")
        val time = timebox.attr("value")
        
        if (time.matches(""".*[1-5][0-9]""")) {
          sendKeys(timebox, Keys.END + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "00")
        } else {
          sendKeys(timebox, Keys.END + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "33")
        }
        sleep(1000)
        waitResponse

        click(jq("@button"))
        waitResponse()

        verifyEquals(timebox.attr("value"), "")
      })

  }
}
