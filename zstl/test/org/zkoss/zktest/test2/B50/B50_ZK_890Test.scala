package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers
import org.zkoss.ztl.unit.JQuery

/**
  * @author leonlee
  */
@IgnoreBrowsers("chrome,ff,safari,edge_legacy,ie11,ie10")
class B50_ZK_890Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val columns: JQuery = jq(".z-column")
      verifyEquals(true, columns.eq(0).isVisible)
      verifyEquals(true, columns.eq(1).isVisible)
      verifyEquals(true, columns.eq(2).isVisible)
    })
  }
}
