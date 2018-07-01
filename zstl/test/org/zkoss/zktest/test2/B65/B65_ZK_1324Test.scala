package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.unit.ClientWidget

@Tags(tags = "B65-ZK-1324.zul")
class B65_ZK_1324Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
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
