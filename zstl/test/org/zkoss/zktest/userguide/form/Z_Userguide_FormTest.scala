package org.zkoss.zktest.userguide.form

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.util.ColorVerifingHelper

@Tags(tags = "Z-Userguide-Form.zul,Textbox,Intbox,Form,Spinner,ie9")
class Z_Userguide_FormTest extends ZTL4ScalaTestCase {
  @Test
  def testForm(): Unit = {
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

      /** datebox (it may fail on different browser language)*/
      //				if(!ZK.is("chrome") && !ZK.is("opera")) {
      //				click(jq("$db").toWidget.$n("btn"));
      //				click(jq("@calendar").find("td:eq(23)"));
      //				vardbinp = jq("$db").toWidget.$n("real");
      //				dbinp.toElement.set("value", "");
      //				sendKeys(dbinp, "Jun 10, 2010");
      //				waitResponse();
      //				verifyEquals("Jun 10, 2010", getValue(jq("$db").toWidget.$n("real")));
      //				click(jq("@select"));
      //				waitResponse();
      //				select(jq("@select"), "yyyy/MM/dd hh:mm a");
      //				waitResponse();
      //				String dateTimeStr = getValue(dbinp);
      //				String datePattern = "[1-9][0-9][0-9][0-9]/((0[1-9])|(1[0-2]))/(([1-9])|(1[0-9])|(2[0-9])|(3[0-1]))" +
      //				" ((0[1-9])|(1[0-2])):((0[0-9])|(1[0-9])|(2[0-9])|(3[0-9])|(4[0-9])|(5[0-9])) ((A|P)M)";
      //				waitResponse();
      //				verifyTrue("Date time: " + dateTimeStr, dateTimeStr.matches(datePattern));
      //				select(jq("@select"), "yyyy/MM/dd");
      //				waitResponse();
      //				verifyContains(getValue(jq("$db").toWidget.$n("real")), "2010/06/10");
      //				select(jq("@select"), "MM-dd-yy");
      //				waitResponse();
      //				verifyEquals("06-10-10", getValue(jq("$db").toWidget.$n("real")));
      //				}
      /** constraint */
      val txt4 = jq("$view").find("@textbox:eq(4)")
      txt4.toElement.set("value", "")
      sendKeys(txt4, "zk")
      waitResponse()
      blur(txt4)
      verifyTrue(jq(".z-errorbox").text().contains("Please enter an e-mail address"))
      sendKeys(txt4, "zk@zkoss.org")
      blur(txt4)
      focus(jq("$intro"))
      waitResponse()
      sleep(500)
      verifyFalse(jq(".z-errorbox").exists())

      /** spinner */
      click(jq(".z-spinner").toWidget.$n("btn-up"))
      waitResponse()
      verifyTrue(3 < jq(jq("@spinner").toWidget.$n("real")).`val`().toInt)
      clickAt(jq("@spinner").toWidget.$n("btn-down"), "5,5")
      waitResponse()
      verifyTrue(4 >= jq(jq("@spinner").toWidget.$n("real")).`val`().toInt)

      /** colorbox */
      click(jq("@colorbox").toWidget.$n("currcolor"))
      click(jq(".z-colorpalette-color:eq(56)"))
      click(jq("@colorbox").toWidget.$n("currcolor"))
      click(jq(".z-colorbox").toWidget.$n("picker-btn"))
      waitResponse()
      val r = getValue(jq(".z-colorpicker").toWidget.$n("r-inp"))
      val g = getValue(jq(".z-colorpicker").toWidget.$n("g-inp"))
      val b = getValue(jq(".z-colorpicker").toWidget.$n("b-inp"))
      val currColor = jq("@colorbox").toWidget.$n("currcolor").get("style.backgroundColor")
      verifyTrue(ColorVerifingHelper.isEqualColor(s"rgb($r,$g,$b)", currColor))
    })
  }
}
