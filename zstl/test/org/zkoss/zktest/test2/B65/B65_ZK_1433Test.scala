
package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1433.zul")
class B65_ZK_1433Test extends ZTL4ScalaTestCase {

  def testClick() = {
   runZTL(() => {
        click(jq("@button"))
        waitResponse()
        sleep(1000)
        val window0 = jq(".z-window-overlapped:eq(0)")
        val window1 = jq(".z-window-overlapped:eq(1)")
        val window2 = jq(".z-window-overlapped:eq(2)")
        val window0Combobox0 = window0.find(".z-combobox:eq(0)")
        val window0Combobox1 = window0.find(".z-combobox:eq(1)")
        val window1Combobox0 = window1.find(".z-combobox:eq(0)")
        val window1Combobox1 = window1.find(".z-combobox:eq(1)")
        val window2Combobox0 = window2.find(".z-combobox:eq(0)")
        val window2Combobox1 = window2.find(".z-combobox:eq(1)")
        verifyTrue("window should be there", window2.exists())

        verifyEquals("combobox width in third window is equal to other window.", window2Combobox0.width(), window0Combobox0.width())
        verifyEquals("combobox width in third window is equal to other window.", window2Combobox0.width(), window1Combobox0.width())
        verifyEquals("combobox width in third window is equal to other window.", window2Combobox1.width(), window0Combobox1.width())
        verifyEquals("combobox width in third window is equal to other window.", window2Combobox1.width(), window1Combobox1.width())
      })

  }
}