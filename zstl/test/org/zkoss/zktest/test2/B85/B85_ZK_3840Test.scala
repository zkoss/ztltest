package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B85-ZK-3840.zul")
class B85_ZK_3840Test extends ZTL4ScalaTestCase {
  @Test
  def test()=  {
    runZTL(() => {
      val win = widget(jq("@window"))
      val btns = jq("@button")
      val div1 = jq("$div1")
      val w1 = div1.width()

      click(btns.eq(0))
      waitResponse()
      click(btns.eq(2))
      waitResponse()
      val w2 = div1.width()
      verifyTrue("The width of div1 should be smaller", w2 < w1)

      click(btns.eq(1))
      waitResponse()
      click(btns.eq(3))
      waitResponse()
      val w3 = div1.width()
      verifyTrue("The width of div1 should be much smaller", w3 < w2)
    })
  }
}
