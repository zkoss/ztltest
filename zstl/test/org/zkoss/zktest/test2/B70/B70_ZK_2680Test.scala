package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2680.zul")
class B70_ZK_2680Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(
    () => {
      val icon = jq(".z-nav")
      click(icon)
      waitResponse(true)
      click(jq(".z-nav-popup .z-nav-content").first())
      waitResponse(true)
      mouseOut(icon)
      waitResponse(true)
      mouseOver(icon)
      waitResponse(true)
      verifyTrue(jq(".z-nav-popup .z-nav").hasClass("z-nav-open"))
    })
  }
}