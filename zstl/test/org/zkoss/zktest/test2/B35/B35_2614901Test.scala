/* B35_2614901Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Feb 15, 2012 10:30:00 AM , Created by Fernando Selvatici
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
@Tags(tags = "B35-2614901.zul,B,E,Window,Button")
class B35_2614901Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript = """
      <zk>
        Please click on the "Project" and use the UP/Down key to navigate the menu, and it should work well (IE only)
        <menubar id="menubar" width="200px">
          <menu label="Project" image="/img/Centigrade-Widget-Icons/Briefcase-16x16.png">
            <menupopup>
              <menuitem image="/img/Centigrade-Widget-Icons/BriefcaseSpark-16x16.png" label="New" onClick="alert(self.label)"/>
              <menuitem image="/img/Centigrade-Widget-Icons/BriefcaseOpen-16x16.png" label="Open" onClick="alert(self.label)"/>
              <menuitem image="/img/Centigrade-Widget-Icons/DisketteBlack-16x16.png" label="Save" onClick="alert(self.label)"/>
              <menuseparator/>
              <menuitem label="Exit" image="/img/Centigrade-Widget-Icons/DoorOpen-16x16.png" onClick="alert(self.label)"/>
            </menupopup>
          </menu>
          <menu label="Help" image="/img/Centigrade-Widget-Icons/QuestionmarkButton-16x16.png">
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
          <menu image="/img/Centigrade-Widget-Icons/Spyglass-16x16.png">
            <menupopup>
              <menuitem label="Index" onClick="alert(self.label)"/>
            </menupopup>
          </menu>
        </menubar>
        <checkbox label="Vertical orient">
          <attribute name="onCheck">
            menubar.orient= self.checked ? "vertical" : "horizontal";
			menubar.width = self.checked ? "100px" : "200px";
          </attribute>
        </checkbox>
      </zk>

    """
runZTL(zscript, () => {
      // Click on Project menu
      click(jq(".z-menu").get(0));
      
      // Scroll up and down on the menu
      sendKeys(jq(".z-menupopup").toWidget().$n("a"), Keys.DOWN);
      waitResponse();
      
      // Scroll up and down on the menu
      sendKeys(jq(".z-menupopup").toWidget().$n("a"), Keys.DOWN);
      waitResponse();
      
      // Scroll up and down on the menu
      sendKeys(jq(".z-menupopup").toWidget().$n("a"), Keys.DOWN);
      waitResponse();
      
      // Scroll up and down on the menu
      sendKeys(jq(".z-menupopup").toWidget().$n("a"), Keys.UP);
      waitResponse();
      
      // Scroll up and down on the menu
      sendKeys(jq(".z-menupopup").toWidget().$n("a"), Keys.UP);
      waitResponse();
      
      // Verify the correct selected item
      verifyTrue("The selected item should be 'New'",(jq(".z-menuitem-hover").text().contains("New")));
      
    })
  }
}