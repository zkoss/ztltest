/* B50_3096342Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import java.util.Calendar

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl.util._;

class B50_3096342Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
         <zk>
			<vlayout id="inf">
				<html id="desp"><![CDATA[
				<ol>
				<li>Case 1: Drop down and change the time in the timebox (of the popup).</li>
				<li>Then, click anywhere other than the datebox and popup to cause onChange</li>
				<li>Then, you shall see some message appended to the end of this page saying onChange:...</li>
				<li>Case 2: clean the content of datebox (delete all characters) and press TAB</li>
				<li>Then, you shall see onChange being fired with a null value (shown in the message being added)</li>
				</ol>
				]]></html>
				<zscript>
				int cnt = 0;
				void out(Object e, Object o) {
					inf.appendChild(new Label(e.target.id + ":" + e.name + ": "+o));
				}
				</zscript>
				<hlayout>
					<datebox id="d2" width="150px" format="MMM d, yyyy HH:mm:ss"
						onChange='out(event, self.value)'
						onChangingx='out(event, event.value)'
						onCreate="self.value = new Date()"/>
					<button label="reset" onClick='d2.setValue(new Date())'/>
				</hlayout>
			</vlayout>
      <script>
        function checkMsg() {
          var msg = jq("@label:last").text()
          return msg.indexOf("d2:onChange:") != -1 && msg.indexOf("null") == -1
        }
      </script>
      </zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val inf = ztl$engine.$f("inf")
    val desp = ztl$engine.$f("desp")
    val d2 = ztl$engine.$f("d2")
    runZTL(zscript, () => {
      click(jq(jq(".z-datebox").toWidget().$n("btn")))
      waitResponse()
      click(jq(".z-timebox").toWidget().$n("btn-down"))
      var index = 19
      var dayOnCalendar = jq(".z-calendar-weekday:eq(" + index + ")")
      var dayOfMonth = parseInt(dayOnCalendar.text())
      var calendar = Calendar.getInstance()
      if (dayOfMonth == calendar.get(Calendar.DAY_OF_MONTH)) {
        index = dayOfMonth - 1
        if (dayOfMonth == 1)
          index = dayOfMonth + 1
        dayOnCalendar = jq(".z-calendar-weekday:eq(" + index + ")")
      }
      clickAt(dayOnCalendar, "1,1")
      waitResponse()
      clickAt(jq("$desp"), "10,10")
      waitResponse()
      verifyEquals(true, getEval("checkMsg", false))
      var dateInput = jq(jq(".z-datebox").toWidget().$n("real"))
      dateInput.toElement().set("value", "")
      sendKeys(dateInput, "" + Keys.TAB)
      waitResponse()
      blur(dateInput)
      verifyEquals("d2:onChange: null", jq("@label:last").text())
      verifyEquals(true, getEval("checkMsg", false))
    })
  }
}



