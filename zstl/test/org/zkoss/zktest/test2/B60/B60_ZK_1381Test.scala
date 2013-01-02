package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-1381.zul")
class B60_ZK_1381Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
                    <label multiline="true">
                      Click "Show Busy" button, should not be able to edit textbox inside grid
                    </label>
                    <hbox>
                      <button id="btn1" label="Show Busy" onClick='Clients.showBusy(panel, "Busy")'/>
                      <button id="btn2" label="Clear busy" onClick="Clients.clearBusy(panel)"/>
                    </hbox>
                    <div id="div" height="75%">
                      <panel id="panel" height="100%" title="test">
                        <panelchildren>
                          <borderlayout>
                            <center>
                              <div id="divTwo">
                                <grid id="grid" fixedLayout="true" width="75%">
                                  <rows>
                                    <row>
                                      <textbox value="can't edit after click show busy"/>
                                    </row>
                                  </rows>
                                </grid>
                              </div>
                            </center>
                          </borderlayout>
                        </panelchildren>
                      </panel>
                    </div>
                  </zk>"""

    runZTL(zscript,
      () => {
        click(jq(".z-button:contains(Show Busy)"))
        waitResponse()
        verifyEquals("should not be able to edit textbox inside grid", jq(".z-apply-mask").css("display"), "block")
      })

  }
}
