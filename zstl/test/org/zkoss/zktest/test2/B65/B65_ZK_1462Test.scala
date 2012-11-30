
package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.util.control.Breaks._
import org.zkoss.ztl.JQuery
import org.zkoss.ztl.ZK
/**
 * there is some diff with origin zul: add width for panel, 
 * or ie will click in wrong position cuz width is not enough 
 * 
 */
@Tags(tags = "B65-ZK-1462.zul")
class B65_ZK_1462Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = <zk>
                    <label>
                      Wait around 1 seconds, should see two panels showed and they are draggable and droppable.
                    </label>
                    <portallayout id="myptl" maximizedMode="whole">
                      <portalchildren renderdefer="1000">
                        <panel id="paneltables" border="normal" title="test" width="200px" height="352px" collapsible="true" maximizable="true" style="margin-bottom:10px">
                          <panelchildren>
                            <hlayout height="100%">
                              <label>Panel 1</label>
                            </hlayout>
                          </panelchildren>
                        </panel>
                      </portalchildren>
                      <portalchildren>
                        <panel border="normal" title="test" width="200px" height="352px" collapsible="true" maximizable="true" style="margin-bottom:10px" renderdefer="1000">
                          <panelchildren>
                            <hlayout height="100%">
                              <label>Panel 2</label>
                            </hlayout>
                          </panelchildren>
                        </panel>
                      </portalchildren>
                    </portallayout>
                  </zk>

    runZTL(zscript,
      () => {
        sleep(2000)
        val panel1 = jq("@panel:contains(1) .z-panel-header")
        val panel2 = jq("@panel:contains(2) .z-panel-header")
        val areShowed = panel1.isVisible() && panel2.isVisible()
        verifyTrue("should see two panels showed ", areShowed)

        val movex = panel1.positionLeft() - panel2.positionLeft()

        if (isIE) {
          dragdropTo(panel2, "0,0", movex + ",0")
        } else
          dragdropToObject(panel2, panel2, "0,0", movex + ",0")

        val parent2 = panel2.parents(".z-portalchildren")
        val pc2 = jq(".z-portalchildren:eq(0)")
        verifyEquals("should be draggable and droppable", parent2.html, pc2.html)

        val movey = jq("@panel:contains(2) .z-panel-header").positionTop() - jq("@panel:contains(1) .z-panel-header").positionTop()

        if (isIE) {
          dragdropTo(panel1, "0,0", "0," + movey)
        } else
          dragdropToObject(panel1, panel1, "0,0", "0," + movey)

        val parent1 = panel1.parents(".z-portalchildren")
        val pc1 = jq(".z-portalchildren:eq(0)")
        verifyEquals("should be draggable and droppable", parent1.html, pc1.html)

      })

  }
}
