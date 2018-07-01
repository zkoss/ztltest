/* B36_2807475Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Jun 11, 2012 11:30:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B36-2807475.zul,B,E,Window,Button")
class B36_2807475Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    val zscript =
      """
      <zk>
        When you click the menu popup then click the textbox. the textbox's focus
event should be triggered in IE.
---
        <hbox>
          <menubar id="menubar" width="200px">
            <menu>
              <menupopup>
                <menuitem label="Index"/>
              </menupopup>
            </menu>
          </menubar>
          <textbox id="demo1" onFocus='demo2.value+=1'/>
          focus count:<intbox id="demo2" value="1"/>
        </hbox>
      </zk>
    """
    runZTL(zscript, () => {
      // Click on menu popup
      click(jq("$menubar"));
      waitResponse();

      // Click textbox
      click(jq("$demo1"));
      waitResponse();

      // Verify that the popup textbox has focus
      verifyTrue("The textbox should have focus", jq("$demo1:focus").exists());

      // Verify that the value is updated
      verifyEquals("The text should be selected", "2", jq("$demo2").`val`());

    })
  }
}