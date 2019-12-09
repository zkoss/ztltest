/* B50_3285714Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Oct 13 18:59:08 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 3285714
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3285714.zul,A,E,Grid,ROD")
class B50_3285714Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        val grid = jq("@grid")
        verScroll(grid, 100)
        sleep(1000)
        verScroll(grid, 50)
        sleep(1000)
        val row5k = jq("@row:contains(Row 5000)")
        verifyTrue(row5k.positionTop() > 0)
        verifyTrue(row5k.positionTop() < grid.innerHeight())
      }
    )
  }
}