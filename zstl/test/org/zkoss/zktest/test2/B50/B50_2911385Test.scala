package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * @author rudyhuang
  */
class B50_2911385Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      mouseOver(jq("@menu > .z-menu-content"))
      waitResponse()
      verifyTrue(jq(".z-menupopup").isVisible)

      click(jq("@menuitem:first"))
      waitResponse()
      verifyFalse(jq(".z-menupopup").isVisible)
    })
  }
}
