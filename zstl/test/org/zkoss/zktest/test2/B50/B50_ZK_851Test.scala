package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B50-ZK-851.zul")
class B50_ZK_851Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        click(jq(".z-button:contains(open)"))
        waitResponse()
        val textbox = jq(".z-textbox")
        sendKeys(textbox, "abc")
        waitResponse()
        blur(textbox)
        waitResponse()
        val text = textbox.`val`()
        click(jq(".z-window-embedded:contains(Hello)").toWidget().$n("cave"))
        waitResponse()
        click(jq(".z-button:contains(display)"))
        waitResponse()
        verifyEquals("the value should changed", jq(".z-messagebox-window .z-label").text(), text)
      })

  }
}
