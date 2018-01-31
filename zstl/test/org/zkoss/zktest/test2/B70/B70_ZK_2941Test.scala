package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * Created by wenning on 1/21/16.
 */
@Tags(tags = "B70-ZK-2941.zul")
class B70_ZK_2941Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      var cbbid = jq("@combobutton").get(0).get("id")
      var cf = jq(":focus").toWidget
      sendKeys(cf, Keys.TAB)
      waitResponse()
      verifyEquals(cbbid, cf.uuid())
      sendKeys(cf, Keys.ENTER)
      waitResponse()
      sendKeys(cf, Keys.ENTER)
      waitResponse()
      verifyEquals(cbbid, cf.uuid())
      sendKeys(cf, Keys.SPACE)
      waitResponse()
      sendKeys(cf, Keys.ENTER)
      waitResponse()
      verifyEquals(cbbid, cf.uuid())
      sendKeys(cf, Keys.ARROW_DOWN)
      waitResponse()
      var mppsd = jq(".z-menupopup").get(0)
      verifyTrue(isVisible(mppsd))
      sendKeys(jq("@combobutton:eq(0)").toWidget, Keys.ESCAPE)
      waitResponse(true)
      verifyFalse(isVisible(mppsd))
    })
  }
}
