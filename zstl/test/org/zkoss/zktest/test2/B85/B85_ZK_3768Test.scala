package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B85-ZK-3768.zul")
class B85_ZK_3768Test extends ZTL4ScalaTestCase {
  @Test
  def test()=  {
    runZTL(() => {
      click(jq("@button:eq(1)"))
      waitResponse()

      val listheader = jq("@listheader:eq(1)")
      val width0 = listheader.outerWidth()
      val height0 = listheader.outerHeight()
      dragdropTo(listheader, (width0 - 2) + "," + (height0 / 2), (width0 + 50) + "," + (height0 / 2))
      sleep(1000) // for ios's slow response time (waitResponse is not enough)

      click(jq("@button:eq(1)"))
      waitResponse()

      verifyEquals(jq("@listheader:eq(0)").width(), 150)
    })
  }
}
