package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B85-ZK-3897.zul")
class B85_ZK_3897Test extends ZTL4ScalaTestCase {
  @Test
  def test()=  {
    runZTL(() => {
      for (i <- 0 to 2) {
        click(jq("@button:eq(" + i + ")"))
        waitResponse()
        // 1899/12/31 23:59:59 and 2100/01/01 00:00:00 are not allowed
        testKeyboardSelectRange("1900/01/01 23:59:59", "2099/12/31 00:00:00")
      }
    })
  }

  def testKeyboardSelectRange(expectMin: String, expectMax: String)=  {
    val btn = jq("@datebox a.z-datebox-button")
    val real = jq("@datebox .z-datebox-input")
    click(jq("@button:contains(Near Min)"))
    waitResponse()
    click(btn)
    waitResponse()
    click(real)
    waitResponse()
    sendKeys(real, Keys.ARROW_LEFT)
    waitResponse()
    sendKeys(real, Keys.ARROW_LEFT)
    waitResponse()
    click(jq(".z-calendar-selected"))
    waitResponse()
    verifyEquals(expectMin, real.`val`())

    click(jq("@button:contains(Near Max)"))
    waitResponse()
    click(btn)
    waitResponse()
    click(real)
    sendKeys(real, Keys.ARROW_RIGHT)
    waitResponse()
    sendKeys(real, Keys.ARROW_RIGHT)
    waitResponse()
    click(jq(".z-calendar-selected"))
    waitResponse()
    verifyEquals(expectMax, real.`val`())
  }
}
