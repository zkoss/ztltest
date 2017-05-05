/* B70_ZK_2712Test.scala

	Purpose:
		
	Description:
		
	History:
		Wed Oct 14 16:44:04 CST 2015, Created by chunfu

Copyright (C)  2015 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B70

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
 * 
 * @author chunfu
 */
@Tags(tags = "B70-ZK-2712.zul")
class B70_ZK_2712Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2712.zul

	Purpose:

	Description:

	History:
		Thu, Jun 4, 2015  10:30:29 AM, Created by Jameschu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
    <window border="normal" title="hello">
	    <label multiline="true">
	    	1. Scroll to most bottom and click on item98 to select it.
			2. Click "Switch to smaller model" button. The scrollbar should disappear and you should see "New item".
		</label>
		<zscript><![CDATA[
		DefaultTreeNode root = new DefaultTreeNode("root", new ArrayList());
		for (int i = 0; i < 99; i++) {
		    root.add(new DefaultTreeNode("item " + i));
		}
		DefaultTreeModel model = new DefaultTreeModel(root);
	    void invalidate() {
		    root.getChildren().clear();
		    root.getChildren().add(new DefaultTreeNode("New item"));
		    tree.setModel(new DefaultTreeModel(root));
		    tree.invalidate();
		}
		]]></zscript>
        <button id="btn" label="Switch to smaller model" onClick="invalidate()" />
        <vlayout height="400px" width="200px">
            <tree id="tree" model="${model}" vflex="1">
                <treecols>
                    <treecol label="Treecol" />
                </treecols>
            </tree>
        </vlayout>
    </window>
</zk>


		"""
runZTL(zscript, () => {
			var tree = jq("@tree")
			verScroll(tree, 1)
			waitResponse()
			click(jq("@treerow").last())
			waitResponse()
			click(jq("@button"))
			waitResponse()
			verifyEquals(1, jq("@treerow").length())
			verifyTrue(jq(".z-treecell-content").text().contains("New item"))
		})
	}
}
