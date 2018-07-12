package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B85-ZK-3766.zul")
class B85_ZK_3766Test extends ZTL4ScalaTestCase {
  @Test
  def test()=  {
    runZTL(() => {
      val bandbox = jq("$target")
      click(bandbox.find("a"))
      waitResponse(true)

      val ppLeft = jq(".z-bandbox-popup.z-bandbox-open:visible").offsetLeft()
      val bbLeft = bandbox.offsetLeft()
      val delta = ppLeft - bbLeft
      val tolerance = -5
      verifyTrue("The popup should be positioned after_end, not after_start.", delta < tolerance)
    })
  }
}
