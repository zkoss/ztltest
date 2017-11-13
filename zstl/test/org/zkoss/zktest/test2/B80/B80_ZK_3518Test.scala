package org.zkoss.zktest.test2.B80

import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * Created by wenninghsu on 01/11/2017.
  */
class B80_ZK_3518Test extends ZTL4ScalaTestCase {

  def test() = {
    runZTL(() => {
      dragdropToObject(jq(".z-groupbox-content"), jq(".z-div:eq(1)"), "0,0", "0,0")
      waitResponse(true)
      verifyEquals(1, jq(".z-label:eq(1)").text())
      dragdropToObject(jq(".z-div:eq(0)"), jq(".z-div:eq(1)"), "0,0", "0,0")
      waitResponse(true)
      verifyEquals(2, jq(".z-label:eq(1)").text())
    })
  }

}
