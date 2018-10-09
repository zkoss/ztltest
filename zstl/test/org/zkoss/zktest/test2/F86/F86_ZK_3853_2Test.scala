package org.zkoss.zktest.test2.F86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/* F86_ZK_3853_2_Test.java

        Purpose:
                
        Description:
                
        History:
                Wed Sep 12 16:17:04 CST 2018, Created by klyve

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/ class F86_ZK_3853_2Test extends ZTL4ScalaTestCase {

 @Test
  def test()= {
    runZTL(() => {
      click(jq(".z-treerow").eq(1).toWidget.$n("cm"))
      waitResponse()
      verifyFalse(jq(".z-treerow").eq(0).hasClass("z-treerow-selected"))
      for (i <- 1 to 5) {
        verifyTrue(jq(".z-treerow").eq(i).hasClass("z-treerow-selected"))
      }
      verifyFalse(jq(".z-treerow").eq(6).hasClass("z-treerow-selected"))
      waitResponse()
      click(jq(".z-treerow").eq(2).toWidget.$n("cm"))
      waitResponse()
      for (i <- 0 to 4) {
        verifyFalse(jq(".z-treerow").eq(i).toWidget().eval("parent.isSelected()"))
      }
      verifyTrue(jq(".z-treerow").eq(5).toWidget().eval("parent.isSelected()"))
      verifyFalse(jq(".z-treerow").eq(6).toWidget().eval("parent.isSelected()"))
      verifyTrue(jq(".z-treerow").eq(1).hasClass("z-treerow-partial"))

      click(jq("$ind"))
      waitResponse()
      for (i <- 0 to 6) {
         verifyFalse(jq(".z-treerow").eq(i).toWidget().eval("parent.isSelected()"))
         verifyFalse(jq(".z-treerow").eq(i).hasClass("z-treerow-partial"))
      }
      click(jq(".z-treerow").eq(0).toWidget.$n("cm"))
      waitResponse()
      for (i <- 1 to 6) {
         verifyFalse(jq(".z-treerow").eq(i).toWidget().eval("parent.isSelected()"))
         verifyFalse(jq(".z-treerow").eq(i).hasClass("z-treerow-partial"))
      }
    })
  }
}
