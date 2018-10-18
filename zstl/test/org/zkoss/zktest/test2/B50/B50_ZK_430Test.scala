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
import org.zkoss.ztl.annotation.Tags
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
      var tb1: Widget = engine.$f("tb1")
      var tb2: Widget = engine.$f("tb2")
      var tb3: Widget = engine.$f("tb3")
      var tb1Inp: Element = tb1.$n("real")
      var tb2Inp: Element = tb2.$n("real")
      var tb3Inp: Element = tb3.$n("real")

      click(tb1Inp)
      waitResponse()
      `type`(tb1Inp, "1212");
      waitResponse()
      verifyEquals("it should be able to type and display \"1212\" of first timebox.",
        "1212", tb1Inp.attr("value"))
      click(tb2Inp)
      waitResponse()
      `type`(tb2Inp, "121212");
      waitResponse()
      verifyContains("Type 121212 into the timebox, it should be able to type and display \"PM 12:12:12\" or \"AM 12:12:12\" (depended on when you test it).",
        tb2Inp.attr("value"), "M 12:12:12")
      click(tb3Inp);
      waitResponse()
      // move to the right most side
      for (i <- 1 to 10) {
        sendKeys(tb3Inp, Keys.RIGHT);
      }
      // move to the position after AM00/PM00
      for (j <- 1 to 10) {
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
        var checkStr = getEval("getNextAMPM()")
        println(">>>>> check : " + checkStr)
        waitResponse()
        click(ele)
        waitResponse()
        verifyContains("should change AM/PM", tb3Inp.attr("value"), checkStr);
        println(">>>>> result : " + tb3Inp.attr("value"))
      }
    }
    )
  }
}
