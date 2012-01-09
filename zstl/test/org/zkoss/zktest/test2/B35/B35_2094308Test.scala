/* B35_2094308Test.scala

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

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.openqa.selenium.Keys

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B35-2094308.zul,B,E,Window,Button")
class B35_2094308Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript = {
      <zk xmlns:n="http://www.zkoss.org/2005/zk/native">
        <window border="none" style="border:1px solid black;">
          <vbox>
            <label value="Set the top and left values for window 2 and click save, you
shouldn't see any errors."/>
          </vbox>
          <hbox>
            Top :
            <intbox id="top"/>
            Left:
            <intbox id="left"/>
            <button id="save" label="save" onClick='win2.top = top.value + "px";win2.left =
left.value + "px";'/>
          </hbox>
          <window id="win2" border="normal" width="450px" top="50px" height="200px" style="overflow:visible;" mode="overlapped" left="50px" title="InnerWindow- top=50px, left=50px- position=parent" position="parent" onMove='msg.value = "Inner: " + event.top + "," + event.left;'>
            <window id="win3" border="normal" mode="overlapped" width="300px" top="50px" onMove='msg1.value = "Nexted: " + event.top + "," + event.left;' left="50px" title="NestedWindow-pos=parent" position="parent">
              <button label="embed NestedWindow" onClick="win3.doEmbedded()"/>
            </window>
          </window>
        </window>
      </zk>
    }
    runZTL(zscript, () => {
      // Set the top value
      engine.$f("top").set("value", "200");

      // Set the left value
      engine.$f("left").set("value", "300");

      // Click on save button
      click(engine.$f("save"));
      waitResponse();

      // Verify there is no javascript error
      verifyFalse(jq(".z-error").exists());

      // Force an error because the click on sabe button doesn' do the expected work
      verifyFalse(true);
    })
  }
}