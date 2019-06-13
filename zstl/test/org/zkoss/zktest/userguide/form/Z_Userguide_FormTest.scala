package org.zkoss.zktest.userguide.form

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.util.ColorVerifingHelper

@Tags(tags = "Z-Userguide-Form.zul,Textbox,Intbox,Form,Spinner,ie9")
class Z_Userguide_FormTest extends ZTL4ScalaTestCase {
  @Test
  def testForm()=  {
    runZTL(() => {
      // first time to access this page will take a long time.
      waitResponse()

      val txt0 = jq("$view").find("@textbox:eq(0)")
      txt0.toElement.set("value", "")
      sendKeys(txt0, "Jumper")
      waitResponse()
      verifyEquals("Jumper", getValue(txt0))

      val txt1 = jq("$view").find("@textbox:eq(1)")
      txt1.toElement.set("value", "")
      sendKeys(txt1, "1234")
      waitResponse()
      verifyEquals("1234", getValue(txt1))

      val txt2 = jq("$view").find("@textbox:eq(2)")
      txt2.toElement.set("value", "")
      sendKeys(txt2, "1234")
      waitResponse()
      verifyEquals("1234", getValue(txt2))

      val int0 = jq("$view").find("@intbox:eq(0)")
      int0.toElement.set("value", "")
      sendKeys(int0, "1234")
      waitResponse()
      verifyEquals("1234", getValue(int0))

      val int1 = jq("$view").find("@intbox:eq(1)")
      int1.toElement.set("value", "")
      sendKeys(int1, "12345")
      waitResponse()
      verifyEquals("12345", getValue(int1))

      val decimalbox = jq("@decimalbox")
      decimalbox.toElement.set("value", "")
      sendKeys(decimalbox, "12.345")
      waitResponse()
      blur(decimalbox)
      verifyEquals("12.34", getValue(jq("@decimalbox")))

      /** constraint */
      val txt4 = jq("$view").find("@textbox:eq(4)")
      txt4.toElement.set("value", "")
      sendKeys(txt4, "zk")
      waitResponse()
      blur(txt4)
      verifyContains(jq(".z-errorbox").text(), "Please enter an e-mail address")
      sendKeys(txt4, "zk@zkoss.org")
      blur(txt4)
      focus(jq("$intro"))
      waitResponse()
      sleep(500)
      verifyFalse(jq(".z-errorbox").exists())

      /** spinner */
      click(jq(".z-spinner").toWidget.$n("btn-up"))
      waitResponse()
      verifyTrue(3 < parseInt(jq(jq("@spinner").toWidget.$n("real")).`val`()))
      clickAt(jq("@spinner").toWidget.$n("btn-down"), "5,5")
      waitResponse()
      verifyTrue(4 >= parseInt(jq(jq("@spinner").toWidget.$n("real")).`val`()))

      /** colorbox */
      click(jq("@colorbox").toWidget.$n("currcolor"))
      click(jq(".z-colorpalette-color:eq(56)"))
      click(jq("@colorbox").toWidget.$n("currcolor"))
      click(jq(".z-colorbox").toWidget.$n("picker-btn"))
      waitResponse()
      val currColor = jq("@colorbox").toWidget.$n("currcolor").attr("style.backgroundColor")
      verifyEqualColor(jq("@colorbox").toWidget.attr("value"), currColor)
    })
  }
}
