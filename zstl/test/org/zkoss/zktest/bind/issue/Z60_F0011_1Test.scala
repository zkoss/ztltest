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
import org.zkoss.ztl.Tags
import org.openqa.selenium.Keys
import java.text.SimpleDateFormat
import java.util.Date
import org.zkoss.ztl.ZKSeleneseTestCase

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_F0011_1Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = {
      <include src="/bind/issue/F0011.zul"/>
    }

    runZTL(zul, () => {
      val tb31 = engine $f "tb31"
      val tb32 = engine $f "tb32"
      val lb31 = engine $f "lb31"
      val lb32 = engine $f "lb32"
      //validate property before command
      ZKSeleneseTestCase.assertEquals("", getValue(tb31))
      ZKSeleneseTestCase.assertEquals("", getValue(tb32))
      ZKSeleneseTestCase.assertEquals("", getText(lb31))
      ZKSeleneseTestCase.assertEquals("", getText(lb32))
      //		Assert.assertEquals("",findWidget("$tb31").getValue());
      //		Assert.assertEquals("",findWidget("$tb32").getValue());
      //		Assert.assertEquals("",findWidget("$lb31").getValue());
      //		Assert.assertEquals("",findWidget("$lb32").getValue());

      val btn1 = engine $f "btn1"
      click(btn1)
      waitResponse()
      ZKSeleneseTestCase.assertEquals("value1 is empty", getText(lb32))
      //		findWidget("$btn1").click();
      //		Assert.assertEquals("value1 is empty",findWidget("$lb32").getValue());

      `type`(tb31, "abc")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("", getText(lb31))
      ZKSeleneseTestCase.assertEquals("value1 is empty", getText(lb32))
      //		findWidget("$tb31").keys("abc").tab();
      //		Assert.assertEquals("",findWidget("$lb31").getValue());
      //		Assert.assertEquals("value1 is empty",findWidget("$lb32").getValue());

      click(btn1)
      waitResponse()
      ZKSeleneseTestCase.assertEquals("value2 must euqlas to value 1", getText(lb32))
      //		findWidget("$btn1").click();
      //		Assert.assertEquals("value2 must euqlas to value 1",findWidget("$lb32").getValue());

      `type`(tb32, "abc")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("", getText(lb31))
      ZKSeleneseTestCase.assertEquals("value2 must euqlas to value 1", getText(lb32))
      //		findWidget("$tb32").keys("abc").tab();
      //		Assert.assertEquals("",findWidget("$lb31").getValue());
      //		Assert.assertEquals("value2 must euqlas to value 1",findWidget("$lb32").getValue());

      click(btn1)
      waitResponse()
      ZKSeleneseTestCase.assertEquals("abc", getText(lb31))
      ZKSeleneseTestCase.assertEquals("do Command1", getText(lb32))
      //		findWidget("$btn1").click();
      //		Assert.assertEquals("abc",findWidget("$lb31").getValue());
      //		Assert.assertEquals("do Command1",findWidget("$lb32").getValue());      

    })
  }
}
