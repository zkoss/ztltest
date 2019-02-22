/* B36_2874039Test.scala

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

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 2874039
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B36-2874039.zul,A,E,Listbox,Borderlayout,BI")
class B36_2874039Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(() => {
        waitResponse();

        //Click change button
        var btn = jq("$change");
        click(btn);
        waitResponse();

        //Check change No Bug to Bug
        var nobug = jq(".z-center-header");
        var bug = getText(nobug);

        verifyEquals(bug, "Bug");

        //Verify Scrollbar
        var lb = zk("$listbox");
        var h = lb.eval("hasHScroll()");
        waitResponse();
        verifyEquals(h, "false");

        var h1 = zk(jq("$listbox").toWidget().$n("body")).eval("hasHScroll()");
        verifyEquals(h1, "false");

      });
  }

}