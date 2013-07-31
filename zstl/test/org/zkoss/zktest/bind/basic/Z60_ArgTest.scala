/* 

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.bind.basic

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestCase
import org.junit.Test

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_ArgTest extends ZTL4ScalaTestCase {
  @Test
  def testArg() = {
    val zul = {
      <include src="/bind/basic/args.zul"/>
    }
    runZTL(zul, () => {
      val l1 = engine $f "l1"
      val l2 = engine $f "l2"
      val t1 = engine $f "t1"
      val t2 = engine $f "t2"

      ZKSeleneseTestCase.assertEquals("A-Arg1", getText(l1));
      ZKSeleneseTestCase.assertEquals("B-myarg1", getText(l2));
      ZKSeleneseTestCase.assertEquals("A-Arg1", getValue(t1));
      ZKSeleneseTestCase.assertEquals("B-myarg1", getValue(t2));

      `type`(t1, "X")
      sendKeys(t1, Keys.TAB)
      waitResponse()
      ZKSeleneseTestCase.assertEquals("X-Arg2-Arg1", getText(l1));
      ZKSeleneseTestCase.assertEquals("B-myarg1", getText(l2));
      ZKSeleneseTestCase.assertEquals("X-Arg2-Arg1", getValue(t1));
      ZKSeleneseTestCase.assertEquals("B-myarg1", getValue(t2));

      `type`(t2, "Y")
      sendKeys(t2, Keys.TAB)
      waitResponse()
      ZKSeleneseTestCase.assertEquals("X-Arg2-Arg1", getText(l1));
      ZKSeleneseTestCase.assertEquals("Y-myarg2-myarg1", getText(l2));
      ZKSeleneseTestCase.assertEquals("X-Arg2-Arg1", getValue(t1));
      ZKSeleneseTestCase.assertEquals("Y-myarg2-myarg1", getValue(t2));

      click(engine $f "btn1")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("X-Arg2Dennis-Arg1", getText(l1));
      ZKSeleneseTestCase.assertEquals("Y-myarg2Chen-myarg1", getText(l2));
      ZKSeleneseTestCase.assertEquals("X-Arg2Dennis-Arg1", getValue(t1));
      ZKSeleneseTestCase.assertEquals("Y-myarg2Chen-myarg1", getValue(t2));

      val t3 = engine $f "t3"
      val l3 = engine $f "l3"
      `type`(t3, "ABC")
      sendKeys(t3, Keys.TAB)
      waitResponse()
      ZKSeleneseTestCase.assertEquals("value have to equals V1", getText(l3));

      `type`(t3, "V1")
      sendKeys(t3, Keys.TAB)
      waitResponse()
      ZKSeleneseTestCase.assertEquals("", getText(l3));
      ZKSeleneseTestCase.assertEquals("V1-Arg1", getText(l1));

      val t4 = engine $f "t4"
      val l4 = engine $f "l4"
      `type`(t4, "ABC")
      sendKeys(t4, Keys.TAB)
      waitResponse()
      ZKSeleneseTestCase.assertEquals("", getText(l4));
      click(engine $f "btn2")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("value have to equals V2", getText(l4));
      ZKSeleneseTestCase.assertEquals("V1", getValue(t3));

      `type`(t4, "V2")
      sendKeys(t4, Keys.TAB)
      click(engine $f "btn2")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("execute cmd2", getText(l4));
      ZKSeleneseTestCase.assertEquals("V2-Arg1", getText(l1));
      ZKSeleneseTestCase.assertEquals("V2", getValue(t3));

    })
  }
}
