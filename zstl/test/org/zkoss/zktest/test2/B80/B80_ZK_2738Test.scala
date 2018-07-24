package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B80_ZK_2738Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        val d1 = jq(".z-div").eq(0)
        val l1 = d1.find(".z-label")
        verifyEquals(4, l1.length())
        val d2 = jq(".z-div").eq(1)
        val l2 = d2.find(".z-label")
        verifyEquals(4, l2.length())
        for (i <- 0 to 3) {
          verifyEquals(l1.eq(i).text(), l2.eq(i).text())
        }
      })

  }
}