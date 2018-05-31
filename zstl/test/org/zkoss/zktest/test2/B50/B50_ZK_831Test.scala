package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B50-ZK-831.zul")
class B50_ZK_831Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
                    <window title="Spinner" border="normal">
                      1. Please type the number to the input element - "12345678910"
                      <separator/>
                      2. You should see an error message like "Out of range..."
                      <spinner id="spinner"/>
                      <button label="show" onClick='alert("" + spinner.getValue())'/>
                    </window>
                  </zk>"""

    runZTL(zscript,
      () => {
        val textbox = jq(".z-spinner").toWidget().$n("real")
        sendKeys(textbox, "12345678910")
        waitResponse()
        blur(textbox)
        waitResponse()
        verifyTrue("should see an error message", jq(".z-errorbox").exists())
      })

  }
}
