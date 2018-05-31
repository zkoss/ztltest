package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B80-ZK-1987.zul")
class B80_ZK_1987Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        //open the combobox
        click(jq(".z-combobox-button"))
        waitResponse()
        //check that 2nd item should be selected by default
        verifyTrue(jq(".z-comboitem").eq(1).hasClass("z-comboitem-selected"))
        //select the 3rd option
        click(jq(".z-comboitem").eq(2))
        waitResponse()
        //check the message is showing "Selected ID: Element(id=3, label=bar)"
        verifyEquals("Element(id=3, label=bar)", jq(".z-window.z-window-embedded .z-label").eq(1).text())
        //open the combobox and select the 2nd option
        click(jq(".z-combobox-button"))
        waitResponse()
        click(jq(".z-comboitem").eq(1))
        waitResponse()
        //check the message is showing "Selected ID: Element(id=2, label=foo)"
        verifyEquals("Element(id=2, label=foo)", jq(".z-window.z-window-embedded .z-label").eq(1).text())
        //open the combobox and select the 1st option
        click(jq(".z-combobox-button"))
        waitResponse()
        click(jq(".z-comboitem").eq(0))
        waitResponse()
        //check the message is showing "Selected ID: Element(id=1, label=foo)"
        verifyEquals("Element(id=1, label=foo)", jq(".z-window.z-window-embedded .z-label").eq(1).text())
        //open the combobox and select the 2nd option
        click(jq(".z-combobox-button"))
        waitResponse()
        click(jq(".z-comboitem").eq(1))
        waitResponse()
        //check the message is showing "Selected ID: Element(id=3, label=bar)"
        verifyEquals("Element(id=2, label=foo)", jq(".z-window.z-window-embedded .z-label").eq(1).text())
        //*******************************
        //repeat the same thing in iframe
        //*******************************
        //open the combobox
        executeScript("""$("iframe").contents().find(".z-combobox-button")[0].click()""")
        waitResponse()
        //check that 2nd item should be selected by default
        verifyEquals("true", getEval("""$("iframe").contents().find(".z-comboitem").eq(1).hasClass("z-comboitem-selected")"""))
        //select the 3rd option
        executeScript("""$("iframe").contents().find(".z-comboitem").eq(2).click()""")
        waitResponse()
        //check the message is showing "Selected ID: Element(id=3, label=bar)"
        verifyEquals("Element(id=3, label=bar)", getEval("""$("iframe").contents().find(".z-window.z-window-embedded .z-label").eq(1).text()"""))
        //open the combobox and select the 2nd option
        executeScript("""$("iframe").contents().find(".z-combobox-button")[0].click()""")
        waitResponse()
        executeScript("""$("iframe").contents().find(".z-comboitem").eq(1).click()""")
        waitResponse()
        //check the message is showing "Selected ID: Element(id=2, label=foo)"
        verifyEquals("Element(id=2, label=foo)", getEval("""$("iframe").contents().find(".z-window.z-window-embedded .z-label").eq(1).text()"""))
        //open the combobox and select the 1st option
        executeScript("""$("iframe").contents().find(".z-combobox-button")[0].click()""")
        waitResponse()
        executeScript("""$("iframe").contents().find(".z-comboitem").eq(0).click()""")
        waitResponse()
        //check the message is showing "Selected ID: Element(id=1, label=foo)"
        verifyEquals("Element(id=1, label=foo)", getEval("""$("iframe").contents().find(".z-window.z-window-embedded .z-label").eq(1).text()"""))
        //open the combobox and select the 2nd option
        executeScript("""$("iframe").contents().find(".z-combobox-button")[0].click()""")
        waitResponse()
        executeScript("""$("iframe").contents().find(".z-comboitem").eq(1).click()""")
        waitResponse()
        //check the message is showing "Selected ID: Element(id=3, label=bar)"
        verifyEquals("Element(id=2, label=foo)", getEval("""$("iframe").contents().find(".z-window.z-window-embedded .z-label").eq(1).text()"""))
      })
  }
}