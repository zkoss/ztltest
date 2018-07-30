package org.zkoss.zktest.test2.B86

import org.junit.{Assert, Test}
import org.zkoss.zstl.ZTL4ScalaTestCase

/* B86_ZK_3879Test.java

        Purpose:
                
        Description:
                
        History:
                Mon Jul 30 15:46:12 CST 2018, Created by klyve

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/ class B86_ZK_3879Test extends ZTL4ScalaTestCase {

  @Test
  def test()= {
    runZTL(() => {
      val listboxHeight = jq("@listbox").height
      val pageSize = jq("@paging").toWidget.eval("_pageSize").toInt
      val pageCount = jq("@paging").toWidget.eval("_pageCount").toInt
      val totalSize = jq("@paging").toWidget.eval("_totalSize").toInt
      click(jq("$pagingId").find(".z-paging-last"))
      waitResponse()
      val lastRow = jq("@listbox").toWidget.eval("_nrows").toInt
      verifyTolerant(318, listboxHeight, 1)
      verifyEquals(totalSize, pageSize * (pageCount - 1) + lastRow)
    })
  }
}
