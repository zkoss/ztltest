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

import java.text.{DateFormat, SimpleDateFormat}
import java.util.Calendar

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B36-2678340.zul,B,E,Window,Button")
class B36_2678340Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    val zscript =
      """
	  <zk>
    		<button id="change" label="change to US">
    			<attribute name="onClick"><![CDATA[
    				Locale locale = new Locale("en", "US");
    				Sessions.getCurrent().setAttribute("px_preferred_locale", locale);
    				Clients.reloadMessages(locale);
    				org.zkoss.util.Locales.setThreadLocal(locale);
    		]]></attribute>
    		</button>
        <window>
          <html><![CDATA[  
		step1.click timebox btn to scroll the time value <br />
		step2.click show value btn , the label has correct date string (check the time string)  <br />
		step3.click timebox btn to scroll the time value again, after value changing, press 'tab' to change focus,  <br />
		step4.click show value btn, the label <span style="color:red">should change to new time string</span> <br />
        ]]></html>
          <timebox id="tb1" format="hh:mm:ss a"/>
          <label id="lab" value="1"/>
          <button id="show" label="show value" mold="os">
            <attribute name="onClick"><![CDATA[  
				lab.setValue(""+tb1.getValue());
				]]></attribute>
          </button>
        </window>
      </zk>
    """
    runZTL(zscript, () => {
      click(jq("$change"))
      waitResponse()
      // Click upper button twice
      click(jq(".z-timebox").toWidget().$n("btn-down"))
      waitResponse()
      click(jq(".z-timebox").toWidget().$n("btn-down"))
      waitResponse()
      sleep(500)

      // Click on show value button
      click(jq("$show"));
      waitResponse()
      sleep(500)

      val tb = engine.$f("tb1")
      val lab = engine.$f("lab")

      // Value of the label
      val v = getText(lab)
      // Location of time separator ':'
      var p = v.indexOf(":")
      // Construct a parseable time format
      val value1 = v.substring(p - 2, p + 6)
      // value of the timebox
      val r = jq(tb.$n("real")).`val`()
      p = r.indexOf(":")
      val value2 = r.substring(p - 2, p + 6)

      val df1: DateFormat = new SimpleDateFormat("hh:mm:ss");
      var calendar = Calendar.getInstance();
      calendar.setTime(df1.parse(value1));

      var hh1 = calendar.get(Calendar.HOUR_OF_DAY);
      var mm1 = calendar.get(Calendar.MINUTE);
      var ss1 = calendar.get(Calendar.SECOND);

      val df2: DateFormat = new SimpleDateFormat("hh:mm:ss");
      calendar.setTime(df2.parse(value2));
      var hh2 = calendar.get(Calendar.HOUR_OF_DAY);
      var mm2 = calendar.get(Calendar.MINUTE);
      var ss2 = calendar.get(Calendar.SECOND);

      verifyTrue("The time value should of the label should be equal to the timebox", hh1 == hh2 && mm1 == mm2 && ss1 == ss2);

      // Click upper button again
      click(jq(".z-timebox").toWidget().$n("btn-up"))
      sendKeys(tb.$n("real"), Keys.TAB);

      // Click on show value button again
      click(jq("@button"));
      waitResponse();

      calendar.setTime(df1.parse(value1));

      hh1 = calendar.get(Calendar.HOUR_OF_DAY);
      mm1 = calendar.get(Calendar.MINUTE);
      ss1 = calendar.get(Calendar.SECOND);

      calendar.setTime(df2.parse(value2));
      hh2 = calendar.get(Calendar.HOUR_OF_DAY);
      mm2 = calendar.get(Calendar.MINUTE);
      ss2 = calendar.get(Calendar.SECOND);

      verifyTrue("The time value should of the label should be equal to the timebox", hh1 == hh2 && mm1 == mm2 && ss1 == ss2);
    })
  }
}