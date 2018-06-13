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
package org.zkoss.zktest.bind.issue

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_F0011_3Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = """
      <include src="/bind/issue/F0011.zul"/>
"""

    runZTL(zul, () => {
      //validate property before command
      val tb51 = engine.$f("tb51")
      val tb52 = engine.$f("tb52")
      val lb51 = engine.$f("lb51")
      val lb52 = engine.$f("lb52")
      verifyEquals("", getValue(tb51))
      verifyEquals("", getValue(tb52))
      verifyEquals("", getText(lb51))
      verifyEquals("", getText(lb52))
      //		Assert.assertEquals("",findWidget("$tb51").getValue());
      //		Assert.assertEquals("",findWidget("$tb52").getValue());
      //		Assert.assertEquals("",findWidget("$lb51").getValue());
      //		Assert.assertEquals("",findWidget("$lb52").getValue());

      val btn3 = engine.$f("btn3")
      click(btn3)
      waitResponse()
      verifyEquals("do Command3", getText(lb52))
      //		findWidget("$btn3").click();
      //		Assert.assertEquals("do Command3",findWidget("$lb52").getValue());

      `type`(tb51, "abc")
      waitResponse()
      verifyEquals("", getText(lb51))
      verifyEquals("do Command3", getText(lb52))
      //		findWidget("$tb51").keys("abc").tab();
      //		Assert.assertEquals("",findWidget("$lb51").getValue());
      //		Assert.assertEquals("do Command3",findWidget("$lb52").getValue());

      click(btn3)
      waitResponse()
      verifyEquals("value2 must euqlas to value 1", getText(lb52))
      //		findWidget("$btn3").click();
      //		Assert.assertEquals("value2 must euqlas to value 1",findWidget("$lb52").getValue());

      `type`(tb52, "def")
      click(btn3)
      waitResponse()
      verifyEquals("", getText(lb51))
      verifyEquals("value2 must euqlas to value 1", getText(lb52))
      //		findWidget("$tb52").clear().keys("def");
      //		findWidget("$btn3").click();
      //		Assert.assertEquals("",findWidget("$lb51").getValue());
      //		Assert.assertEquals("value2 must euqlas to value 1",findWidget("$lb52").getValue());

      `type`(tb52, "abc")
      click(btn3)
      waitResponse()
      verifyEquals("abc", getText(lb51))
      verifyEquals("do Command3", getText(lb52))
      //		findWidget("$tb52").clear().keys("abc").tab();
      //		findWidget("$btn3").click();
      //		Assert.assertEquals("abc",findWidget("$lb51").getValue());
      //		Assert.assertEquals("do Command3",findWidget("$lb52").getValue());

    })
  }
}
