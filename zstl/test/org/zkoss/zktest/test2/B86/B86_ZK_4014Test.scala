package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B86-ZK-4014.zul")
class B86_ZK_4014Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit =  {
    runZTL(() => {
      verifyFalse("ZK log shouldn't exist", jq("#zk_log").exists())
      sleep(100) // In case of Vue.js rendering
      verifyEquals("0369test3test4", jq("@fragment div").text())
    })
  }
}
