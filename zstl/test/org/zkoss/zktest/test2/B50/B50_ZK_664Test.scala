package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers
import org.zkoss.ztl.unit.JQuery

/**
  * @author leonlee
  */
@IgnoreBrowsers("chrome,ff,safari,edge")
class B50_ZK_664Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      testFlow(jq("@textbox").eq(0), jq("@button").eq(0), jq("@button").eq(1))
      checkCount("5")

      testFlow(jq("@textbox").eq(3), jq("@button").eq(2), jq("@button").eq(3))
      checkCount("9")

      testFlow(jq("@textbox").eq(4), jq("@button").eq(4), jq("@button").eq(5))
      checkCount("13")

      testFlow(jq("@textbox").eq(7), jq("@button").eq(6), jq("@button").eq(7))
      checkCount("17")
    })
  }

  def testFlow(textbox:JQuery, btnLogin:JQuery, btnReset:JQuery): Unit = {
    click(textbox)
    waitResponse()
    sendKeys(textbox.find("input"), Keys.ENTER)
    waitResponse()
    sleep(800)

    click(textbox)
    waitResponse()
    sendKeys(textbox.find("input"), Keys.TAB)
    waitResponse()
    sendKeys(btnLogin, Keys.ENTER)
    waitResponse()
    sleep(800)

    click(textbox)
    waitResponse()
    sendKeys(textbox.find("input"), Keys.TAB)
    waitResponse()
    sendKeys(btnLogin, Keys.SPACE)
    waitResponse()
    sleep(800)

    click(btnLogin)
    waitResponse()
    sleep(800)

    click(textbox)
    waitResponse()
    `type`(textbox.toWidget, "abcd")
    waitResponse()
    click(btnReset)
    waitResponse()
    verifyEquals("", textbox.find("input").text())
  }

  def checkCount(expect:String): Unit = {
    verifyEquals(expect, getEval("$(\"iframe\").contents().find(\".test1\").eq(0).text()"))
  }
}
