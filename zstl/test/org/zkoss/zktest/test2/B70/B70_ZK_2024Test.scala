package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2024.zul")
class B70_ZK_2024Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(
      () => {
        val inp = jq(".z-combobox").toWidget().$n("real")
        sendKeys(inp, "se" + Keys.TAB)
        waitResponse()

        verifyTrue("the label should show 'Sverige' and the value should show 'SE'.",
          inp.get("value") == "SE" && jq(".z-label:contains(Sverige)").exists)
      })

  }
}