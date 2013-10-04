package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import org.zkoss.ztl.ZK

@Tags(tags = "B60-ZK-816.zul")
class B60_ZK_816Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
                    <div>1. Mouseover 'new label', you should see a tooltip 'this is tool tip'</div>
                    <div>2. Mouseover 'new label 2', you should see a tooltip 'this is tool tip 2'</div>
                    <zscript>
                      public void addLabelAndTooltip (Component comp){
                        Div container = new Div(); // dettached, imagine we DON'T have parent component at this point, e.g. macro component is being constructed
                        Popup tooltip = new Popup();
                        Label tooltiptext = new Label(" this is tool tip");
                        tooltiptext.setParent(tooltip);
                        tooltip.setParent(container);
                        Label label = new Label();
                        label.setValue(" new label");
                        label.setTooltip(tooltip); // tooltip is still dettached; anonymous UUID is used as tooltip ref
                        label.setParent(container);
                        container.setParent(comp); // everything is attached; tooltip gets normal UUID; label still uses anonymous UUID as tooltip ref

                        Popup tooltip2 = new Popup();
                        Label tooltiptext2 = new Label(" this is tool tip 2");
                        tooltiptext2.setParent(tooltip2);
                        tooltip2.setParent(comp);
                        Label l = new Label();
                        l.setValue(" new label 2");
                        l.setTooltip(tooltip2);
                        l.setParent(comp);
                      }
                    </zscript>
                    <window title="test win" border="normal" width="200px" height="200px" onCreate="addLabelAndTooltip(self);"/>
                  </zk>"""

    runZTL(zscript,
      () => {
        mouseOver(jq(".z-label:contains(new label):eq(2)"))
        waitResponse()
        sleep(2000)
        verifyEquals(jq(".z-popup:contains(this is tool tip):eq(0)").css("display"), "block")
        mouseOver(jq(".z-label:contains(new label):eq(3)"))
        waitResponse()
        sleep(2000)
        if (ZK.is("ie"))
          verifyEquals(jq(".z-popup:contains(this is tool tip):eq(0)").css("display"), "block")
        else
          verifyEquals(jq(".z-popup:contains(this is tool tip):eq(1)").css("display"), "block")
      })

  }
}
