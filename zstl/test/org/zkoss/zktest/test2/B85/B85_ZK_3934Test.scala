package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * @author rudyhuang
  */
class B85_ZK_3934Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      click(jq("@button:eq(0)"))
      waitResponse()
      verifyContains(getZKLog(), ".z-listcell : 150 / 150")
      closeZKLog()

      click(jq("@button:eq(1)"))
      waitResponse()
      verifyContains(getZKLog(), ".z-cell : 150 / 150")
      closeZKLog()

      click(jq("@button:eq(2)"))
      waitResponse()
      verifyContains(getZKLog(), ".z-treecell : 150 / 150")
    })
  }
}
