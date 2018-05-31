/* B50_2929193Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Oct 18 15:57:19 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{Tags, Widget}

/**
  * A test class for bug 2929193
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-2929193.zul,A,E,Datebox")
class B50_2929193Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(() => {
      var db: Widget = engine.$f("db");
      click(db.$n("btn"));
      waitResponse();
      var clickTarget = jq(db.$n("pp")).find(".z-calendar-weekday").get(10)
      if (!isSafari)
        click(clickTarget);
      else
        clickAt(clickTarget, "2,2")
      waitResponse();

      verifyTrue("The Calendar should close",
        "none".equals(db.$n("pp").get("style.display")));
    }
    );

  }
}