/* B35_2094363Test.scala

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
@Tags(tags = "B35-2094363.zul,B,E,Window,Button")
class B35_2094363Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript = {
      <zk>
        <html>
          <![CDATA[  
IE,
<br/>
Keep on click "Help" button, make sure that the menupopup won't grow or it
is wrong.
]]>
        </html>
        <window title="Menu Demo" border="normal">
          <menubar id="menubar">
            <menu label="Help">
              <menupopup>
                <menuitem label="Index" onClick="alert(self.label)"/>
                <menu label="About">
                  <menupopup>
                    <menuitem label="About ZK" onClick="alert(self.label)"/>
                    <menuitem label="About Potix" onClick="alert(self.label)"/>
                  </menupopup>
                </menu>
              </menupopup>
            </menu>
          </menubar>
        </window>
      </zk>
    }
    runZTL(zscript, () => {
      // Click on menu button
      click(jq(".z-menu-btn"));
      waitResponse();

      // Record menu popup size
      val popupSizeBefore = jq(".z-menu-popup").width();
      
      // Click again on menu button to close it
      click(jq(".z-menu-btn"));
      waitResponse();

      // Click again on menu button to seee the size
      click(jq(".z-menu-btn"));
      waitResponse();

      // Record menu popup size
      val popupSizeAfter = jq(".z-menu-popup").width();
      
      // Verify that the size is equal than before
      verifyTrue("The size should be equal than before", popupSizeBefore==popupSizeAfter);
      
    })
  }
}