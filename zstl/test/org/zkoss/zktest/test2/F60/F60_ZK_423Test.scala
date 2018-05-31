/* F60_ZK_423Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Mar 28 13:08:06 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F60

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl._

/**
  * A test class for bug ZK-423
  *
  * @author benbai
  *
  */
@Tags(tags = "F60-ZK-423.zul,F60,A,E,Listbox,Tree")
@IgnoreBrowsers("safari")
class F60_ZK_423Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      var tbxOne: Widget = engine.$f("tbxOne");
      var lbx: Widget = engine.$f("lbx");
      var tree: Widget = engine.$f("tree");
      var tbxTwo: Widget = engine.$f("tbxTwo");

      click(tbxOne);
      waitResponse();

      sendKeys(tbxOne, Keys.TAB);
      waitResponse();
      sendKeys(lbx.$n("a"), Keys.ARROW_DOWN);
      waitResponse();

      verifyTrue("First listitem should be selected",
        tbxTwo.$n().get("value").contains("true"));

      sendKeys(lbx.$n("a"), Keys.TAB);
      waitResponse();
      sendKeys(tree.$n("a"), Keys.ARROW_DOWN);
      waitResponse();

      verifyTrue("First listitem should be selected",
        tbxOne.$n().get("value").contains("true"));
    }
    );
  }
}
