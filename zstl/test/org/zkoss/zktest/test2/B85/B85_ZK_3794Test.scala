package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/* B85_ZK_3794Test.java

        Purpose:
                
        Description:
                
        History:
                Tue Mar 13 10:46 AM:21 CST 2018, Created by klyve

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/ class B85_ZK_3794Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(
      () => {
        var textVal = jq(".z-textbox").`val`()
        var labelTxt = jq(".z-label:eq(1)").text().trim()
        verifyEquals(textVal, labelTxt)
      })
  }
}
