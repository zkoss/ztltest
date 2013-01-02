package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-1216.zul")
class B60_ZK_1216Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<?page title="B60-ZK-1216" contentType="text/html;charset=UTF-8"?>
                  <zk>
                    <window title="B60-ZK-1216" border="normal" mode="overlapped" position="center">
                      <html>
                        Please expand the combo-button below and click on one of the buttons in the popup window.<br/>
                        The label for the combo-button should change to match that for the button clicked.<br/>
                      </html>
                      <combobutton id="comboBtn" label="open me">
                        <popup>
                          <vlayout>
                            <button id="btn1" label="click me" onClick="comboBtn.label = self.label"></button>
                            <button id="btn2" label="or me" onClick="comboBtn.label = self.label"></button>
                            <button id="btn3" label="me too!" onClick="comboBtn.label = self.label"></button>
                          </vlayout>
                        </popup>
                      </combobutton>
                    </window>
                  </zk>"""

    runZTL(zscript,
      () => {
        click(jq(".z-combobutton-cr"))
        waitResponse()
        click(jq(".z-button:contains(click me)"))
        waitResponse()
        verifyEquals("The label for the combo-button should change to match that for the button clicked.", jq(".z-combobutton-cm").text(), "click me")

        click(jq(".z-combobutton-cr"))
        waitResponse()
        click(jq(".z-button:contains(or me)"))
        waitResponse()
        verifyEquals("The label for the combo-button should change to match that for the button clicked.", jq(".z-combobutton-cm").text(), "or me")

        click(jq(".z-combobutton-cr"))
        waitResponse()
        click(jq(".z-button:contains(me too!)"))
        waitResponse()
        verifyEquals("The label for the combo-button should change to match that for the button clicked.", jq(".z-combobutton-cm").text(), "me too!")
      })

  }
}
