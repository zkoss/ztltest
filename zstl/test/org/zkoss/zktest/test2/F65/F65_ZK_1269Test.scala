package org.zkoss.zktest.test2.F65

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase

class F65_ZK_1269Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        // orient
        click(jq(".z-button:contains(change orient):eq(0)"))
        waitResponse()
        click(jq(".z-button:contains(next):eq(0)"))
        waitResponse()
        sleep(500)
        verifyTrue("should show component 10.", jq(".z-cardlayout-inner:contains(10)").css("top") == "0px")

        click(jq(".z-button:contains(previous):eq(0)"))
        waitResponse()
        sleep(500)

        // append child
        val selectedInp = jq(".z-hlayout:contains(Go)").find(".z-intbox")
        val insertInp = jq(".z-hlayout:contains(insert)").find(".z-intbox")
        val removeInp = jq(".z-hlayout:contains(Remove)").find(".z-intbox")
        val go = jq(".z-button:contains(Go)")
        val add = jq(".z-button:contains(Add)")
        val remove = jq(".z-button:contains(Remove)")
        val show = jq(".z-button:contains(show selected index)")
        val confirm = jq(".z-messagebox-window .z-button:eq(0)")

        val removeThen = (nth: String, result: String) => {
          sendKeys(removeInp, nth)
          waitResponse(true)
          blur(removeInp)
          waitResponse(true)

          click(remove)
          waitResponse(true)
          sleep(1000)
          verifyTrue("should show component " + result + ".", jq(".z-cardlayout-inner:contains(" + result + ")").css("top") == "0px")

          // restore removeInp
          sendKeys(removeInp, Keys.END + "" + Keys.BACK_SPACE + Keys.BACK_SPACE + Keys.BACK_SPACE)
          waitResponse(true)
          blur(removeInp)
          waitResponse(true)
        }

        val showThen = (result: String) => {
          click(show)
          waitResponse(true)
          verifyTrue("should show selected index " + result + ".", jq(".z-messagebox-window .z-label").text() == result)

          // confirm
          click(confirm)
          waitResponse(true)
        }

        val selectThen = (nth: String, result: String) => {
          sendKeys(selectedInp, nth)
          waitResponse(true)
          blur(selectedInp)
          waitResponse(true)

          click(go)
          waitResponse(true)
          sleep(1000)
          verifyTrue("should show component " + result + ".", jq(".z-cardlayout-inner:contains(" + result + ")").css("top") == "0px")

          // restore selectedInp
          sendKeys(selectedInp, Keys.END + "" + Keys.BACK_SPACE + Keys.BACK_SPACE + Keys.BACK_SPACE)
          waitResponse(true)
          blur(selectedInp)
          waitResponse(true)
        }

        verifyTrue("should show component 9.", jq(".z-cardlayout-inner:contains(9)").css("top") == "0px")
        click(jq(".z-button:contains(append component):eq(0)"))
        waitResponse(true)

        selectThen("11", "11")

        selectThen("9", "9")

        sendKeys(insertInp, "9")
        click(add)
        waitResponse(true)

        showThen("10")

        // restore
        removeThen("12", "9")
        removeThen("9", "10")
        selectThen("9", "9")

        // remove child 
        removeThen("2", "10")

        showThen("9")

        removeThen("9", "9")

        showThen("8")

        selectThen("2", "3")

        removeThen("7", "3")

        selectThen("7", "9")

        selectThen("0", "0")

        removeThen("0", "1")

        selectThen("6", "9")

        removeThen("5", "9")

        showThen("5")

      })

  }
}