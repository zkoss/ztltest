package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B85-ZK-3754.zul")
class B85_ZK_3754Test extends ZTL4ScalaTestCase {
  @Test
  def test()=  {
    runZTL(() => {
      val navWidth = jq(".z-nav:eq(0)").outerWidth()
      click(jq("@button"))
      waitResponse()
      verifyEquals(navWidth, jq(".z-nav:eq(0)").outerWidth())
    })
  }
}
