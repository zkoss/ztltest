/* B36_2799334Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		May 8, 2012 22:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B36

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.openqa.selenium.Keys
import org.zkoss.ztl.Widget
import org.zkoss.ztl.ZK
import org.junit.Test

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B36-2799334.zul,B,E,Window,Button")
class B36_2799334Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    val zscript = """
      <window title="IE only" border="normal" width="500px">
        <toolbarbutton label="step 1-click here to show pop" popup="popme"/>
        <popup id="popme" width="330px">
          hello
          <textbox id="tb1" value="step 2-click here to focus this popup." width="300px"/>
        </popup>
        <textbox id="tb2" value="step 3-click here, it should select all the words." onFocus="self.select();" width="400px"/>
      </window>"""
    
    runZTL(zscript, () => {
      // Click on toolbarbutton
      click(jq(".z-toolbarbutton-content"));
      waitResponse();

      // Click on popup textbox
      click(jq("$tb1"));
      waitResponse();

      // Verify that the popup textbox has focus
      if(!ZK.is("ie8"))
    	  verifyTrue("The second textbox should have focus", "" != jq("$tb1").css("box-shadow"));

      // Click on step 3 textbox
      focus(jq("$tb2"));
      waitResponse();
      verifyTrue("The text should be selected", zk(jq("$tb2")).eval("getSelectionRange()[1]").toInt == 50);

    })
  }
}