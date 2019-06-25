package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers
import org.zkoss.ztl.unit.JQuery

/**
  * @author leonlee
  */
@IgnoreBrowsers("chrome,safari,edge,ie11,ie10,ie9")
class B86_ZK_4152Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val labels: JQuery = jq(".z-label")
      dragdrop(labels.get(1), "5,120")
      waitResponse()
      sleep(500)
      verifyEquals("dropped: Drag me", getZKLog())
    })
  }
}
