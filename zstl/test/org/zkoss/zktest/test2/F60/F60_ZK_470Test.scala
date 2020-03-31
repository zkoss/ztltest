/* F60_ZK_470Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Mar 21 18:06:09 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.Widget

/**
  * A test class for bug ZK-470
  *
  * @author benbai
  *
  */
@Tags(tags = "F60-ZK-470.zul,F60,A,E,Anchorlayout")
class F60_ZK_470Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      var al: Widget = engine.$f("al");
      var win1: Widget = engine.$f("win1");
      var win2: Widget = engine.$f("win2");
      var win3: Widget = engine.$f("win3");
      var win4: Widget = engine.$f("win4");
      var win5: Widget = engine.$f("win5");
      var win6: Widget = engine.$f("win6");
      var parentW = jq(al.$n()).width();
      var parentH = jq(al.$n()).height();

      verifyTrue("Ths window size should be " + (parentW - 100),
        getEval("Math.abs(" + jq(win1).outerWidth() + " - " + (parentW - 100) + ") < 2"))
      verifyTrue("Ths window size should be " + 200,
        getEval("Math.abs(" + jq(win1).outerHeight() + " - " + 200 + ") < 2"))

      verifyTrue("Ths window size should be " + (parentW * 0.5),
        getEval("Math.abs(" + jq(win2).outerWidth() + " - " + (parentW * 0.5) + ") < 2"))
      verifyTrue("Ths window size should be " + (parentH - 200),
        getEval("Math.abs(" + jq(win2).outerHeight() + " - " + (parentH - 200) + ") < 2"))

      verifyTrue("Ths window size should be " + (parentW * 0.25),
        getEval("Math.abs(" + jq(win3).outerWidth() + " - " + (parentW * 0.25) + ") < 2"))
      verifyTrue("Ths window size should be " + (parentH * 0.2),
        getEval("Math.abs(" + jq(win3).outerHeight() + " - " + (parentH * 0.2) + ") < 2"))

      verifyTrue("Ths window size should be " + (parentW * 0.25),
        getEval("Math.abs(" + jq(win4).outerWidth() + " - " + (parentW * 0.25) + ") < 2"))
      verifyTrue("Ths window size should be " + (parentH * 0.2),
        getEval("Math.abs(" + jq(win4).outerHeight() + " - " + (parentH * 0.2) + ") < 2"))

      verifyTrue("Ths window size should be " + (parentW * 0.25),
        getEval("Math.abs(" + jq(win5).outerWidth() + " - " + (parentW * 0.25) + ") < 2"))
      verifyTrue("Ths window size should be " + (parentH * 0.2),
        getEval("Math.abs(" + jq(win5).outerHeight() + " - " + (parentH * 0.2) + ") < 2"))

      verifyTrue("Ths window size should be " + (parentW * 0.25),
        getEval("Math.abs(" + jq(win6).outerWidth() + " - " + (parentW * 0.25) + ") < 2"))
      verifyTrue("Ths window size should be " + (parentH * 0.2),
        getEval("Math.abs(" + jq(win6).outerHeight() + " - " + (parentH * 0.2) + ") < 2"))
    }
    );
  }
}