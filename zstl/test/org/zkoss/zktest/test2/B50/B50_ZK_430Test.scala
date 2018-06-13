/* B50_ZK_430Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Oct 19 12:24:08 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl._
import org.zkoss.ztl.unit.{Element, Widget}

/**
  * A test class for bug ZK-430
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-430.zul,A,E,Timebox,Format")
class B50_ZK_430Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      var (tb1: Widget,
      tb2: Widget,
      tb3: Widget) = (
        engine.$f("tb1"),
        engine.$f("tb2"),
        engine.$f("tb3")
      );
      var (tb1Inp: Element,
      tb2Inp: Element,
      tb3Inp: Element) = (
        tb1.$n("real"),
        tb2.$n("real"),
        tb3.$n("real")
      );

      def clearAndInput(ele: Element, value: String) {
        ele.eval("focus()");
        waitResponse()
        ele.eval("select()");
        waitResponse()
        sendKeys(ele, value)
        waitResponse()
      }

      clearAndInput(tb1Inp, "1212");
      waitResponse()
      verifyTrue("it should be able to type and display \"1212\" of first timebox.",
        "1212".equals(tb1Inp.get("value")));
      clearAndInput(tb2Inp, "121212");
      waitResponse()
      verifyTrue("Type 121212 into the timebox, it should be able to type and display \"PM 12:12:12\" or \"AM 12:12:12\" (depended on when you test it).",
        "AM 12:12:12".equals(tb2Inp.get("value")) || "PM 12:12:12".equals(tb2Inp.get("value")));
      click(tb3Inp);
      waitResponse()
      // move to the right most side
      for (i <- 1 to 10) {
        sendKeys(tb3Inp, Keys.RIGHT);
      }
      // move to the position after AM00/PM00
      for (j <- 1 to 6) {
        sendKeys(tb3Inp, Keys.LEFT);
      }
      clickAndCheck(tb3.$n("btn-up"));
      waitResponse()
      clickAndCheck(tb3.$n("btn-up"));
      waitResponse()
      clickAndCheck(tb3.$n("btn-down"));
      waitResponse()
      clickAndCheck(tb3.$n("btn-down"));
      waitResponse()

      def clickAndCheck(ele: Element) {
        var checkStr: String = "PM";
        if (!tb3Inp.get("value").contains(checkStr))
          checkStr = "AM";
        click(ele);
        waitResponse()
        verifyTrue("should change AM/PM",
          tb3Inp.get("value").contains(checkStr));
      }
    }
    );

  }
}
