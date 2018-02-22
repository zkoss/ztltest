package org.zkoss.zktest.test2.B80

import org.junit.Assert._
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * Created by wenninghsu on 01/11/2017.
  */
class B80_ZK_3340Test extends ZTL4ScalaTestCase {

  def test() = {
    runZTL(() => {
      val bbi = jq(".z-bandbox-input")
      click(bbi)
      waitResponse(true)
      verifyEquals("bandbox focussed:onFocus", getZKLog.trim())
      closeZKLog()

      sendKeys(bbi, "ABC")
      waitResponse(true)
      sleep(1000) // IE onChanging is slower
      verifyEquals("bandbox changing:onChanging", getZKLog.trim())
      closeZKLog()

      click(jq(".z-bandbox-button"))
      waitResponse(true)
      verifyEquals("bandbox focussed:onFocus", getZKLog.trim())
      closeZKLog()

      clickAt(jq(".z-bandpopup"), "180,10")
      waitResponse(true)
      verifyEquals("bandbox focussed:onFocus", getZKLog.trim())
      closeZKLog()

      clickAt(jq(".z-bandbox"), "300,100")
      waitResponse(true)
      verifyEquals("bandbox changed:onChange\nbandbox blurred:onBlur", getZKLog.trim())
    })
  }

}
