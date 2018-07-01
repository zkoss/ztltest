/* B85_ZK_3865Test.java

        Purpose:
        
        Description:
        
        History:
                Mon May 28 15:55:01 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B85_ZK_3865Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val outers = jq(".outer")
      for (i <- 0 to 4) {
        var widthToMinus = 0
        var heightToMinus = 0
        val outer = outers.eq(i)
        val inner = outer.find(".inner")
        val innerWidget = inner.toWidget
        if (i == 0 || i == 1 || i == 4) {
          widthToMinus += parseInt(inner.css("margin-left"))
          widthToMinus += parseInt(inner.css("margin-right"))
          verifyEquals(inner.width(), outer.width() - widthToMinus)
        }
        if (i == 2 || i == 3 || i == 4) {
          heightToMinus += parseInt(inner.css("margin-top"))
          heightToMinus += parseInt(inner.css("margin-bottom"))
          verifyEquals(inner.height(), outer.height() - heightToMinus)
        }
      }
    })
  }
}
