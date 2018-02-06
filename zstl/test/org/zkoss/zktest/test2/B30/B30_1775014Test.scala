package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase

class B30_1775014Test extends ZTL4ScalaTestCase {
  def testClick() = {
    runZTL(() => {
      println("Go")
      for (i <- 0 to 9) {
        println("start" + i)
        verifyEquals(jq("$gridInitWidth").html(), jq("$gridCurrentWidth").html());
        println("end" + i)
      }
    })
  }
}