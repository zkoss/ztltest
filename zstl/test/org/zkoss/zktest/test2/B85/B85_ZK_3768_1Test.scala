package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B85-ZK-3768.zul")
class B85_ZK_3768_1Test extends ZTL4ScalaTestCase {
  @Test
  def test2()=  {
    val zscript =
      """<include src="/test2/B85-ZK-3768.zul"/>"""

    runZTL(zscript, () => {
      click(jq("@button:eq(1)"))
      waitResponse()

      val listheader = jq("@listheader:eq(1)")
      val width0 = listheader.outerWidth()
      val height0 = listheader.outerHeight()
      dragdropTo(listheader, (width0 - 2) + "," + (height0 / 2), (width0) + "," + (height0 / 2))
      waitResponse()

      click(jq("@button:eq(0)"))
      waitResponse()

      click(jq("@button:eq(1)"))
      waitResponse()

      verifyEquals(jq("@listheader:eq(0)").width(), 150)
    })
  }
}
