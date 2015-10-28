package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.util.ConfigHelper

@Tags(tags = "B80-ZK-1987.zul")
class B80_ZK_1987Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B80-ZK-1987.zul

	Purpose:
		
	Description:
		
	History:
		Wed Jul 15 16:00:00 CST 2015, Created by jameschu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
<zk>
    <label multiline="true" >
        1.Click the icon of combobox (in AnnotateDataBinder), you should see the second option highlighted.
        2.Click the third option, and you should see the message : "Selected ID: Element(id=3, label=bar)"
        3.Click the second option, and you should see the message : "Selected ID: Element(id=2, label=foo)"
        4.Click the first option, and you should see the message : "Selected ID: Element(id=1, label=foo)"
        5.Click the second option, and you should see the message : "Selected ID: Element(id=2, label=foo)"
        6.Do it again in MVVM.
    </label>
    <window border="normal" title="AnnotateDataBinder">
        <panel id="main" apply="org.zkoss.zktest.test2.B80_ZK_1987">
            <panelchildren>
                <vbox>
                    <combobox id="combo" model="@{main$composer.elements}" selectedItem="@{main$composer.selectedElement}"
                              itemRenderer="${renderer}">
                    </combobox>
                    <hbox>
                        Selected ID: <label value="@{main$composer.selectedElement, load-after=combo.onSelect}"/>
                    </hbox>
                </vbox>
            </panelchildren>
        </panel>
    </window>
    <iframe src="/test2/B80-ZK-1987-1.zul" />
</zk>

""" 
  runZTL(zscript,
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