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

        def toPos(pos: Int, inp: JQuery) {
          click(tbInp)
          waitResponse()
          // move to the left most side
          for (i <- 1 to 10) {
            sendKeys(inp, Keys.LEFT)
          }
          // move to right
          for (i <- 0 until pos) {
            sendKeys(inp, Keys.RIGHT)
          }
        }

        def delete(inp: JQuery, delCnt: Int) {
          for (i <- 1 to delCnt) {
            sendKeys(inp, Keys.DELETE)
          }
        }

        def inputThenVerify(inp: JQuery, value: String) {
          sendKeys(inp, value)
          waitResponse()
          verifyContains("it should appear \"AM/PM\" 12:12:12 in timebox",
            inp.`val`(), "M 12:12:12")
        }

        toPos(0, tbInp)
        delete(tbInp, 2)
        inputThenVerify(tbInp, "121212")

        toPos(3, tbInp)
        delete(tbInp, 6)
        toPos(3, tbInp)
        inputThenVerify(tbInp, "121212")
      }
    )

  }
}
