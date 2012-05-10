/* B36_2935398Test.scala

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

/**
 * A test class for bug 2935398
 * @author ldnigro
 *
 */
@Tags(tags = "B36-2935398.zul,A,E,scrollIntoView,Textbox,Constraint")
class B36_2935398Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B36-2935398.zul

	Purpose:
		
	Description:
		
	History:
		Wed Jan 20 10:46:55 TST 2010, Created by jumperchen

Copyright (C) 2009 Potix Corporation. All Rights Reserved.

-->
<zk>
    <textbox id="tb" constraint="no empty"/>
    Please scroll down to press the button.
    <div id="div" height="1400px"/>
    <button id="btn" label="Click me to show an errorbox on the textbox." onClick='Clients.scrollIntoView(tb); tb.getValue();'/>
</zk>

      """

    runZTL(zscript,
      () => {

        waitResponse();
        var b=jq("$div").height().toInt+jq("$tb").height().toInt;
        //Scroll down
        jq("body").scrollTop(b);
        waitResponse();

        //Click button
        var btn = jq("$btn");
        click(btn);
        waitResponse();
        
        //Check error visible 
        var error = jq(".z-errbox");
        var eb=error.exists();
        var ev=error.isVisible();
        verifyTrue(eb);
        verifyTrue(ev);
        
        //Verify err-box position
        var po=error.positionTop();
        var p1=jq("$tb").positionTop();
        verifyEquals(po,0);
        var l=jq("$tb").positionLeft()+jq("$tb").width()+6
        var l1=error.positionLeft();
        verifyEquals(l,l1);
      });
  }
     
}