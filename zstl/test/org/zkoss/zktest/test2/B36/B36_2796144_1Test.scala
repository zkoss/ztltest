package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B36-2796144.zul,datebox,timebox,calendar")
class B36_2796144_1Test extends ZTL4ScalaTestCase {
  @Test
  def testTime2()=  {
    val zscript =
      """
        |<include src="/test2/B36-2796144.zul"/>
      """
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
      val time = timeInp.`val`()
      click(jq("td.z-calendar-selected"))
      waitResponse()
      sendKeys(inp, Keys.TAB)
      waitResponse()
      verifyContains(dateValue2.attr("value"), time)
    })
  }
}
