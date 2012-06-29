/* B36_2688620Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Nov 10, 2011 22:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B36

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B36-2688620.zul,B,E,Window,Button")
class B36_2688620Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript = {
      <window>
        You should see the first two words are selected, that is correct.
        <timebox id="tb"/>
        <zscript>
          tb.setValue(java.util.Calendar.getInstance().getTime());
tb.setSelectionRange(0, 2);
tb.focus();
        </zscript>
      </window>
    }
    runZTL(zscript, () => {

      var d: Date = Calendar.getInstance().getTime();
      var df: SimpleDateFormat = new SimpleDateFormat("hh:MM:ss");
      var str = df.format(d);
      val msg = "[" + str.substring(0, 2) + "] should be selected";
      verifyTrue(msg, zk(jq("@timebox input")).eval("getSelectionRange()").equals("[0, 2]"));
    })
  }
}