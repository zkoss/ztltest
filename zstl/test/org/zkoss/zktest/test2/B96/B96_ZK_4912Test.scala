package org.zkoss.zktest.test2.B96

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
 * @author rudyhuang
 */
class B96_ZK_4912Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      select(jq("@select"), 1)
      waitResponse()
      verifyEquals("", getZKLog)
    })
  }
}
