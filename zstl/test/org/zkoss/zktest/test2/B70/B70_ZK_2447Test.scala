package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2447.zul")
class B70_ZK_2447Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(
    () => {
      val first = jq("@listitem:eq(1)")
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
      verifyEquals("2", jq(".z-notification-content:last").text())
      waitResponse()
      click(removeBtn)
      waitResponse()
      click(showBtn)
      waitResponse()
      verifyEquals("0", jq(".z-notification-content:last").text())
      
    })
    
  }
}
