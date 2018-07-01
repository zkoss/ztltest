/* B70_ZK_2673Test.scala

	Purpose:
		
	Description:
		
	History:
		Fri Oct 16 14:43:49 CST 2015, Created by chunfu

Copyright (C)  2015 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  *
  * @author chunfu
  */
@Tags(tags = "B70-ZK-2673.zul")
class B70_ZK_2673Test extends ZTL4ScalaTestCase {
  @Test
  def testCase() = {
    runZTL(() => {
      var nav = jq(".z-nav-content")
      mouseOver(nav)
      waitResponse(true)
      var navpp = jq(".z-nav-popup .z-nav-content")
      click(navpp.eq(0))
      waitResponse(true)
      click(navpp.eq(1))
      waitResponse(true)
      var origWidth = jq(".z-nav-popup").width();
      click(navpp.eq(2))
      waitResponse(true)
      verifyNotEquals(origWidth, jq(".z-nav-popup").width())
      verifyTrue(jq(".z-nav-popup").width() > origWidth)
      println(origWidth, jq(".z-nav-popup").width())
    })
  }
}
