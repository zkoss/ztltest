
package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.ZKClientTestCase
import org.zkoss.ztl.ZKTestCase

@Tags(tags = "B65-ZK-1454.zul")
class B65_ZK_1454Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = <vlayout>
                    <html>
                      <p>Testing instructions:</p>
                      <ol>
                        <li>Expand the tree nodes until the scrollbar appears.</li>
                        <li>Scroll down</li>
                        <li>Switch to Tab 2</li>
                        <li>Switch back to Tab 1</li>
                      </ol>
                      <p>The scrollbar should be at the previous position. Otherwise, it is a bug</p>
                    </html>
                    <tabbox width="400px" height="400px">
                      <tabs>
                        <tab label="Tab 1" closable="true"/>
                        <tab label="Tab 2" closable="true"/>
                      </tabs>
                      <tabpanels>
                        <tabpanel style="position: relative; overflow: auto;">
                          <zscript>
                            import org.zkoss.zktest.test2.BigList;
			    import org.zkoss.zktest.test2.tree.BinaryTreeModel;
			    import java.util.ArrayList;
				BinaryTreeModel btm = new BinaryTreeModel(new ArrayList(new BigList(1000)));
                          </zscript>
                          <tree id="tree" model="${btm}"/>
                        </tabpanel>
                        <tabpanel>Close this panel</tabpanel>
                      </tabpanels>
                    </tabbox>
                  </vlayout>

    runZTL(zscript,
      () => {
        click(jq(".z-treecell-cnt:contains(1):eq(0)").find(".z-tree-ico"))
        waitResponse()
        click(jq(".z-treecell-cnt:contains(3):eq(0)").find(".z-tree-ico"))
        waitResponse()
        click(jq(".z-treecell-cnt:contains(7):eq(0)").find(".z-tree-ico"))
        waitResponse()
        click(jq(".z-treecell-cnt:contains(15):eq(0)").find(".z-tree-ico"))
        waitResponse()
        click(jq(".z-treecell-cnt:contains(31):eq(0)").find(".z-tree-ico"))
        waitResponse()
        click(jq(".z-treecell-cnt:contains(63):eq(0)").find(".z-tree-ico"))
        waitResponse()
        click(jq(".z-treecell-cnt:contains(127):eq(0)").find(".z-tree-ico"))
        waitResponse()
        click(jq(".z-treecell-cnt:contains(255):eq(0)").find(".z-tree-ico"))
        waitResponse()

        jq(".z-tabpanel").toElement().set("scrollTop", 28)
        click(jq(".z-tab-hl:contains(2)"))
        waitResponse()
        click(jq(".z-tab-hl:contains(1)"))
        waitResponse()
        verifyEquals("The scrollbar should be at the previous position", jq(".z-tabpanel").scrollTop(), 28)
      })

  }
}