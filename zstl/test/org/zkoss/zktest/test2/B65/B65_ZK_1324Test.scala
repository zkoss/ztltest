package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1324.zul")
class B65_ZK_1324Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = <zk>
                    <html>
                      Testing instructions:
                      <ol>
                        <li>Click on the bandbox button to open the popup</li>
                        <li>Click on one of the buttons to give it focus</li>
                        <li>Click outside the popup to close the bandbox</li>
                        <li>Click on the bandbox button to open the popup again.</li>
                      </ol>
                      Expected result:
                      <ol>
                        <li>Bandbox input field should have focus</li>
                        <li>Buttons inside the bandbox popup should not be rendered as focused.</li>
                      </ol>
                    </html>
                    <bandbox>
                      <bandpopup width="200px" height="100px">
                        <button id="btn1" label="Button 1" mold="trendy"></button>
                        <button id="btn2" label="Button 2" mold="trendy"></button>
                      </bandpopup>
                    </bandbox>
                  </zk>

    runZTL(zscript,
      () => {
        click(jq(".z-bandbox-btn:eq(0)"))
        waitResponse(1000)
        verifyEquals("Click on the bandbox button to open the popup", jq(".z-bandbox-pp.z-bandbox-shadow").isVisible(), true)

        click(jq(".z-button:eq(0)"))
        waitResponse(1000)
        verifyEquals("Click on one of the buttons to give it focus, Bandbox input field should have focus", jq(".z-bandbox.z-bandbox-focus").isVisible(), true)

        click(jq(".z-bandbox-btn:eq(0)"))
        waitResponse(1000)
        verifyEquals("Click outside the popup to close the bandbox", !jq(".z-bandbox-pp.z-bandbox-shadow").isVisible(), true)

        click(jq(".z-bandbox-btn:eq(0)"))
        waitResponse(1000)
        verifyEquals("Click on the bandbox button to open the popup again.", jq(".z-bandbox-pp.z-bandbox-shadow").isVisible(), true)
      })

  }
}
