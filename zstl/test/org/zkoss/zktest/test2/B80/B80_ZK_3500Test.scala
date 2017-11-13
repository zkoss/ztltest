package org.zkoss.zktest.test2.B80

import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * Created by wenninghsu on 01/11/2017.
  */
class B80_ZK_3500Test extends ZTL4ScalaTestCase {

  def test() = {
    runZTL(() => {
      verifyEquals(0, jq(".z-x-item").length())
      click(jq(".z-chosenbox"))
      waitResponse(true)
      typeKeys(jq(".z-chosenbox-input"), "a")
      waitResponse(true)
      keyPressNative("13")
      waitResponse(true)
      verifyEquals(1, jq(".z-chosenbox-item").length())
    })
  }

}
