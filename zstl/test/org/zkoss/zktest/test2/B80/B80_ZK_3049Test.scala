package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B80-ZK-3049.zul")
class B80_ZK_3049Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(
      () => {
        val cb = jq("@combobox")
        verifyEquals(1, cb.length)
        focus(cb.find(".z-combobox-input"))
        waitResponse(true)
        val cb_btn = cb.toWidget.$n("btn")
        click(cb_btn)
        waitResponse(true)
        verifyNotEquals("none", jq(".z-combobox-popup").css("display"))
        clickAt(cb_btn, "10,10") // FIXME: Firefox strange workaround for not losing focus
        waitResponse(true)
        verifyEquals("none", jq(".z-combobox-popup").css("display"))
        click(cb_btn)
        waitResponse(true)
        verifyNotEquals("none", jq(".z-combobox-popup").css("display"))
      })
  }
}

