package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * Created by wenning on 1/21/16.
 */
@Tags(tags = "B70-ZK-2922.zul")
class B70_ZK_2922Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      var intb = jq(".z-intbox")
      var intbw = intb.toWidget
      var eb = jq(".z-errorbox")
      click(intb)
      waitResponse()
      sendKeys(intbw, Keys.TAB)
      waitResponse()
      verifyTrue(eb.length() == 1)
      for (i <- 1 to 5) {
        click(intb)
        waitResponse()
        verifyTrue(eb.length() == 2)
        sendKeys(intbw, Keys.TAB)
        waitResponse()
        verifyTrue(eb.length() == 2)
      }
    })
  }

}
