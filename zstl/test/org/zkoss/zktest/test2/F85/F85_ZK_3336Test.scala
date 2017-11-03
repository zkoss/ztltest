package org.zkoss.zktest.test2.F85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{JQuery, Tags}

/**
  * @author rudyhuang
  */
@Tags(tags = "F85-ZK-3336.zul")
class F85_ZK_3336Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val tbeditor = jq("@tbeditor .z-tbeditor-editor")
      val textbox = jq("@textbox")

      tbeditor.toElement.set("innerHTML", "")
      `type`(tbeditor, "Hello world")
      waitResponse()
      val textboxValue = textbox.toElement.get("value")
      verifyContains("onChange should be working", textboxValue, tbeditor.text())
      verifyEquals("Widget getValue is wrong", textboxValue, tbeditor.toWidget.get("Value"))

      click(jq("@button:eq(0)"))
      waitResponse()
    })
  }
}
