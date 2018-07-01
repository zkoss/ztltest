package org.zkoss.zktest.test2.B60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-1176.zul")
class B60_ZK_1176Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?page title="B60-ZK-1176" contentType="text/html;charset=UTF-8"?>
                  <zk>
                    <window title="B60-ZK-1176" border="normal" width="500px" apply="org.zkoss.zktest.test2.B60_ZK_1176_TestComposer">
                      <panel title="Instruction" border="normal">
                        <panelchildren>
                          <html>
                            <p>
                              You should see 2 buttons and 2 toolbarbuttons, all with "autodisable" property specified to
          automatically disable every buttons onClick. Normally, the disabled buttons will be re-enabled 
          onResponse. In certain use case, the "autodisable" may need to be canceled during onClick when
          certain conditions are met. Naturally, one would call setDisabled(true) when this need arises.
          However, this would not work in ZK 6.01.
                            </p>
                            <p>
                              Please click on buttons that would call setDisabled(true) in onClick(). Those buttons should
          stay disabled after onClick() finishes. Other buttons should behave the same as before.
                            </p>
                            <p>Test cases:</p>
                            <ol>
                              <li>Button #1: setDisabled(true) in onClick()</li>
                              <li>Button #2: no setDisabled(true in onClick()</li>
                              <li>Toolbarbutton #1: setDisabled(true) in onClick()</li>
                              <li>Toolbarbutton #1: no setDisabled(true) in onClick()</li>
                            </ol>
                          </html>
                        </panelchildren>
                      </panel>
                      <separator/>
                      <hbox>
                        <button id="btn1" label="Button #1" autodisable="self,btn2,tbBtn1,tbBtn2"/>
                        <button id="btn2" label="Button #2" autodisable="self,btn1,tbBtn1,tbBtn2"/>
                      </hbox>
                      <toolbar mold="panel">
                        <toolbarbutton id="tbBtn1" mold="toggle" label="Toolbarbutton #1" autodisable="self,btn1,btn2,tbBtn2"/>
                        <toolbarbutton id="tbBtn2" mold="toggle" label="Toolbarbutton #2" autodisable="self,btn1,btn2,tbBtn1"/>
                      </toolbar>
                    </window>
                  </zk>"""

    runZTL(zscript,
      () => {
        val btn1 = jq(".z-button:contains(Button #1)")
        val btn2 = jq(".z-button:contains(Button #2)")

        verifyEquals("should see 2 buttons", jq(".z-button").length(), 2)
        verifyEquals("should see 2 toolbarbuttons", jq(".z-toolbarbutton").length(), 2)
        click(btn1)
        waitResponse()
        verifyTrue(btn1.is("[disabled]"))

        click(btn2)
        waitResponse()
        verifyTrue(!btn2.is("[disabled]"))

        val toolbarbtn1 = jq(".z-toolbarbutton:contains(Toolbarbutton #1)")
        val toolbarbtn2 = jq(".z-toolbarbutton:contains(Toolbarbutton #2)")

        click(toolbarbtn1)
        waitResponse()
        verifyTrue(toolbarbtn1.is("[disabled=disabled]"))

        click(toolbarbtn2)
        waitResponse()
        verifyTrue(!toolbarbtn2.is("[disabled=disabled]"))

      })

  }
}
