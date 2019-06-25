package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers

/**
  * @author leonlee
  */
@IgnoreBrowsers("chrome,safari,edge,ie11,ie10,ie9")
class B50_ZK_521Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      verifyEquals(jq(".z-select").outerWidth(), jq(".z-button").outerWidth())
    })
  }
}
