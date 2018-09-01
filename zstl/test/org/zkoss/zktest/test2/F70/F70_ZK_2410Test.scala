package org.zkoss.zktest.test2.F70

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.ZKTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "F70-ZK-2410.zul")
class F70_ZK_2410Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      val input = jq(".z-paging-input")
      click(input)
      waitResponse()
      sendKeys(jq("body"), Keys.TAB)
      waitResponse()
      keyPressEnter(jq("body"))
      waitResponse()
      verifyEquals(jq(".z-paging-input").eval("val()"), "2")
    })
  }
}