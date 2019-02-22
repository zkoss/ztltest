/* B86_ZK_4213Test.java

		Purpose:

		Description:

		History:
				Thu Feb 21 10:19:54 CST 2019, Created by charlesqiu

Copyright (C) 2019 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B86_ZK_4213Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      verifyWidth()
      windowResizeTo(800, 800)
      waitResponse()
      verifyWidth()
      verScroll(jq(".z-grid"), 100)
      waitResponse()
      verifyWidth()
    })
  }

  def verifyWidth(): Unit = {
    val columns = jq(".z-columns").children()
    var columnsWidth = columns.eq(0).outerWidth() + columns.eq(1).outerWidth() + columns.eq(2).outerWidth() + columns.eq(3).outerWidth()
    verifyTolerant(columnsWidth, jq(".z-grid").outerWidth(), 2)
  }
}