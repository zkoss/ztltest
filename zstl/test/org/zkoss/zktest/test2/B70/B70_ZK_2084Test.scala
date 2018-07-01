package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2084.zul")
class B70_ZK_2084Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        var list = List("0.0", "0.0", "0.00")
        for (index <- 0 to 3; result <- list) {
          val ds = jq(".z-doublespinner").eq(index).toWidget()
          clickAt(ds.$n("btn-up"), "5,5")
          waitResponse()
          clickAt(ds.$n("btn-down"), "5,5")
          waitResponse()
          verifyTrue("should see " + result, ds.$n("real").get("value") == result)
        }
      })
  }
}