/* B70_ZK_2764_1Test.scala

	Purpose:
		
	Description:
		
	History:
		Thu Oct  8 11:36:27 CST 2015, Created by chunfu

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
@Tags(tags = "")
class B70_ZK_2764_1Test extends ZTL4ScalaTestCase {
  def testCase() = {
    val zscript =
      """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2764-1.zul

	Purpose:

	Description:

	History:
		Tue Jun  4 10:06:56 CST 2015, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
1. Please open the tree nodes "node 1" and "node 2"
<separator/>
2. click the button "update data", the tree structure should be the same as before, only node 1 and its children change content
<separator/>
3. click the button "rebuild model", the tree structure should be the same as before, only all the content are updated

	<div apply="org.zkoss.zktest.test2.B70_ZK_2764_1">
		<tree id="dyntree" width="400px"/>
		<button id="updateButton" label="update data"/>
		<button id="rebuildButton" label="rebuild model"/>
	</div>
</zk>

"""
    runZTL(zscript, () => {
      click(jq(".z-treerow .z-tree-icon"));
      waitResponse();
      click(jq(".z-treerow .z-tree-icon").eq(1));
      waitResponse()
      click(jq(".z-treerow .z-tree-icon").eq(4));
      waitResponse()
      verifyEquals(" node 1 (3) node 1.1 (2) node 1.1.1 (0) node 1.1.2 (1) node 2 (5) node 2.1 (4) node 3 (7) node 4 (9) node 5 (11)",
        jq(".z-treecell-text").text())

      click(jq("@button"))
      waitResponse()
      verifyEquals(" node 1 (3). node 1.1 (2). node 1.1.1 (0). node 1.1.2 (1). node 2 (5) node 2.1 (4) node 3 (7) node 4 (9) node 5 (11)",
        jq(".z-treecell-text").text())

      click(jq("@button").eq(1))
      waitResponse()
      verifyEquals(" node 1 (16) node 1.1 (15) node 1.1.1 (13) node 1.1.2 (14) node 2 (18) node 2.1 (17) node 3 (20) node 4 (22) node 5 (24)",
        jq(".z-treecell-text").text())
    })
  }
}
