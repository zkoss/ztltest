package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2024.zul")
class B70_ZK_2024Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(
      () => {
        val inp = jq(".z-combobox").toWidget().$n("real")
        sendKeys(inp, "se" + Keys.TAB)
        waitResponse()

        verifyEquals("the value should show 'SE'.",
          inp.attr("value"), "SE")
        verifyTrue("the label should show 'Sverige'",
          jq(".z-label:contains(Sverige)").exists)
      })

  }
}