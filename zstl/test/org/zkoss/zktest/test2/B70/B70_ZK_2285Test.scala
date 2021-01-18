package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.{IgnoreBrowsers, Tags}

@Tags(tags = "B70-ZK-2285.zul")
@IgnoreBrowsers("ios,android")
class B70_ZK_2285Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        // unsupport opera and safari
        click(jq(".z-option:contains(test4)"))
        waitResponse()
        sendKeys(jq(".z-option:contains(test4)"), Keys.SHIFT + "" + Keys.ARROW_DOWN)
        waitResponse()
        sendKeys(jq(".z-option:contains(test5)"), Keys.SHIFT + "" + Keys.ARROW_DOWN)
        waitResponse()
        sendKeys(jq(".z-option:contains(test6)"), Keys.SHIFT + "" + Keys.ARROW_DOWN)
        waitResponse()
        sendKeys(jq(".z-option:contains(test7)"), Keys.SHIFT + "" + Keys.ARROW_DOWN)
        waitResponse()

        click(jq("@button"))
        waitResponse()

        verifyTrue("4 items in listbox should be selected.", jq("$lb").toWidget().eval("_selItems.length") == "4");
      })

  }
}