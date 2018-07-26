package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.Element

@Tags(tags = "B65-ZK-1117.zul")
class B65_ZK_1117Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<window title="My First Window" border="normal">
        <label multiline="true">
          1.click button, you should get alert : spinner value is null
2.change the spinner value to 1,then click button, you should get alert : spinner value is 1
3.clear the spinner value to empty,then click button, you should get alert : spinner value is null
4. please check the behavior with double spinner, the result should be the same
        </label>
        <spinner id="s"/>
        <button label="click1" onClick='alert("spinner value "+s.getValue())'/>
        <doublespinner id="sd"/>
        <button label="click2" onClick='alert("doublespinner value "+sd.getValue())'/>
      </window>"""

    runZTL(zscript,
      () => {
        spinnerTest("click1", jq(".z-spinner").toWidget().$n("btn-up"), jq(".z-spinner").toWidget().$n("real"));
        spinnerTest("click2", jq(".z-doublespinner").toWidget().$n("btn-up"), jq(".z-doublespinner").toWidget().$n("real"));
      })
    def spinnerTest(clickTxt: String, upperbtn: Element, snpinerinp: Element) {
      // click button, you should get the spinner error message.
      val clickbtn = jq(".z-button:contains(" + clickTxt + ")")
      click(clickbtn)
      waitResponse()
      verifyTrue("Should show a alert box",
        jq(".z-messagebox-window").isVisible())
      click(jq(".z-messagebox-window .z-button"))
      waitResponse()

      // change the spinner value to 1,then click button, you should get alert : spinner value is 1
      click(jq(upperbtn))
      waitResponse()
      blur(snpinerinp)
      waitResponse()
      click(clickbtn)
      waitResponse()
      verifyTrue("Should show a alert box",
        jq(".z-messagebox-window").isVisible())
      click(jq(".z-messagebox-window .z-button"))

      waitResponse()
      // clear the spinner value to empty,then click button, you should get the spinner error messag.
      focus(snpinerinp)

      waitResponse()
      sendKeys(snpinerinp, Keys.END + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE)

      waitResponse()
      verifyEquals(snpinerinp.attr("value"), "")
      waitResponse()
      click(clickbtn)
      waitResponse()
      verifyTrue("Should show a alert box",
        jq(".z-messagebox-window").isVisible())
      click(jq(".z-messagebox-window .z-button"))
      waitResponse()
    }

  }
}
