package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-761-1.zul")
class B60_ZK_761_1Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
                    <window>
                      Please click the reset button, and then you should not see any exception dialog.
                      <zscript>
                        org.zkoss.zul.ListModelList model = new org.zkoss.zul.ListModelList();
 model.add("A");
 model.add("B");
 model.add("C");
 model.add("D");
                      </zscript>
                      <grid id="grid" width="300px" model="${model}">
                        <template name="model">
                          <row>
                            <label value="${each}"/>
                          </row>
                        </template>
                      </grid>
                      <button label="reset" onClick="grid.setModel(model)"/>
                    </window>
                  </zk>"""

    runZTL(zscript,
      () => {
        click(jq("@button"))
        waitResponse()
        verifyTrue("you should not see any exception dialog", !jq(".z-window-modal").exists())
      })

  }
}
