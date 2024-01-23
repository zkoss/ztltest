/* B50_ZK_631Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Dec 07 10:39:37 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.Widget

/**
  * A test class for bug ZK-631
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-631.zul,B,E,Datebox,Constraint")
class B50_ZK_631Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      var dob: Widget = engine.$f("dob");
      var doberr: Widget = engine.$f("doberr");
      sendKeys(jq(dob.$n()).find("input"), "abc");
      click(doberr);
      waitResponse();
      var errMsg: String = doberr.$n().attr("innerHTML");
      verifyContains("should display custom error about date format",
        errMsg, "abc")
      verifyContains("should display custom error about date format",
        errMsg, "yyyy/MM/dd")
    })
  }
}