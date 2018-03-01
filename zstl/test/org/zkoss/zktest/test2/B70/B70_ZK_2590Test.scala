package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2590.zul")
class B70_ZK_2590Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(
    () => {
      var input = jq(".z-combobox-input")
      val oneChar = if (isSafari) Keys.NUMPAD1 else "1"
      sendKeys(input, oneChar)
      waitResponse()
      verifyEquals("1A", input.`val`())
    })
  }
}
