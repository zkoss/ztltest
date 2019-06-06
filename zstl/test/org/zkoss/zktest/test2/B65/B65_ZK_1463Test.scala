
package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1463.zul")
class B65_ZK_1463Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<window>
                    <label multiline="true">
                      1.click open editor 1, the button Save should be enabled and click-able.
                      <!-- Bug's description (however it is disabled but click-able if the bug is not fixed)  -->
                    </label>
                    <zscript>
                      void open1(){
                        win.visible = true;
                        win.getFellow("btn").disabled = false;
                        win.title = "Update";
                      }
                      void open2(){
                        win.getFellow("btn").disabled = false;
                        win.visible = true;
                        win.title = "Update";
                      }
                      void close(){
                        win.visible = false;
                      }
                    </zscript>
                    <button label="Open Editor 1" onClick="open1()"/>
                    <button label="Open Editor 2" onClick="open2()"/>
                    <window id="win" mode="modal" width="30em" height="30ex" visible="false">
                      <vlayout vflex="1">
                        <textbox id="tb" instant="true" hflex="1" vflex="1" value="If you can click the 'Save' Button, and then it will close this window, that's correct."/>
                      </vlayout>
                      <hbox pack="end" width="100%">
                        <button id="btn" label="Save" onClick="close()" disabled="true"/>
                      </hbox>
                    </window>
                  </window>"""

    runZTL(zscript,
      () => {
        click(jq("@button:contains(1)"))
        waitResponse()

        val btn = jq("@button:contains(Save)")
        val disabled = jq(btn).attr("disabled")
        click(btn)
        waitResponse()
        val clickWork = jq("@window").isVisible()

        verifyFalse("should be enabled", disabled)
        verifyTrue("should be click-able", clickWork)
      })

  }
}