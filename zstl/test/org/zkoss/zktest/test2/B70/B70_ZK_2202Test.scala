package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2202.zul")
class B70_ZK_2202Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        val db = jq(".z-datebox").toWidget
        val value = db.$n("real").get("value")
        click(db.$n("btn"))
        waitResponse()

        sendKeys(jq(".z-timebox").toWidget.$n("real"),
          Keys.HOME + "" + Keys.ARROW_RIGHT + "" + Keys.ARROW_RIGHT + "" + Keys.ARROW_RIGHT + "" + Keys.ARROW_UP
            + "" + Keys.ENTER)
        verifyTrue("the value of datebox should be updated", value != db.$n("real").get("value"))
      })

  }
}