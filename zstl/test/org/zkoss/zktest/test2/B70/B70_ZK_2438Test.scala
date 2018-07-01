package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

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
        verifyEquals("2", jq(".z-cell>.z-label").last().text())
      })

  }
}