package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.openqa.selenium.Keys

@Tags(tags = "B60-ZK-1182.zul")
class B60_ZK_1182Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
                    Please type some words in the textbox and blur it, you should see a dialog with "org.zkoss.zk.ui.event.StubEvent:onStub"
                    <textbox stubonly="true" onChange='alert(event.getClass().getName()+":"+event.getName())'/>
                  </zk>"""

    runZTL(zscript,
      () => {
        val textbox = jq(".z-textbox")
        focus(textbox)
        waitResponse()
        sendKeys(textbox, "123")
        waitResponse()
        blur(textbox)
        waitResponse()
        verifyEquals("should see a dialog with 'org.zkoss.zk.ui.event.StubEvent:onStub'", jq(".z-messagebox-window .z-label").text(), "org.zkoss.zk.ui.event.StubEvent:onStub")
      })

  }
}
