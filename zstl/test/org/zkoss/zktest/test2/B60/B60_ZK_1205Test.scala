package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-1205.zul")
class B60_ZK_1205Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<?page title="B60-ZK-1205" contentType="text/html;charset=UTF-8"?>
                  <zk>
                    <window title="Clients.showNotification() bug" border="normal" width="400px">
                      <panel title="Instruction" border="normal">
                        <panelchildren>
                          <html>
                            <p>Below is a button with autodisable set to 'self'.</p>
                            <p>Clicking on the button displays a notification message. The message should only close upon mouse click.</p>
                            <p>The message should not disappear immediately after it opened. Otherwise, it is an error.</p>
                          </html>
                        </panelchildren>
                      </panel>
                      <button label="click me" autodisable="self">
                        <attribute name="onClick">
                          <![CDATA[
        Clients.showNotification("test");
      ]]>
                        </attribute>
                      </button>
                    </window>
                  </zk>"""

    runZTL(zscript,
      () => {
        click(jq(".z-button:contains(click me)"))
        waitResponse()
        verifyTrue("should exist", jq(".z-notification").exists())
        verifyNotEquals("displays a notification message", jq(".z-notification").css("visibility"), "hidden")

        sleep(2000)
        verifyTrue("The message should not disappear immediately after it opened. Otherwise, it is an error.", jq(".z-notification").exists())

        click(jq(".z-panel"))
        waitResponse()
        sleep(2000)
        verifyTrue("The message should only close upon mouse click.", !jq(".z-notification").exists())
      })

  }
}
