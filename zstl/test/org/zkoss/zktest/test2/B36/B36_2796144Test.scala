package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B36-2796144.zul,datebox,timebox,calendar")
class B36_2796144Test extends ZTL4ScalaTestCase {
  @Test
  def testTime1(): Unit = {
    runZTL(() => {
      val returnDate = engine.$f("returnDate")
      val dateValue2 = engine.$f("dateValue2")
      val inp = returnDate.$n("real")
      focus(inp)
      click(returnDate.$n("btn"))
      waitResponse()
      val time = jq("@timebox").find("input").`val`()
      click(jq("td.z-calendar-selected"))
      waitResponse()
      sendKeys(inp, Keys.TAB)
      waitResponse()
      verifyContains(dateValue2.get("value"), time)
    })
  }

  @Test
  def testTime2(): Unit = {
    runZTL(() => {
      val returnDate = engine.$f("returnDate")
      val dateValue2 = engine.$f("dateValue2")
      val inp = returnDate.$n("real")
      val timeInp = jq("@timebox").find("input")
      focus(inp)
      click(returnDate.$n("btn"))
      waitResponse()
      click(timeInp)
      sendKeys(timeInp, Keys.END)
      sendKeys(timeInp, Keys.DOWN)
      blur(timeInp)
      val time = timeInp.`val`()
      click(jq("td.z-calendar-selected"))
      waitResponse()
      sendKeys(inp, Keys.TAB)
      waitResponse()
      verifyContains(dateValue2.get("value"), time)
    })
  }
}
