package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "F80-ZK-3039.zul")
class F80_ZK_3039Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(
      () => {
        var div = jq("$div")
        verifyEquals(5, div.children().length)
        for (i <- 0 to 4) {
          var c = div.children().eq(i)
          verifyEquals(100, c.outerWidth)
          verifyEquals(100, c.outerHeight)
          if (c == 1 || c == 4)
            verifyEquals("amazing", c.text)
        }
    })
  }
}

