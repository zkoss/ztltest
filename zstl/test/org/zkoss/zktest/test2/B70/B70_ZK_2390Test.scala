package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2390.zul")
class B70_ZK_2390Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        val hlayout = jq("@hlayout");
        val win = jq("@window");
        println(hlayout.offsetLeft() + hlayout.width(), " ", win.offsetLeft() + win.outerWidth());
        verifyEquals("window should be extended to right edge.",
          hlayout.offsetLeft() + hlayout.width(), win.offsetLeft() + win.outerWidth());
      })

  }
}
