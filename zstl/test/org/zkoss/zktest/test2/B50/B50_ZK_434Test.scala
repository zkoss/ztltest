/* B50_ZK_434Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Oct 19 14:37:47 CST 2011 , Created by benbai
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
import org.zkoss.ztl.unit.JQuery

/**
  * A test class for bug ZK-434
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-434.zul,A,E,Timebox,Format,Delete")
class B50_ZK_434Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(
      () => {
        var tbInp = jq(".z-timebox-input").eq(0)
        def inputThenVerify(inp: JQuery, value: String) {
          sendKeys(inp, value)
          waitResponse()
          verifyContains("it should appear \"AM/PM\" 12:12:12 in timebox",
            inp.`val`(), "M 12:12:12")
        }

        click(tbInp)
        waitResponse()
        // move to the left most side
        sendKeys(tbInp, Keys.HOME)
        waitResponse()
        sendKeys(tbInp, Keys.DELETE)
        waitResponse()
        sendKeys(tbInp, Keys.DELETE)
        waitResponse()
        inputThenVerify(tbInp, "121212")

        sendKeys(tbInp, Keys.LEFT_CONTROL + "a")
        waitResponse()
        sendKeys(tbInp, Keys.DELETE)
        waitResponse()
        inputThenVerify(tbInp, "121212")
      }
    )

  }
}
