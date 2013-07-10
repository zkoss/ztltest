/* B60_ZK_1010Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Apr 23 14:56:49 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

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
 * A test class for bug ZK-1010
 * @author benbai
 *
 */
@Tags(tags = "B60-ZK-1010.zul,B,E,Datebox,Calendar")
class B60_ZK_1010Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() = {
    val zscript = {
			<zk>
    		<zscript>
    			import java.util.Calendar;
    			import java.util.Date;

    			Calendar cal = Calendar.getInstance();
    			cal.set(Calendar.YEAR, 2012);
    			cal.set(Calendar.MONTH, 1);
    			cal.set(Calendar.DATE, 28);

    			Date date = cal.getTime();
    		</zscript>
			1. Please choose a date like "2012/02/29" (Leap-day), in thai's datebox will be "2555" years, after selected the value will be "Wed Feb 29 00:00:00 CST 2012"
			<separator/>
			2. Please reopen the selected datebox, the date in the calendar should be the same as your chosen.
			<div id="outer">outer</div>
			<hlayout>
			<datebox id="dbx1" locale="th_TH" value="${date}" format="d MMM yyyy" onChange="v1.value = self.value.toString()"/>THai's value=<label id="v1"/>
			</hlayout>
			
			<hlayout>
			<datebox id="dbx2" locale="ja_JP" value="${date}" format="d MMM yyyy" onChange="v2.value = self.value.toString()"/>Japan's value=<label id="v2"/>
			</hlayout>
			
			<hlayout>
			<datebox id="dbx3" value="${date}" format="d MMM yyyy" onChange="v3.value = self.value.toString()"/>Default's value=<label id="v3"/>
			</hlayout>
			</zk>

    }

    runZTL(zscript,
        () => {
        var outer: Widget = engine.$f("outer");
        var dbx1: Widget = engine.$f("dbx1");
        var dbx2: Widget = engine.$f("dbx2");
        var dbx3: Widget = engine.$f("dbx3");
        var v1: Widget = engine.$f("v1");
        var v2: Widget = engine.$f("v2");
        var v3: Widget = engine.$f("v3");
        var val1: String = dbx1.$n("real").get("value");
        var val2: String = dbx2.$n("real").get("value");
        var val3: String = dbx3.$n("real").get("value");
        var oldy1: String = val1.substring(val1.length()-5, val1.length()).trim();
        var oldy2: String = val2.substring(val2.length()-5, val2.length()).trim();
        var oldy3: String = val3.substring(val3.length()-5, val3.length()).trim();
        var oldd1: String = val1.substring(0, 3).trim();
        var oldd2: String = val2.substring(0, 3).trim();
        var oldd3: String = val3.substring(0, 3).trim();
        var oldm1: String = val1.replace(oldy1, "").replace(oldd1, "").trim();
        var oldm2: String = val2.replace(oldy2, "").replace(oldd2, "").trim();
        var oldm3: String = val3.replace(oldy3, "").replace(oldd3, "").trim();

        def selectDate (dbx: Widget) {
          var dayRow: JQuery = null;
          click(dbx.$n("btn")); waitResponse();
          click(jq(dbx.$n("pp")).find(".z-calendar-cell:contains(29)"));
          waitResponse();
        }
        def openAndCheck (dbx: Widget, year: String, mon: String) {
          click(dbx.$n("btn")); waitResponse();

          verifyTrue("the date in the calendar should be the same as your chosen: "+year+"_"+mon+"_29",
//              jq(dbx.$n("pp")).find(".z-calendar:contains("+mon+")").exists()
              jq(dbx.$n("pp")).find(".z-calendar-title:contains("+year+")").exists()
              && jq(dbx.$n("pp")).find(".z-calendar-cell:contains(29)").exists());
          click(outer);
        }

        selectDate(dbx1);
        selectDate(dbx2);
        selectDate(dbx3);

        openAndCheck(dbx1, oldy1, oldm1);
        openAndCheck(dbx2, oldy2, oldm2);
        openAndCheck(dbx3, oldy3, oldm3);

        verifyTrue("Three values are the same",
            v1.$n().get("innerHTML").equals(v2.$n().get("innerHTML"))
            && v2.$n().get("innerHTML").equals(v3.$n().get("innerHTML")));
        
    }
   );
  }
}