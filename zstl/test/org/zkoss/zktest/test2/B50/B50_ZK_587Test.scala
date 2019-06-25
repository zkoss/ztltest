package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers

/**
  * @author leonlee
  */
@IgnoreBrowsers("chrome,ff,safari,edge,ie11,ie10")
class B50_ZK_587Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      verScroll(jq(".z-listbox-body"), 110)
      sleep(1000)
      verifyEquals(true, jq(".z-listcell:contains(Option 249999)").exists())
    })
  }
}
