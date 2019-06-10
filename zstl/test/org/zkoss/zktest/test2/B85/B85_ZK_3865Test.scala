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
  def test()=  {
    runZTL(() => {
      val outers = jq(".outer")
      //0
      var outer = outers.eq(0)
      var inner = outer.find(".inner")
      var widthToMinus = parseInt(inner.css("margin-left")) + parseInt(inner.css("margin-right"))
      verifyEquals(inner.outerWidth(), outer.innerWidth() - widthToMinus)

      //1
      outer = outers.eq(1)
      inner = outer.find(".inner")
      widthToMinus = parseInt(inner.css("margin-left")) + parseInt(inner.css("margin-right"))
      verifyEquals(inner.outerWidth(), outer.innerWidth() - widthToMinus)

      //2
      outer = outers.eq(2)
      inner = outer.find(".inner")
      var heightToMinus = parseInt(inner.css("margin-top")) + parseInt(inner.css("margin-bottom"))
      verifyEquals(inner.outerHeight(), outer.innerHeight() - heightToMinus)

      //3
      outer = outers.eq(3)
      inner = outer.find(".inner")
      heightToMinus = parseInt(inner.css("margin-top")) + parseInt(inner.css("margin-bottom"))
      verifyEquals(inner.outerHeight(), outer.innerHeight() - heightToMinus)

      //4
      outer = outers.eq(4)
      inner = outer.find(".inner")
      widthToMinus = parseInt(inner.css("margin-left")) + parseInt(inner.css("margin-right"))
      heightToMinus = parseInt(inner.css("margin-top")) + parseInt(inner.css("margin-bottom"))
      verifyEquals(inner.width(), outer.width() - widthToMinus)
      verifyEquals(inner.outerHeight(), outer.innerHeight() - heightToMinus)
    })
  }
}
