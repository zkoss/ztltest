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
 * A test class for bug 3011319
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
        verifyTrue("the title should be April",
            jq(db.$n("pp")).find(".z-calendar-title").find(".z-calendar-text")
            	.get(0).get("innerHTML").contains("Apr"));
        verifyTrue("the 30th day of April should be selected",
            jq(db.$n("pp")).find(".z-calendar-selected").get(0).get("innerHTML").contains("30"));

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
        verifyTrue("the title should be Feburary",
            jq(db.$n("pp")).find(".z-calendar-title").find(".z-calendar-text")
            	.get(0).get("innerHTML").contains("Feb"));
        verifyTrue("the 28th day of Feburary should be selected",
            jq(db.$n("pp")).find(".z-calendar-selected").get(0).get("innerHTML").contains("28"));
    }
   );

  }
}