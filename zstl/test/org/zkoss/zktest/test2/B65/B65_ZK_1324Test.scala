package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Element
import org.junit.Test

@Tags(tags = "B65-ZK-1324.zul")
class B65_ZK_1324Test extends ZTL4ScalaTestCase {

  @Test
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
        val bndbx = jq(".z-bandbox").toWidget()
        val btn = bndbx.$n("btn")
        val pp = bndbx.$n("pp")
        val inp = bndbx.$n("real")
        val hasBoxShadow = (inp: Element) => !"".equals(jq(inp).css("box-shadow"));
        
        click(btn)
        waitResponse()        
        verifyTrue("Bandbox input field should have focus", hasBoxShadow(inp))
        
        click(jq(".z-button:eq(0)"))
        waitResponse()
        verifyTrue("Bandbox input field should have focus", hasBoxShadow(inp))

        click(jq("ol"))
        waitResponse()
        verifyEquals("Click outside the popup to close the bandbox", !jq(pp).isVisible(), true)

        click(jq(btn))
        waitResponse()
        verifyEquals("Click on the bandbox button to open the popup again.", jq(pp).isVisible(), true)
        verifyTrue("Bandbox input field should have focus", hasBoxShadow(inp))
      })

  }
}
