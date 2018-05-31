package org.zkoss.zktest.test2.B60

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B60-ZK-1377.zul")
class B60_ZK_1377Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	<label multiline="true">
	1. in Chrome, edit textbox1 and tab, it should focus on textbox2 and select all of textbox2 and the window title should change to the value you edited.
	2. in IE, edit textbox1 and tab, it should focus on textbox2 and select all of textbox2 and the window title should change to the value you edited.
	</label>
	<window id="win" title="no title" border="normal">
		<vlayout>
			<label id="lb" value="no value"/>
			<textbox id="tb1" onChange='win.title = self.value' value="Title 1" />
			<textbox id="tb2" onChange='lb.value = self.value' value="Label 1" />
			<textbox id="tb3" onChange='win.title = self.value' value="Title 3" />
		</vlayout>
	</window>
</zk>
"""
    runZTL(zscript,
      () => {
        val box = jq(".z-textbox:eq(0)")
        click(box)
        waitResponse()
        box.toElement().set("value", "")
        waitResponse()
        sendKeys(box, "123")
        waitResponse()
        sendKeys(box, Keys.TAB)
        waitResponse()
        verifyTrue("the window title should change to the value you edited",
          jq(jq(".z-window-embedded").toWidget().$n("cap")).text().contains("123"))

      })

  }
}