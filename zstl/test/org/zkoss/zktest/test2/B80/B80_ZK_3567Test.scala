package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * Created by wenninghsu on 02/11/2017.
  */
class B80_ZK_3567Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      dragdropTo(jq(".z-listitem").get(0), "10,10", "100,200")
      waitResponse()
      verifyFalse(jq("#zk_log").exists())
      click(jq(".z-listitem").get(1))
      waitResponse()
      verifyFalse(jq("#zk_log").exists())
      mouseOver(jq(".z-button"))
      sleep(1000)
      verifyFalse(jq("#zk_log").exists())
    })
  }

}
