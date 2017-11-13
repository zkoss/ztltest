package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * Created by wenninghsu on 01/11/2017.
  */
class B80_ZK_3346Test extends ZTL4ScalaTestCase {

  @Test
  def test() = {
    runZTL(() => {
      click(jq(".z-button").get(0))
      waitResponse(true)
      verifyTrue(jq(".z-popup:eq(0)").isVisible())
      click(jq(".z-label").get(2))
      waitResponse(true)
      verifyFalse(jq(".z-popup:eq(0)").isVisible())

      click(jq(".z-button").get(0))
      waitResponse(true)
      verifyTrue(jq(".z-popup:eq(0)").isVisible())
      click(jq(".z-button").get(2))
      waitResponse(true)
      verifyFalse(jq(".z-popup:eq(0)").isVisible())

      click(jq(".z-button").get(0))
      waitResponse(true)
      verifyTrue(jq(".z-popup:eq(0)").isVisible())
      click(jq(".z-textbox").get(0))
      waitResponse(true)
      verifyFalse(jq(".z-popup:eq(0)").isVisible())

      click(jq(".z-button").get(0))
      waitResponse(true)
      verifyTrue(jq(".z-popup:eq(0)").isVisible())
      click(jq(".z-div").get(0))
      waitResponse(true)
      verifyFalse(jq(".z-popup:eq(0)").isVisible())

      click(jq(".z-button").get(0))
      waitResponse(true)
      verifyTrue(jq(".z-popup:eq(0)").isVisible())
      clickAt(jq(".z-div").get(0), "10,200")
      waitResponse(true)
      verifyFalse(jq(".z-popup:eq(0)").isVisible())
    })
  }

}
