package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B85-ZK-3579.zul")
class B85_ZK_3579Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      verifyTolerant(400, jq("@combobutton:eq(0) .z-combobutton-content").outerWidth(), 4)
    })
  }
}
