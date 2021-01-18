/* B30_1914078Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Oct 11, 2011 3:55:21 PM , Created by jumperchen
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author jumperchen
  *
  */
@Tags(tags = "B30-1914078.zul,C,E,Window,Animation")
class B30_1914078Test extends ZTL4ScalaTestCase {
  def testPosition() = {
    runZTL(() => {
      val btn = jq("@button");
      val win = jq("$win")
      val width = jq("body").width() / 2
      val height = jq("body").height() / 2
      for (_ <- 0 to 2) {
        click(btn) // show
        waitResponse(true)
        var left = win.offsetLeft()
        var top = win.offsetTop()
        verifyTrue(top > 100);
        verifyTrue(top < height);
        verifyTrue(left > 100);
        verifyTrue(left < width);
        click(btn) // hide
        waitResponse(true)
      }
    })
  }
}