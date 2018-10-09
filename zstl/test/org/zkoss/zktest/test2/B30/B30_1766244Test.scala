/* B30_1766244Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1766244Test extends ZTL4ScalaTestCase {
  @Test
  def testScrolling() = {
    val ztl$engine = engine()
    val grid = ztl$engine.$f("grid")
    val cb = ztl$engine.$f("cb")
    runZTL(() => {
      var offset1x = zk(cb).eval("revisedOffset()[0]")
      var offset1y = zk(cb).eval("revisedOffset()[1]")
      var offset2x = zk(cb.$n("btn")).eval("revisedOffset()[0]")
      var offset2y = zk(cb.$n("btn")).eval("revisedOffset()[1]")

      grid.$n("body").eval("scrollTop = 20")
      var offset3x = zk(cb).eval("revisedOffset()[0]")
      var offset3y = zk(cb).eval("revisedOffset()[1]")
      var offset4x = zk(cb.$n("btn")).eval("revisedOffset()[0]")
      var offset4y = zk(cb.$n("btn")).eval("revisedOffset()[1]")
      verifyEquals(offset1x, offset3x)
      verifyEquals(offset2x, offset4x)
      verifyEquals(parseInt(offset1y) - 20, offset3y)
      verifyEquals(parseInt(offset2y) - 20, offset4y)
      grid.$n("body").eval("scrollTop = 0")
      offset3x = zk(cb).eval("revisedOffset()[0]")
      offset3y = zk(cb).eval("revisedOffset()[1]")
      offset4x = zk(cb.$n("btn")).eval("revisedOffset()[0]")
      offset4y = zk(cb.$n("btn")).eval("revisedOffset()[1]")
      verifyEquals(offset1x, offset3x)
      verifyEquals(offset1y, offset3y)
      verifyEquals(offset2x, offset4x)
      verifyEquals(offset2y, offset4y)
    })
  }
}



