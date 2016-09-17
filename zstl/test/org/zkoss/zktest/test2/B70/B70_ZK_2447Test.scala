package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2447.zul")
class B70_ZK_2447Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(
    () => {
      val first = jq("@listitem").first()
      val last = jq("@listitem").last()
      val showBtn = jq(".z-button:contains(Show)")
      val removeBtn = jq(".z-button:contains(Remove)")
      waitResponse(true)
      click(first)
      waitResponse()
      click(last)
      waitResponse()
      click(showBtn)
      waitResponse()
      verifyTrue(jq(".z-notification-content").text().equals("2"))
      waitResponse()
      click(removeBtn)
      waitResponse()
      click(showBtn)
      waitResponse()
      verifyTrue(jq(".z-notification-content").text().equals("0"))
      
    })
    
  }
}