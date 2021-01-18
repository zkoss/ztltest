package org.zkoss.zktest.test2.F85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.{IgnoreBrowsers, Tags}

/**
  * @author rudyhuang
  */
@Tags(tags = "F85-ZK-3525.zul")
@IgnoreBrowsers("ios,android")
class F85_ZK_3525Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      click(jq("@button"))
      waitResponse()

      nativeFrozenScroll(jq("@grid"), 0)
      click(jq("@button"))
      waitResponse()

      verifyEquals("1\n0", getZKLog)
    })
  }
}
