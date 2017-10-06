/* B70_ZK_2764_3Test.scala

	Purpose:
		
	Description:
		
	History:
		Thu Oct  8 11:36:43 CST 2015, Created by chunfu

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
@Tags(tags = "B70-ZK-2764-3")
class B70_ZK_2764_3Test extends ZTL4ScalaTestCase {
	def testCase() = {
		runZTL(() => {
			click(jq(".z-treerow .z-tree-icon").eq(2));
			waitResponse();
			click(jq(".z-treerow .z-tree-icon").eq(4));
			waitResponse()
			click(jq(".z-treerow .z-tree-icon").eq(3));
			waitResponse()
			click(jq(".z-treerow .z-tree-icon").eq(0));
			waitResponse()
			click(jq(".z-treerow .z-tree-icon").eq(2));
			waitResponse()
			click(jq(".z-treerow .z-tree-icon").eq(1));
			waitResponse()
			var origTreeCells = jq(".z-treecell-text");
			var origList: List[String] = List();
			for (i <- 0 to origTreeCells.length()) {
				origList = origList :+ origTreeCells.eq(i).text()
			}
			verifyEquals(" node 1 (6) node 1.1 (2) node 1.1.1 (0) node 1.1.2 (1) node 1.2 (5) node 1.1.1 (3) node 1.1.2 (4) node 2 (10) node 3 (17) node 3.1 (13) node 3.1.1 (11) node 3.1.2 (12) node 3.2 (16) node 3.2.1 (14) node 3.2.2 (15) node 4 (21) node 5 (25)",
				jq(".z-treecell-text").text())

			click(jq("@button"))
			waitResponse()
			verifyEquals(" node 1 (6). node 1.1 (2). node 1.1.1 (0). node 1.1.2 (1). node 1.2 (5). node 1.1.1 (3). node 1.1.2 (4). node 2 (10) node 3 (17) node 3.1 (13) node 3.1.1 (11) node 3.1.2 (12) node 3.2 (16) node 3.2.1 (14) node 3.2.2 (15) node 4 (21) node 5 (25)",
				jq(".z-treecell-text").text())

			click(jq("@button").eq(1))
			waitResponse()
			verifyEquals(" node 1 (6).. node 1.1 (2).. node 1.1.1 (0).. node 1.1.2 (1).. node 1.2 (5).. node 1.1.1 (3).. node 1.1.2 (4).. node 2 (10) node 3 (17) node 3.1 (13) node 3.1.1 (11) node 3.1.2 (12) node 3.2 (16) node 3.2.1 (14) node 3.2.2 (15) node 4 (21) node 5 (25)",
				jq(".z-treecell-text").text())
			click(jq("@button").eq(2))
			waitResponse()
			var treeCells = jq(".z-treecell-text");
			for (i <- 0 to treeCells.length()) {
				var treeCell = treeCells.eq(i);
				println("print treecelltext: " + treeCell.text() + ", " + origList(i))
				verifyTrue(treeCell.text().contains(origList(i)))
			}
		})
	}
}
