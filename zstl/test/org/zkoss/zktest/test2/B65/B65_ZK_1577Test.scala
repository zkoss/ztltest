package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1577.zul")
class B65_ZK_1577Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(
      () => {
        verifyTrue("Should see gap between each groupbox.", jq(".z-window:eq(0) .z-hlayout-inner[style*=padding-right]").length() > 0)
        verifyTrue("Should see gap between each groupbox.", jq(".z-window:eq(1) .z-vlayout-inner[style*=padding-bottom]").length() > 0)
      })

  }
}
