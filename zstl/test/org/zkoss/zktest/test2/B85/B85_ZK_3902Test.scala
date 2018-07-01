package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B85-ZK-3902.zul")
class B85_ZK_3902Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      click(jq("@button:eq(0)"))
      waitResponse()

      val popupTop = jq("@popup").offsetTop
      val liTop = jq("@listitem").offsetTop
      println(s"Popup offsetTop = $popupTop, Listitem offsetTop = $liTop")
      verifyTrue("The popup offsetTop is wrong.", popupTop > liTop)
    })
  }
}
