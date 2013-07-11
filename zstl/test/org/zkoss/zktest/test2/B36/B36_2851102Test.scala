/* B36_2851102Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Nov 08 22:51:02 GFT 2011 , Created by ldnigro
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B36

import java.util.Calendar
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.junit.Test

/**
 * A test class for bug 2851102
 * @author ldnigro
 *
 */
@Tags(tags = "B36-2851102.zul,A,E,Window,Popup,Errorbox")
class B36_2851102Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B36-2851102.zul

	Purpose:
		
	Description:
		
	History:
		Fri Oct 16 15:58:03     2009, Created by jumperchen

Copyright (C) 2009 Potix Corporation. All Rights Reserved.

-->
<window>
<toolbarbutton id='bt1' label="Click ME" onClick="win1.doPopup()" />

<window visible="false" closable="true" id="win1" border="normal"
width="600px" height="300px">
<caption label="Test" />
<label>Test</label>
<textbox id='txt1' constraint="no empty" />
<label id="lbl1">Click in textbox, then click in whitespace below to trigger
constraint popup. Then click X on popup - window should not close.</label>
</window>
</window>
      """

    runZTL(zscript,
      () => {

        waitResponse();

        //Click 'Click Me' button
        var btn = jq("$bt1");
        click(btn);
        waitResponse();

        //Click textbox
        var txt = jq("$txt1");
        click(txt);
        waitResponse();
        
        //Click other place
        var other = jq("$lbl1");
        click(other);
        waitResponse();
        
        //Click close
        click(jq(".z-errorbox").toWidget().$n("cls"));
        waitResponse();
        
        //Popup is closed
        verifyFalse(jq(".z-errorbox").isVisible());
        
        //Window not closed
        verifyTrue(jq("$win1").isVisible());
        
      });
  }
     
}