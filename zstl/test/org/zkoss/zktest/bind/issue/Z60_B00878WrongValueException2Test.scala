/* 

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.ClientWidget
import org.openqa.selenium.Keys

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00878WrongValueException2Test extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = {
      <include src="/bind/issue/B00878WrongValueException2.zul"/>
    }

    runZTL(zul, () => {

      var focus = jq("@button")
      var l = jq("$l1")
      var inp = jq("$inp1")
      //bandbox
      verifyEquals("", l.toWidget().get("value"))

      `type`(inp.toWidget().$n("real"), "A")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("A", l.toWidget().get("value"))
      var errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

      `type`(inp.toWidget().$n("real"), "")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("A", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(1, errorPopup.length())

      `type`(inp.toWidget().$n("real"), "B")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("B", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

      //combobox
      l = jq("$l2")
      inp = jq("$inp2")
      verifyEquals("", l.toWidget().get("value"))

      `type`(inp.toWidget().$n("real"), "C")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("C", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

      `type`(inp.toWidget().$n("real"), "")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("C", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(1, errorPopup.length())

      `type`(inp.toWidget().$n("real"), "D")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("D", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

      //textbox
      l = jq("$l10")
      inp = jq("$inp10")
      verifyEquals("", l.toWidget().get("value"))

      `type`(inp.toWidget(), "E")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("E", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

      `type`(inp.toWidget(), "")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("E", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(1, errorPopup.length())

      `type`(inp.toWidget(), "F")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("F", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

      //decimalbox
      l = jq("$l4")
      inp = jq("$inp4")
      verifyEquals("", l.toWidget().get("value"))

      `type`(inp.toWidget(), "1")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("1.0", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

      `type`(inp.toWidget(), "-1")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("1.0", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(1, errorPopup.length())

      `type`(inp.toWidget(), "2")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("2.0", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

      //doublebox
      l = jq("$l5")
      inp = jq("$inp5")
      verifyEquals("", l.toWidget().get("value"))

      `type`(inp.toWidget(), "3")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("3.0", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

      `type`(inp.toWidget(), "-3")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("3.0", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(1, errorPopup.length())

      `type`(inp.toWidget(), "4")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("4.0", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

      //doublespinner
      l = jq("$l6")
      inp = jq("$inp6")
      verifyEquals("", l.toWidget().get("value"))

      `type`(inp.toWidget().$n("real"), "5")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("5.0", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

      `type`(inp.toWidget().$n("real"), "-5")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("5.0", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(1, errorPopup.length())

      `type`(inp.toWidget().$n("real"), "6")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("6.0", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

      //intbox
      l = jq("$l7")
      inp = jq("$inp7")
      verifyEquals("", l.toWidget().get("value"))

      `type`(inp.toWidget(), "7")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("7", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

      `type`(inp.toWidget(), "-7")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("7", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(1, errorPopup.length())

      `type`(inp.toWidget(), "8")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("8", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

      //longbox
      l = jq("$l8")
      inp = jq("$inp8")
      verifyEquals("", l.toWidget().get("value"))

      `type`(inp.toWidget(), "9")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("9", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

      `type`(inp.toWidget(), "-9")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("9", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(1, errorPopup.length())

      `type`(inp.toWidget(), "10")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("10", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

      //spinner
      l = jq("$l9")
      inp = jq("$inp9")
      verifyEquals("", l.toWidget().get("value"))

      `type`(inp.toWidget().$n("real"), "11")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("11", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

      `type`(inp.toWidget().$n("real"), "-11")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("11", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(1, errorPopup.length())

      `type`(inp.toWidget().$n("real"), "12")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("12", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

      //datebox
      l = jq("$l3")
      inp = jq("$inp3")
      verifyEquals("", l.toWidget().get("value"))

      `type`(inp.toWidget().$n("real"), "20120223")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("20120223", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

      `type`(inp.toWidget().$n("real"), "20110101")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("20120223", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(1, errorPopup.length())

      `type`(inp.toWidget().$n("real"), "20120320")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("20120320", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

      //timebox
      l = jq("$l11")
      inp = jq("$inp11")
      verifyEquals("", l.toWidget().get("value"))
      inp.toWidget().$n("real").eval("focus()")
      sendKeys(inp.toWidget().$n("real"), Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE)
      sendKeys(inp.toWidget().$n("real"), "13:00")
      blur(inp.toWidget().$n("real"))
      waitResponse()
      //		`type`(inp.toWidget().$n("real"), "13:00")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("13:00", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

      inp.toWidget().$n("real").eval("focus()")
      sendKeys(inp.toWidget().$n("real"), Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE)
      sendKeys(inp.toWidget().$n("real"), "10:00")
      blur(inp.toWidget().$n("real"))
      waitResponse()
      //		`type`(inp.toWidget().$n("real"), "10:00")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("13:00", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(1, errorPopup.length())

      inp.toWidget().$n("real").eval("focus()")
      sendKeys(inp.toWidget().$n("real"), Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE)
      sendKeys(inp.toWidget().$n("real"), "14:02")
      blur(inp.toWidget().$n("real"))
      waitResponse()
      //		`type`(inp.toWidget().$n("real"), "14:02")
      waitResponse()
      click(focus.toWidget())
      waitResponse()
      verifyEquals("14:02", l.toWidget().get("value"))
      errorPopup = jq(".z-errorbox")
      verifyEquals(0, errorPopup.length())

    })
  }
}

