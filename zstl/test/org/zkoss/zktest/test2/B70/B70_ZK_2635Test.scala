package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2635.zul")
class B70_ZK_2635Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(() => {
      mouseOver(jq(".z-nav a"))
      waitResponse()
      val left = jq(".z-nav-popup").css("left")
      // In IE9, if we don't mouse over before and after, the menu would be closed
      val firstItem = jq(".z-navitem a").first
      mouseOver(firstItem)
      click(firstItem)
      mouseOver(firstItem)
      waitResponse()
      verifyEquals(jq(".z-nav-popup").css("left"), left)
    })
  }
}
