package org.zkoss.zktest.test2.F96

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class F96_ZK_4631Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      val tbIcon = jq(".z-toolbar-overflowpopup-button")
      verifyTrue(tbIcon.hasClass("z-icon-home"))
    })
  }
}
