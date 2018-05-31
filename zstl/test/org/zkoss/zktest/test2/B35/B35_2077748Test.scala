/* B35_2077748Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Jan 7, 2012 12:00:00 AM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B35-2077748.zul,B,E,Window,Button")
class B35_2077748Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    val zscript =
      """
      <zk>
        <div align="center"><label>
                              Use columnlayout to arrange contents in window, the window in the middle
column should be in the center of Browser window
                            </label></div>
        <columnlayout>
          <columnchildren width="50%">
            <panel>
              <panelchildren><window></window></panelchildren>
            </panel>
          </columnchildren>
          <columnchildren width="300px">
            <panel>
              <panelchildren>
                <window id="centerWindow" border="normal">
                  <div align="center">
                    <label style="font-weight:bold">
                      I am the center of browser! (That is correct!)
                    </label>
                  </div>
                </window>
              </panelchildren>
            </panel>
          </columnchildren>
          <columnchildren width="50%">
            <panel>
              <panelchildren><window></window></panelchildren>
            </panel>
          </columnchildren>
        </columnlayout>
      </zk>
    """;
    runZTL(zscript, () => {
      /*
      // Window position
      val winPos = getElementPositionLeft(jq("$centerWindow")).intValue();

      // Window with
      val winWith = jq("$centerWindow").width();

      // Browser with
      val browserWith = jq("body").width();

      // So, verify that the window is in the middle. 
      // That is: the position of the window plus the half of his size 
      // must be equal to the middle of the browser with. 
      // The acceptable error is 10 pixels
      verifyTolerant(browserWith / 2, winPos + winWith / 2, 10);*/
    })
  }
}