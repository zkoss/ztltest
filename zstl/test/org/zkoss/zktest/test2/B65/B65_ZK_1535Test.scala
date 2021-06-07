package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1535.zul")
class B65_ZK_1535Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(
      () => {
        // check datebox popup
        // 1. type the date
        `type`(jq(".z-datebox-input"), "Mar 1, 2013");
        waitResponse();
        // 2. open popup
        click(jq(".z-datebox-button"));
        waitResponse(true);
        // 3. make sure it is showing Mar, 2013
        verifyEquals("should see Mar", "Mar", jq(".z-datebox-popup .z-calendar-text:eq(0)").text());
        verifyEquals("should see 2013", "2013", jq(".z-datebox-popup .z-calendar-text:eq(1)").text());
        // 4. make sure we're seeing 6 weeks shown
        verifyEquals("should see 6 weeks showed.", jq(".z-datebox-popup").find(".z-calendar tbody tr").length(), 6)
        // 5. close the popup first
        click(jq(".z-datebox-button"));
        waitResponse(true);

        // check calendar
        // 6. click year three times
        click(jq(".z-calendar-text").last());
        waitResponse(true)
        click(jq(".z-calendar-text").last());
        waitResponse(true)
        click(jq(".z-calendar-text").last());
        waitResponse(true)
        // 7. make sure we're seeing "1990-2099"
        verifyEquals("should see 1990 - 2099", "1990 - 2099", jq(".z-calendar-text").last().text());
        // 8. go to 2013
        click(jq(".z-calendar-cell[data-value=2010]"))
        waitResponse(true)
        click(jq(".z-calendar-cell[data-value=2013]"))
        waitResponse(true)
        click(jq(".z-calendar-cell[data-value=2]"))
        waitResponse(true)
        // 9. make sure we're seeing Mar, 2013
        verifyEquals("should see 2013", "2013", jq(".z-calendar-text").last().text())
        verifyEquals("should see Mar", "Mar", jq(".z-calendar-text").last().prev().text())
        sleep(10000)
        // 10. make sure we're seeing 6 weeks shown
        verifyEquals("should see 6 weeks showed.", jq(".z-calendar").last().find("tbody tr").length(), 6)
      })
  }
}
