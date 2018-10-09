package org.zkoss.zktest.test2.F86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/* B86_ZK_3853Test_1.java

        Purpose:
                
        Description:
                
        History:
                Wed Sep 12 15:54:46 CST 2018, Created by klyve

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
class F86_ZK_3853_1Test extends ZTL4ScalaTestCase {

 @Test
  def test()= {
    runZTL(() => {
      click(jq(".z-treerow").eq(0))
      waitResponse()
      click(jq(".z-treerow .z-tree-icon").eq(0))
      waitResponse()
      click(jq(".z-treerow .z-tree-icon").eq(1))
      waitResponse()
      for (i <- 0 to 9) {
        verifyTrue(jq(".z-treerow").eq(i).hasClass("z-treerow-selected"))
      }
      click(jq(".z-treerow").eq(0))
      waitResponse()
      for (i <- 0 to 9) {
        verifyFalse(jq(".z-treerow").eq(i).hasClass("z-treerow-selected"))
      }
      click(jq(".z-treerow").eq(2))
      waitResponse()
      for (i <- 0 to 1) {
        verifyTrue(jq(".z-treerow").eq(i).hasClass("z-treerow-partial"))
      }
      click(jq("$ind"))
      waitResponse()
      for (i <- 0 to 9) {
         verifyFalse(jq(".z-treerow").eq(i).hasClass("z-treerow-selected"))
         verifyFalse(jq(".z-treerow").eq(i).hasClass("z-treerow-partial"))
      }
      click(jq(".z-treerow").eq(0))
      waitResponse()
      for (i <- 1 to 9) {
         verifyFalse(jq(".z-treerow").eq(i).hasClass("z-treerow-selected"))
      }
    })
  }
}
