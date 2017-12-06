package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B85-ZK-3784.zul")
class B85_ZK_3784Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val btns = jq("@button")
      val paging = jq("@paging:eq(0)")
      click(btns.eq(2))
      waitResponse()
      verifyEquals("Paging detail should be hidden", "hidden", paging.find(".z-paging-info").css("visibility"))

      click(btns.eq(4))
      waitResponse()
      verifyEquals("Paging detail should be visible", "visible", paging.find(".z-paging-info").css("visibility"))
    })
  }
}
