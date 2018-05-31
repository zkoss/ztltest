/* B50_2923185Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Oct 18 16:04:36 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{Tags, Widget}

/**
  * A test class for bug 2923185
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-2923185.zul,A,E,Datebox")
class B50_2923185Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<?page title="new page title" contentType="text/html;charset=UTF-8"?>
			<zk>
			1. Click the datebox button to open the Calendar
			<separator/>
			2. the textbox inside the Calendar popup should be the current hour and min (same with the datebox above). If not, it's error.
			<separator/>
			<datebox id="db" cols="20" locale="en_US" format="yyyy/MM/dd HH:mm" onCreate="self.value = new Date()"/>
			</zk>

    """

    // Run syntax 2
    runZTL(zscript,
      () => {
        var db: Widget = engine.$f("db");

        click(db.$n("btn"));
        var t1: String = db.$n("real").get("value").split(" ")(1);
        var t2: String = jq(db.$n("pp")).find(".z-timebox").toWidget().$n("real").get("value");

        verifyTrue("the time in datebox should equalt to the time in child timebox",
          t1.equals(t2));
      }
    );

  }
}