package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B85-ZK-3718.zul")
class B85_ZK_3718Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val height = jq("@vlayout").height() // 500px
      val lastDiv = jq(".z-vlayout-inner:last")
      verifyTolerant(height, lastDiv.offsetTop() + lastDiv.height(), 3)
    })
  }
}
