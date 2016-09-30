package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2438.zul")
class B70_ZK_2438Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(
    () => {
      val detailBtn = jq(".z-detail")
      click(detailBtn)
      waitResponse()
      val sliderBtn = jq(".z-slider-button").last()
      val startL = sliderBtn.positionLeft()
      val startT = sliderBtn.positionTop()
      val endL = startL + 60
      
      mouseOver(sliderBtn)
      waitResponse()
      dragdropTo(sliderBtn, startL + "," + startT, endL + "," + startT)
      waitResponse()
      verifyTrue(jq(".z-cell>.z-label").last().text().equals("2"))
    })
    
  }
}