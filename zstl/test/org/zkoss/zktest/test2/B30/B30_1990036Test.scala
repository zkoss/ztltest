/* B30_1990036Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Dec 10, 2011 11:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B30-1990036.zul,B,E,Window,Button")
class B30_1990036Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript =
      """
      <zk>
        <window id="w1" left="200px" top="0px" border="normal" width="550px" height="300px" sizable="true" mode="overlapped" title="Window One">
          Please Click "Window Three", then the "Window Three" window should be in front of the "Window One"
        </window>
        <window id="w2" border="normal" width="350px" height="200px" sizable="true" mode="overlapped" title="Window Two">
          <window id="w3" border="normal" width="250px" height="100px" sizable="true" mode="overlapped" title="Window Three">
            Click Me, then the window should be in front of the "Window One"
          </window>
        </window>
      </zk>
    """
    runZTL(zscript, () => {
      // 
      val w1 = jq("$w1");
      val w3 = jq("$w3");

      // Click on Window Three
      click(jq("span:contains(Click Me)"));
      waitResponse();

      // Record z-index value of both windows
      val zindex1: String = w1.css("z-index");
      val zindex3: String = w3.css("z-index");

      // The z-index of window Three should be greater than the value of Window One
      verifyTrue("The Window Three must be in front of Window One", parseInt(zindex3) > parseInt(zindex1));
    })
  }
}
