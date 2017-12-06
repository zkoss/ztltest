package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{ClientWidget, Tags}

@Tags(tags = "B65-ZK-1324.zul")
class B65_ZK_1324Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
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
"""
    runZTL(zscript,
      () => {
        val bndbx = jq(".z-bandbox").toWidget()
        val btn = bndbx.$n("btn")
        val pp = bndbx.$n("pp")
        val inp = bndbx.$n("real")
        val hasFocus = (inp: ClientWidget) => jq(inp).is(":focus")
        val ppBtn1 = jq(".z-button:eq(0)")
        
        click(btn)
        waitResponse()        
        verifyTrue("Bandbox input field should have focus", hasFocus(inp))
        
        click(ppBtn1)
        waitResponse()
        verifyTrue("Button1 should have focus", hasFocus(ppBtn1))

        click(jq("body"))
        waitResponse()
        verifyFalse("Click outside the popup to close the bandbox", jq(pp).isVisible)

        click(btn)
        waitResponse()
        verifyTrue("Click on the bandbox button to open the popup again.", jq(pp).isVisible)
        verifyTrue("Bandbox input field should have focus", hasFocus(inp))
        verifyFalse("Button1 should not have focus", hasFocus(ppBtn1))
      })

  }
}
