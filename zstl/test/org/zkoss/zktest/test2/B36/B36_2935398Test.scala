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

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 2935398
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B36-2935398.zul,A,E,scrollIntoView,Textbox,Constraint")
class B36_2935398Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        waitResponse();
        var b = jq("$div").height() + jq("$tb").height();
        //Scroll down
        evalScript("window.scrollTo(0, " + b + " )");
        waitResponse();

        //Click button
        var btn = jq("$btn");
        click(btn);
        waitResponse();

        //Check error visible 
        var error = jq(".z-errorbox");
        var eb = error.exists();
        var ev = error.isVisible();
        verifyTrue(eb);
        verifyTrue(ev);

        //Verify err-box position
        var po = error.positionTop();
        var p1 = jq("$tb").positionTop();
        verifyTolerant(po, 0, 2);
        var l = jq("$tb").offsetLeft() + jq("$tb").outerWidth()
        var l1 = error.offsetLeft();
        verifyTolerant(l, l1, 1);
      });
  }
}