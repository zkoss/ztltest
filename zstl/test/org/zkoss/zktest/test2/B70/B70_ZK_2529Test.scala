package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2529.zul")
class B70_ZK_2529Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        var text = jq(".z-textbox");
        for (i <- 0 to 2) {
          var t = text.eq(i)
          typeKeys(t, "chunfu")
          waitResponse();
          verifyEquals("chunfu", t.`val`())
        }
      })
  }
}