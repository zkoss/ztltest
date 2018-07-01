package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2285.zul")
class B70_ZK_2285Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        // unsupport opera and safari
        val items = 0 to 8 map (n => jq(".z-option:contains(\"test" + n + "\")"))
        click(items(4))
        waitResponse()
        keyPress(items(4), Keys.SHIFT + "" + Keys.ARROW_DOWN)
        waitResponse()
        keyPress(items(5), Keys.SHIFT + "" + Keys.ARROW_DOWN)
        waitResponse()
        keyPress(items(6), Keys.SHIFT + "" + Keys.ARROW_DOWN)
        waitResponse()
        keyPress(items(7), Keys.SHIFT + "" + Keys.ARROW_DOWN)
        waitResponse()

        click(jq("@button"))
        waitResponse()

        verifyTrue("4 items in listbox should be selected.", jq("$lb").toWidget().eval("_selItems.length") == "4");
      })

  }
}