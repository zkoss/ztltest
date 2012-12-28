package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-1101.zul")
class B60_ZK_1101Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
                    Please click the addChild 2~3 times, you should see 2,1,0 in order, not 0, 1, 2.
                    <zscript>
                      Panel newPanel(){
                        Panel p = new Panel();
                        Panelchildren pc = new Panelchildren();
                        p.appendChild(pc);
                        pc.appendChild(new Label(ptc.getChildren().size() + ""));
                        return p;

                      }
                    </zscript>
                    <portallayout id="p">
                      <portalchildren id="ptc">
                      </portalchildren>
                    </portallayout>
                    <button label="addChild" onClick='p.setPanel(newPanel(), 0, 0)'/>
                  </zk>"""

    runZTL(zscript,
      () => {
        1 to 3 foreach { it =>
          click(jq(".z-button:contains(addChild)"))
          waitResponse()
        }
        
        verifyEquals("should see 2,1,0 in order, not 0, 1, 2.", jq(".z-panel .z-label").text(), "210")
      })

  }
}
