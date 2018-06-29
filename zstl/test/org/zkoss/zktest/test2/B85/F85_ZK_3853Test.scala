package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Element

/* F85_ZK_3853Test.java

        Purpose:
                
        Description:
                
        History:
                Fri Jun 08 10:04:32 CST 2018, Created by klyve

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/ 
class F85_ZK_3853Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      click(dom(0, ".z-treerow", "cm"))
      waitResponse()
      click(dom(0, ".z-treerow", "open"))
      waitResponse()
      click(dom(1, ".z-treerow", "open"))
      waitResponse()
      click(dom(4, ".z-treerow", "open"))
      waitResponse()
      for (i <- 0 to 8) {
        verifyEquals("z-treerow z-treerow-selected", dom(i, ".z-treerow", "").eval("className"));
      } 
      click(dom(5,".z-treerow", "cm"))
      waitResponse()
      verifyEquals( "partial z-treerow", dom(0, ".z-treerow", "").eval("className"));
      verifyEquals( "partial z-treerow", dom(4, ".z-treerow", "").eval("className"));
      click(dom(5, ".z-treerow", "cm"))
      waitResponse()
      for (i <- 0 to 8) {
        verifyEquals("z-treerow z-treerow-selected", dom(i, ".z-treerow", "").eval("className"));
      }       
    })
  }
  
  def dom(i: Int, clsNm: String, n: String): Element= {
    if (n == null) {
      return jq(jq(clsNm).get(i)).toWidget().$n()
    }
    return jq(jq(clsNm).get(i)).toWidget().$n(n)
  }
}
