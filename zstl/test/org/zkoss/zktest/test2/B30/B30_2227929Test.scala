/* B30_2227929Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Dec 1, 2011 05:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Widget
import org.zkoss.ztl.Element
import org.zkoss.ztl.ZK
import org.zkoss.ztl.util.Scripts

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B30-2227929.zul,B,E,Window,Button")
class B30_2227929Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript = {
      <window border="normal">
        Click
        <button label="Create">
          <attribute name="onClick"><![CDATA[
	newc = execution.createComponents("/test2/B30-2227929_inc.zul", null);
		]]></attribute>
        </button>
        and you shall see nothing happen.
	Then click<button label="Attach" onClick="newc[0].setParent(self.parent)"/>
        and you shall see a group of components are appended
      </window>
    }
    runZTL(zscript, () => {
      // Click on first button
      click(jq("@button").get(0));
      waitResponse();

      // Verify that the components aren't visible
      verifyFalse("The window with header \"Created Dynamically\" should not be visible", jq(jq(".z-window-embedded").toWidget().$n("cave")).find(":contains(Created Dynamically)").exists());

      // Verify that the textbox value isn't as expected later
      verifyFalse("", jq("@textbox").attr("value").equals("2227929"));
      
      // Click on "Attach" button
      click(jq("@button").get(1));
      waitResponse();
    
      // Verify that the components are visible
      verifyTrue("The window with header \"Created Dynamically\" should be visible", jq(jq(".z-window-embedded").toWidget().$n("cave")).find(":contains(Created Dynamically)").exists());

      // Verify that the textbox value is as expected 
      verifyTrue("", jq("@textbox").attr("value").equals("2227929"));

    })
  }
}