package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1480.zul")
class B65_ZK_1480Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """
                  <zk>
                    <zscript><![CDATA[
		import java.util.ArrayList;
		import org.zkoss.zul.DefaultTreeModel;
		import org.zkoss.zul.DefaultTreeNode;
		
		ArrayList children = new ArrayList();
		children.add(new DefaultTreeNode("Child1"));
		children.add(new DefaultTreeNode("Child2"));
		DefaultTreeNode root = new DefaultTreeNode("Root", children);
		DefaultTreeModel model = new DefaultTreeModel(root);
		void remove() {
			root.remove(1);
		}
	]]></zscript>
                    <window title="title" border="normal">
                      Click "Remove Child2" button directly without open the Bandbox, should not see JS error message.<separator/>
                      <bandbox id="bd" mold="rounded">
                        <bandpopup>
                          <tree id="tree" width="300px" model="${model}"/>
                        </bandpopup>
                      </bandbox>
                      <button id="removeChild2" label="Remove Child2" onClick="remove()"/>
                    </window>
                  </zk>"""

    runZTL(zscript,
      () => {
        click(jq("@button"))
        waitResponse()
        verifyTrue("should not see any error message.", !jq(".z-errorbox").exists())
      })

  }
}
