package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B80-ZK-3111.zul")
class B80_ZK_3111Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(
      () => {
        //1. check init status
        verifyEquals(10, jq("[title]").length()) // if title attribute exists, browser will display a tooltip on hover

        //2. test collapse
        click(jq("[title=\"Collapse\"]"))
        waitResponse()
        click(jq("[title=\"Collapse\"]"))
        waitResponse()
        verifyEquals(0, jq("[title=\"Collapse\"]").length())
        verifyEquals(2, jq("[title=\"Expand\"]").length())

        //3. test maximize
        verifyEquals(4, jq("[title=\"Maximize\"]").length())
        click(jq("[title=\"Maximize\"]"))
        waitResponse()
        click(jq("[title=\"Maximize\"]"))
        waitResponse()
        click(jq("[title=\"Maximize\"]"))
        waitResponse()
        click(jq("[title=\"Maximize\"]"))
        waitResponse()
        verifyEquals(0, jq("[title=\"Maximize\"]").length())
        verifyEquals(4, jq("[title=\"Restore\"]").length())

        //4. test change locale
        click(jq(".z-textbox"))
        waitResponse()
        sendKeys(jq(".z-textbox"), "zh")
        waitResponse()
        click(jq(".z-button"))
        waitResponse()
        verifyEquals(10, jq("[title]").length())
        verifyFalse(jq(".z-error").exists())
      })
  }
}
