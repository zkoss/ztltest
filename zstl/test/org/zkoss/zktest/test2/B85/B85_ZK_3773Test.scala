package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{ClientWidget, Tags}

/**
  * @author rudyhuang
  */
@Tags(tags = "B85-ZK-3773.zul")
class B85_ZK_3773Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val themes = jq("@groupbox @button")
      0 until themes.length() foreach { i => testInTheme(themes.eq(i)) }
      click(jq("$restore"))
      sleep(2000)
    })
  }

  def testInTheme(themeBtn: ClientWidget): Unit = {
    click(themeBtn)
    sleep(2000)
    waitResponse()

    waitForPageToLoad("5000")
    val msgbox = jq("@button:eq(0)")
    click(msgbox)
    waitResponse()

    val msgboxbtns = jq(".z-messagebox-button")
    val leftBtnOffsetRight = msgboxbtns.eq(0).offsetLeft() + msgboxbtns.eq(0).outerWidth(false)
    val rightBtnOffsetLeft = msgboxbtns.eq(1).offsetLeft()
    verifyTrue("The buttons must have some spaces", (rightBtnOffsetLeft - leftBtnOffsetRight) >= 3)
    verifyEquals("The buttons should be centered", "center", jq(".z-messagebox-buttons").css("text-align"))

    click(msgboxbtns.eq(0))
    waitResponse()
  }
}
