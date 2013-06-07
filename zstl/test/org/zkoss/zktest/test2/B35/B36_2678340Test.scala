/* B36_2678340Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Feb 16, 2012 15:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.openqa.selenium.Keys
import org.zkoss.ztl.Widget
import java.text.DateFormat
import java.text.SimpleDateFormat

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B36-2678340.zul,B,E,Window,Button")
class B36_2678340Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript = {
      <zk>
        <window>
          <html><![CDATA[  
		step1.click timebox btn to scroll the time value <br />
		step2.click show value btn , the label has correct date string (check the time string)  <br />
		step3.click timebox btn to scroll the time value again, after value changing, press 'tab' to change focus,  <br />
		step4.click show value btn, the label <span style="color:red">should change to new time string</span> <br />
        ]]></html>
          <timebox id="tb1"/>
          <label id="lab" value="1"/>
          <button label="show value" mold="os">
            <attribute name="onClick"><![CDATA[  
				lab.setValue(""+tb1.getValue());
				]]></attribute>
          </button>
        </window>
      </zk>
    }
    runZTL(zscript, () => {
      // Click upper button twice
      mouseDownAt(jq(".z-timebox-up"), "1,1");
      mouseUp(jq(".z-timebox-up"));
      mouseDownAt(jq(".z-timebox-up"), "1,1");
      mouseUp(jq(".z-timebox-up"));

      // Click on show value button
      click(jq("@button"));
      waitResponse();

      val tb = engine.$f("tb1");
      val lab = engine.$f("lab");

      // Value of the label
      val v = lab.get("value");
      // Location of time separator ':'
      val p = v.indexOf(":");
      // Construct a parseable time format
      val value1 = v.substring(p - 2, p + 6);
      // value of the timebox
      val value2 = jq(tb.$n("real")).`val`();

      val df1: DateFormat = new SimpleDateFormat("hh:mm:ss");
      var hh1 = df1.parse(value1).getHours();
      var mm1 = df1.parse(value1).getMinutes();
      var ss1 = df1.parse(value1).getSeconds();

      val df2: DateFormat = new SimpleDateFormat("hh:mm:ss");
      var hh2 = df2.parse(value2).getHours();
      var mm2 = df2.parse(value2).getMinutes();
      var ss2 = df2.parse(value2).getSeconds();

      verifyTrue("The time value should of the label should be equal to the timebox", hh1 == hh2 && mm1 == mm2 && ss1 == ss2);

      // Click upper button again
      click(jq(".z-timebox-up"));
      sendKeys(tb.$n("real"), Keys.TAB);

      // Click on show value button again
      click(jq("@button"));
      waitResponse();

      hh1 = df1.parse(value1).getHours();
      mm1 = df1.parse(value1).getMinutes();
      ss1 = df1.parse(value1).getSeconds();

      hh2 = df2.parse(value2).getHours();
      mm2 = df2.parse(value2).getMinutes();
      ss2 = df2.parse(value2).getSeconds();

      verifyTrue("The time value should of the label should be equal to the timebox", hh1 == hh2 && mm1 == mm2 && ss1 == ss2);
    })
  }
}