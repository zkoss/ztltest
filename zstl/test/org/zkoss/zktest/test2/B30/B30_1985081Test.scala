/* B30_1985081Test.scala

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
@Tags(tags = "B30-1985081.zul,B,E,Window,Button")
class B30_1985081Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript = {
      <window title="select bug" border="normal">
        Press the button, then the "Select Me!!!" label will be selected.
        <vbox>
          <hbox id="hbox">
            <label id="lb" value="Select Me!!!"/>
          </hbox>
          <button label="press" onClick="onClick()"/>
        </vbox>
        <zscript>
          <![CDATA[
          import org.zkoss.zul.Textbox;
public void onClick(){
            Textbox tb = new Textbox();
            tb.setValue(lb.getValue());
            tb.setParent(hbox);
            lb.setVisible(false);
            tb.focus();
            tb.select();
          }
        ]]>
        </zscript>
      </window>
    }
    runZTL(zscript, () => {

      
      // Verify that the label is visible
      verifyTrue("The label Select Me!!! must be visible", jq(".z-label").isVisible());

      // Click the button
      click(jq(".z-button"));
      waitResponse();

      // Verify that the label is invisible
      verifyFalse("The label should be invisible", jq(".z-label").isVisible());

      // Verify that the textbox is visible
      verifyTrue("The textbox Select Me!!! must be visible", jq(".z-textbox").isVisible());

    })
  }
}