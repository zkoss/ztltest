package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.ZKTestCase

class B80_ZK_3008Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(
      () => {
        val cb = jq(".z-combobox")
        val inp = cb.find(".z-combobox-input")
        sendKeys(inp, "ge")
        waitResponse()
        val pp = jq(".z-combobox-popup")
        println(cb.toString() + ">>> " + ZKTestCase.getCurrent.getEval(cb.toString() + ".offset()"))
        verifyTolerant(cb.offsetTop(), pp.outerHeight() + pp.offsetTop(), 3)
        sendKeys(inp, Keys.BACK_SPACE)
        waitResponse()
        sendKeys(inp, Keys.BACK_SPACE)
        waitResponse()
        verifyTolerant(cb.offsetTop(), pp.outerHeight() + pp.offsetTop(), 3)
      })
  }
}

