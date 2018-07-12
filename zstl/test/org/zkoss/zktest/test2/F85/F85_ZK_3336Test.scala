package org.zkoss.zktest.test2.F85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.{IgnoreBrowsers, Tags}

/**
  * @author rudyhuang
  */
@Tags(tags = "F85-ZK-3336.zul")
@IgnoreBrowsers("ie9")
class F85_ZK_3336Test extends ZTL4ScalaTestCase {
  @Test
  def test()=  {
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
