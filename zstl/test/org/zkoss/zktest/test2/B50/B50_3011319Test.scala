/* B50_3011319Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Oct 18 15:17:31 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 3011319
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3011319.zul,A,E,Datebox")
class B50_3011319Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        var db: Widget = engine.$f("db");
        var btn: Widget = engine.$f("btn");
        click(db.$n("btn"))
        waitResponse(true)
        click(jq(db.$n("pp")).find(".z-calendar-left").get(0));

        // wait animation
        waitResponse(true);
        verifyContains("the title should be April",
          jq(db.$n("pp")).find(".z-calendar-title").find(".z-calendar-text")
            .get(0).get("innerHTML"), "Apr")
        verifyContains("the 30th day of April should be selected",
          jq(db.$n("pp")).find(".z-calendar-selected").get(0).get("innerHTML"), "30")

        click(btn);
        waitResponse();

        click(db.$n("btn"));
        waitResponse()
        click(jq(".z-calendar-text").get(0));

        // wait animation
        waitResponse(true);
        click(jq(".z-calendar-month").find("td").get(1));

        // wait animation        
        waitResponse(true);
        verifyContains("the title should be Feburary",
          jq(db.$n("pp")).find(".z-calendar-title").find(".z-calendar-text")
            .get(0).get("innerHTML"), "Feb")
        verifyContains("the 28th day of Feburary should be selected",
          jq(db.$n("pp")).find(".z-calendar-selected").get(0).get("innerHTML"), "28")
      }
    );

  }
}