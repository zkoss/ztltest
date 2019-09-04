package org.zkoss.zktest.test2.B60

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-815.zul")
class B60_ZK_815Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        for (index <- 0 to 2) {
          val listbox = jq(".z-listbox:eq(" + index + ")")
          val focusA = listbox.find(".z-focus-a")
          val item = listbox.find(".z-listitem:contains(Item 0)")
          click(item)
          waitResponse()
          sendKeys(focusA, Keys.PAGE_DOWN)
          waitResponse()
          val msg = jq(".z-vlayout:eq(" + index + ") .z-label:contains(onSelect)")
          if (index != 2) {
            verifyEquals(msg.text(), "onSelect: Listbox " + (index + 1) + ": [Item 12]")
          } else {
            verifyTrue(msg.exists())
          }
          val txt = msg.text()
          for (i <- 1 to 12) {
            sendKeys(focusA, Keys.DOWN)
          }
          waitResponse()
          if (index != 2) {
            verifyEquals(msg.text(), "onSelect: Listbox " + (index + 1) + ": [Item 24]")
          } else {
            verifyNotEquals(msg.text(), txt)
          }
        }
      })
  }
}
