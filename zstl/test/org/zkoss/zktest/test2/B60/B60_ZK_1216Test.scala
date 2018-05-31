package org.zkoss.zktest.test2.B60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B60-ZK-1216.zul")
class B60_ZK_1216Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?page title="B60-ZK-1216" contentType="text/html;charset=UTF-8"?>
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
        val btn = jq(".z-combobutton").toWidget().$n("btn")
        val real = jq(".z-combobutton").toWidget().$n("real")
        click(btn)
        waitResponse()
        click(jq(".z-button:contains(click me)"))
        waitResponse()
        verifyEquals("The label for the combo-button should change to match that for the button clicked.", jq(real).text(), "click me")

        click(btn)
        waitResponse()
        click(jq(".z-button:contains(or me)"))
        waitResponse()
        verifyEquals("The label for the combo-button should change to match that for the button clicked.", jq(real).text(), "or me")

        click(btn)
        waitResponse()
        click(jq(".z-button:contains(me too!)"))
        waitResponse()
        verifyEquals("The label for the combo-button should change to match that for the button clicked.", jq(real).text(), "me too!")
      })

  }
}
