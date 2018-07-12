package org.zkoss.zktest.test2.F85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "F85-ZK-3525.zul")
class F85_ZK_3525Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      click(jq("@button"))
      waitResponse()

      nativeFrozenScroll(jq("@grid"), 0)
      click(jq("@button"))
      waitResponse()

      verifyEquals(getZKLog, "1\n0")
    })
  }
}
