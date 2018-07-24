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
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.Widget

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
    runZTL(zscript,
      () => {
        var db: Widget = engine.$f("db");
        click(db.$n("btn"));
        waitResponse()
        verifyContains("the time in datebox should equalt to the time in child timebox", db.$n("real").attr("value"), jq(db.$n("pp")).find(".z-timebox").toWidget().$n("real").attr("value"))
      }
    );

  }
}
