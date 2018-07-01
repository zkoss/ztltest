/* B70_ZK_2764_2Test.scala

	Purpose:
		
	Description:
		
	History:
		Thu Oct  8 11:36:34 CST 2015, Created by chunfu

Copyright (C)  2015 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B70

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags;

/**
  *
  * @author chunfu
  */
@Tags(tags = "")
class B70_ZK_2764_2Test extends ZTL4ScalaTestCase {
  def testCase() = {
    val zscript =
      """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2764-2.zul

	Purpose:

	Description:

	History:
		Tue Jun  4 10:06:56 CST 2015, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
1. Please open the tree node "node 1" and "node 1.1" to display the node "node 1.1.1"
<separator/>
2. click the button "update data (Post Order)", the tree structure should be the same as before, only content of node1 and its children are updated
<separator/>
3. click the button "update data (Pre Order)", the tree structure should be the same as before, only content of node1 and its children are updated
	<div apply="org.zkoss.zktest.test2.B70_ZK_2764_2">
		<tree id="dyntree" width="400px">
			<treecols>
				<treecol></treecol>
			</treecols>
		</tree>
		<button id="updateButton" label="update data (Pre Order)"/>
		<button id="updateButtonReverse" label="update data (Post Order)"/>
		<button id="rebuildButton" label="rebuild model"/>
	</div>
</zk>

  """
    runZTL(zscript, () => {
      click(jq(".z-treerow .z-tree-icon"));
      waitResponse();
      click(jq(".z-treerow .z-tree-icon").eq(1));
      waitResponse()
      verifyEquals(" node 1 (4) node 1.1 (2) node 1.1.1 (0) node 1.1.2 (1) node 1.2 (3) node 2 (6) node 3 (8) node 4 (10) node 5 (12)",
        jq(".z-treecell-text").text())

      click(jq("@button"))
      waitResponse()
      verifyEquals(" node 1 (4). node 1.1 (2). node 1.1.1 (0). node 1.1.2 (1). node 1.2 (3). node 2 (6) node 3 (8) node 4 (10) node 5 (12)",
        jq(".z-treecell-text").text())

      click(jq("@button").eq(1))
      waitResponse()
      verifyEquals(" node 1 (4).. node 1.1 (2).. node 1.1.1 (0).. node 1.1.2 (1).. node 1.2 (3).. node 2 (6) node 3 (8) node 4 (10) node 5 (12)",
        jq(".z-treecell-text").text())

    })
  }
}
