/* B50_3106676Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Oct 18 13:01:19 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import java.util.Calendar

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl.annotation.Tags
/**
  * A test class for bug 3106676
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3106676.zul,A,E,Datebox,Calendar,Constraint")
class B50_3106676Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """

			<zk>
			<datebox id="dtbx1" constraint="no past" lenient="false"/>
			-> Correct. You cannot select past days.
			
			<datebox  id="dtbx2" constraint="no empty, no past" lenient="false"/>
			-> Correct. You cannot select past days as well.
			</zk>

    """
    runZTL(zscript,
      () => {
        var dtbx1: Widget = engine.$f("dtbx1");
        var dtbx2: Widget = engine.$f("dtbx2");
        var cal: Calendar = Calendar.getInstance();

        checkCorrect(dtbx1);
        checkCorrect(dtbx2);

      }
    );
    def checkCorrect(dtbx: Widget) {
      click(dtbx.$n("btn"));
      waitResponse();
      var today: Int = jq(".z-calendar-selected").last().text().toInt;
      var yesterday: Int = Integer.parseInt(jq(dtbx.$n("pp")).find(".z-calendar-disabled").last().get(0).attr("innerHTML"));
      verifyTrue("the last unselectable date should be yesterday",
        (today - yesterday == 1) || ((today == 1) && (31 - yesterday <= 3)));
    }

  }
}