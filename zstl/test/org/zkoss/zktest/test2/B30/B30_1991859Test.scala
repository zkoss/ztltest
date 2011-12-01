/* B30_1991859Test.scala

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

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B30-1991859.zul,B,E,Window,Button")
class B30_1991859Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript = {
      <window id="test" title="test" border="normal" height="100%">
        Please click the button, and then you should only see one alert message.
        <listbox width="400px">
          <listhead>
            <listheader label="1"/>
            <listheader label="2"/>
          </listhead>
          <listitem>
            <listcell span="2" onClick='alert("you cannot see this one!")'>
              <button label="Click" onClick='alert("only this one!");'/>
            </listcell>
          </listitem>
        </listbox>
      </window>
    }
    runZTL(zscript, () => {
      // Click on the button
      click(jq(".z-button"));
      waitResponse();

      // Verify that the alert is visible
      verifyTrue("The Messagebox must be visible", jq(".z-messagebox-window").exists());

      // Verify that the alert that is visible is the correct one
      verifyTrue("The alert visible is not the correct", jq(".z-messagebox-window").html().contains("only this one!"));
      verifyFalse("The alert visible is the wrong one", jq(".z-messagebox-window").html().contains("you cannot see this one!"));

    })
  }
}