package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * Created by wenning on 1/21/16.
  */
@Tags(tags = "B70-ZK-2940.zul")
class B70_ZK_2940Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      // A workaround for losing focus when page loaded
      waitForPageToLoad("5000")

      val btns = jq("@button")
      val cf = jq(":focus")
      val zcf = "zk.currentFocus.uuid"

      sendKeys(cf, Keys.TAB)
      waitResponse()
      verifyEquals(btns.get(0).attr("id"), getEval(zcf))
      waitResponse()
      sendKeys(cf, Keys.TAB)
      waitResponse()
      verifyEquals(btns.get(1).attr("id"), getEval(zcf))
      waitResponse()
      sendKeys(cf, Keys.TAB)
      waitResponse()
      verifyEquals(jq("@combobutton").get(0).attr("id"), getEval(zcf))
    })
  }
}
