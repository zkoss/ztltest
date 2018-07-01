/* B70_ZK_2764Test.scala

	Purpose:
		
	Description:
		
	History:
		Thu Oct  8 10:50:05 CST 2015, Created by chunfu

Copyright (C)  2015 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B70

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
  * @author chunfu
  */
@Tags(tags = "")
class B70_ZK_2764Test extends ZTL4ScalaTestCase {
  def testCase() = {
    runZTL(() => {
      click(jq(".z-treerow .z-tree-icon"));
      waitResponse();
      click(jq(".z-treerow .z-tree-icon").eq(1));
      waitResponse()
      var treeCells = jq(".z-treecell-text")
      var cellsString = ""
      for (i <- 0 to treeCells.length() - 1) {
        var cell = treeCells.eq(i)
        cellsString += cell.text()
      }
      verifyEquals(" node 1 (3) node 1.1 (2) node 1.1.1 (0) node 1.1.2 (1) node 2 (5) node 3 (7) node 4 (9) node 5 (11)",
        cellsString)

      click(jq("@button"))
      waitResponse()
      cellsString = ""
      for (i <- 0 to treeCells.length() - 1) {
        var cell = treeCells.eq(i)
        cellsString += cell.text()
      }
      verifyEquals(" node 1 (3). node 1.1 (2). node 1.1.1 (0). node 1.1.2 (1). node 2 (5). node 3 (7). node 4 (9). node 5 (11).",
        cellsString)

      click(jq("@button").eq(1))
      waitResponse()
      cellsString = ""
      for (i <- 0 to treeCells.length() - 1) {
        var cell = treeCells.eq(i)
        cellsString += cell.text()
      }
      verifyEquals(" node 1 (16) node 1.1 (15) node 1.1.1 (13) node 1.1.2 (14) node 2 (18) node 3 (20) node 4 (22) node 5 (24)",
        cellsString)
    })
  }
}
