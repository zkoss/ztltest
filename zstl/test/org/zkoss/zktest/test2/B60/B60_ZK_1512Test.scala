package org.zkoss.zktest.test2.B60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import scala.util.control.Breaks._

@Tags(tags = "B60-ZK-1512.zul")
class B60_ZK_1512Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
                    <label multiline="true">
                      1. Click "Set Data" (setModel).
2. Click Listbox "Select All" Checkbox. No Scroll.
3. Click "Set Data".
4. Scroll to bottom, if the 51 - 100 data has checkbox selected, it is a bug.
5. Click "popup window".
6. Click "Set Data" inside popup window.
7. Click Listbox "Select All" Checkbox inside popup window.
8. Click "Set Data" again.
9. Listbox "Select All" Checkbox should work correctly.
                    </label>
                    <window id="win" apply="org.zkoss.zktest.test2.B60_ZK_1512_Composer">
                      <button id="btn1" label="Set Data"/>
                      <button id="btn2" label="Clear Data"/>
                      <button id="btn4" label="Show Select Number"/>
                      <button id="btn3" label="popup window"/>
                      <listbox id="lb" multiple="true" checkmark="true" height="500px" width="500px">
                        <custom-attributes org.zkoss.zul.listbox.rod="false"/>
                        <listhead>
                          <listheader width="30px"/>
                          <listheader label="1"/>
                          <listheader label="2"/>
                          <listheader label="3"/>
                          <listheader label="4"/>
                        </listhead>
                        <template name="model">
                          <listitem>
                            <listcell label=""/>
                            <listcell label="${each}-1"/>
                            <listcell label="${each}-2"/>
                            <listcell label="${each}-3"/>
                            <listcell label="${each}-4"/>
                          </listitem>
                        </template>
                      </listbox>
                    </window>
                  </zk>"""

    runZTL(zscript,
      () => {
        val setBtn = jq(".z-button:contains(Set Data)")
        val seldAllChk = jq(".z-listheader").find(".z-listheader-checkable")

        click(setBtn)
        waitResponse()

        click(seldAllChk)
        waitResponse()

        click(setBtn)
        waitResponse()

        jq(".z-listbox-body").toElement().set("scrollTop", 2500)
        waitResponse()

        val listitem = jq("tbody[id*=rows]").find(".z-listitem-selected")

        verifyFalse("if the 51 - 100 data has checkbox selected, it is a bug.",
          listitem.length() >= 50)

        click(jq(".z-button:contains(popup)"))
        waitResponse()

        val setBtnInWindow = jq(".z-window-modal").find(".z-button:contains(Set Data)")
        val seldAllChkInWindow = jq(".z-window-modal").find(".z-listheader").find(".z-listheader-checkable")

        click(setBtnInWindow)
        waitResponse()

        click(seldAllChkInWindow)
        waitResponse()

        click(setBtnInWindow)
        waitResponse()

        click(seldAllChkInWindow)
        waitResponse()

        val jqliInWindow = jq(".z-window-modal").find("tbody[id*=rows]").find("z-listitem")
        var allSeldInWindow = true
        for (i <- 1 to jqliInWindow.length()) {
          if (!jqliInWindow.eq(i).hasClass("z-listitem-selected")) {
            allSeldInWindow = false
            break
          }
        }
        verifyTrue("Listbox 'Select All' Checkbox should work correctly.", allSeldInWindow)
      })
  }
}
