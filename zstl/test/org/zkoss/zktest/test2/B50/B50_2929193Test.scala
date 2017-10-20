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
import scala.collection.JavaConversions._
import org.junit.Test;
import org.zkoss.ztl.Element;
import org.zkoss.ztl.JQuery;
import org.zkoss.ztl.Tags;
import org.zkoss.ztl.util.Scripts;
import org.zkoss.ztl.Widget;
import org.zkoss.ztl.ZK;
import org.zkoss.ztl.ZKClientTestCase;
import java.lang._

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