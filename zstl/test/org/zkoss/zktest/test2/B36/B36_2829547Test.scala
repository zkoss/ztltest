/* B36_2829547Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B36_2829547Test extends ZTL4ScalaTestCase {
  @Test
  def testvalue() = {
    var zscript =
      """
			<zk>
			<window title="Timebox Bug test" border="normal">
				1.Please click the Up/Down icon of the first timebox.
				<separator/>
				2.And then click the Up/Down icon of the second timebox.
				<separator/>
				3.Click the "Run Report" to see the result.
			<zscript>
				Date now = new Date();
				void showValues() {
					if (startTime.getValue().getTime() == now.getTime()) {
						alert("Error! This is a bug!");
					} else if ( endTime.getValue().getTime() == now.getTime()) {
						alert("Error! This is a bug!");
					} else {
						alert("Correct! The bug is fixed!");
					}
				}
			</zscript>
				<timebox id="startTime" value="${now}" />
				<timebox id="endTime" value="${now}" />
				<button id="runReport" label="Run Report" onClick="showValues()"/>
			</window>
			</zk>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val startTime = ztl$engine.$f("startTime")
    val endTime = ztl$engine.$f("endTime")
    val runReport = ztl$engine.$f("runReport")
    runZTL(zscript, () => {
      //fix ie9 issue
      click(widget("$startTime").$n("btn-up"))
      blur(widget("$startTime").$n("real"))
      click(widget("$endTime").$n("btn-up"))
      blur(widget("$endTime").$n("real"))
      click(jq("$runReport"))
      waitResponse()
      // Tony:because when event thread enable it will be highlight mode ,
      // when event thread disable will be modal mode ,
      // so we just detect the title for it.
      verifyEquals("Correct! The bug is fixed!", jq(".z-window-highlighted .z-label").text())
      click(jq("$btn1"))
    })
  }
}



