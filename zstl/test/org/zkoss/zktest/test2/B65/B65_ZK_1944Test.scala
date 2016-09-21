package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1944.zul")
class B65_ZK_1944Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        0 to 1 foreach { index =>
          verifyTrue("Should see 12.3 in the box.",
            jq(".z-decimalbox").eq(index).`val`() == "12.3")
        }
      })
  }
}