/* B30_1599788Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1599788Test extends ZTL4ScalaTestCase {
  @Test
  def testTimer() = {
    var zscript =
      """
			<zk>			
			<vbox>
				<grid width="200px">
			 		<columns>
				        <column label="aa"/>
				        <column label="bb"/>
			       </columns>
			       <rows id="serverRows">
			       </rows>
				</grid>
				Rows: <label id="rowNr"/>
			 </vbox>
			<zscript>
			int cnt = 0;
			</zscript>
			<timer id="timer" delay="50" repeats="true" running="false">
					<attribute name ="onTimer">
						serverRows.getChildren().clear();
						Row row = new Row();
						row.setParent(serverRows);
						Label label = new Label();
						label.setParent(row);
						label.setId("l" + ++cnt);
						label.setValue(cnt + "");
						label = new Label();
						label.setParent(row);
						label.setValue("label1_1-"+ cnt);
						row = new Row();
						row.setParent(serverRows);
						Label label = new Label();
						label.setParent(row);
						label.setValue("label2-" + cnt);
						label = new Label();
						label.setParent(row);
						label.setValue("label2_2-" + cnt);
						rowNr.setValue(cnt + "");
					</attribute>
			</timer>
				<button id="stop" label="Stops timer" onClick="timer.stop()"/>
				<button id="start" label="Starts timer" onClick="timer.start()"/>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val serverRows = ztl$engine.$f("serverRows")
    val rowNr = ztl$engine.$f("rowNr")
    val timer = ztl$engine.$f("timer")
    val stop = ztl$engine.$f("stop")
    val start = ztl$engine.$f("start")
    val l = ztl$engine.$f("l")
    runZTL(zscript, () => {
      for (i <- 1 until 5) {
        click(start)
        waitResponse()
        click(stop)
        waitResponse()
        verifyEquals(rowNr.get("value"), serverRows.firstChild().firstChild().get("value"))
      }
    })
  }
}



