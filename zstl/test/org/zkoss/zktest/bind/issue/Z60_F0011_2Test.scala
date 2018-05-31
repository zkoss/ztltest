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
import org.zkoss.ztl.{Tags, ZKSeleneseTestCase}

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_F0011_2Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = """
      <include src="/bind/issue/F0011.zul"/>
"""

    runZTL(zul, () => {
      //validate property before command
      val tb41 = engine $f "tb41"
      val tb42 = engine $f "tb42"
      val lb41 = engine $f "lb41"
      val lb42 = engine $f "lb42"
      //validate property before command
      ZKSeleneseTestCase.assertEquals("", getValue(tb41))
      ZKSeleneseTestCase.assertEquals("", getValue(tb42))
      ZKSeleneseTestCase.assertEquals("", getText(lb41))
      ZKSeleneseTestCase.assertEquals("", getText(lb42))
      //		Assert.assertEquals("",findWidget("$tb41").getValue());
      //		Assert.assertEquals("",findWidget("$tb42").getValue());
      //		Assert.assertEquals("",findWidget("$lb41").getValue());
      //		Assert.assertEquals("",findWidget("$lb42").getValue());

      val btn2 = engine $f "btn2"
      click(btn2)
      waitResponse()
      ZKSeleneseTestCase.assertEquals("value3 is empty", getText(lb42))
      //		findWidget("$btn2").click();
      //		Assert.assertEquals("",findWidget("$lb41").getValue());
      //		Assert.assertEquals("value3 is empty",findWidget("$lb42").getValue());

      `type`(tb41, "abc")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("", getText(lb41))
      ZKSeleneseTestCase.assertEquals("", getText(lb42))
      //		findWidget("$tb41").keys("abc").tab();
      //		Assert.assertEquals("",findWidget("$lb41").getValue());
      //		Assert.assertEquals("",findWidget("$lb42").getValue());

      `type`(tb41, "")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("", getText(lb41))
      ZKSeleneseTestCase.assertEquals("value3 is empty", getText(lb42))
      //		findWidget("$tb41").clear().tab();
      //		Assert.assertEquals("",findWidget("$lb41").getValue());
      //		Assert.assertEquals("value3 is empty",findWidget("$lb42").getValue());

      `type`(tb41, "abc")
      click(btn2)
      waitResponse()
      ZKSeleneseTestCase.assertEquals("", getText(lb41))
      ZKSeleneseTestCase.assertEquals("value4 is empty", getText(lb42))
      //		findWidget("$tb41").keys("abc").tab();
      //		findWidget("$btn2").click();
      //		Assert.assertEquals("",findWidget("$lb41").getValue());
      //		Assert.assertEquals("value4 is empty",findWidget("$lb42").getValue());

      `type`(tb42, "def")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("", getText(lb41))
      ZKSeleneseTestCase.assertEquals("", getText(lb42))
      //		findWidget("$tb42").keys("def").tab();
      //		Assert.assertEquals("",findWidget("$lb41").getValue());
      //		Assert.assertEquals("",findWidget("$lb42").getValue());

      click(btn2)
      waitResponse()
      ZKSeleneseTestCase.assertEquals("", getText(lb41))
      ZKSeleneseTestCase.assertEquals("value4 must euqlas to value 3", getText(lb42))
      //		findWidget("$btn2").click();
      //		Assert.assertEquals("",findWidget("$lb41").getValue());
      //		Assert.assertEquals("value4 must euqlas to value 3",findWidget("$lb42").getValue());

      `type`(tb42, "abc")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("", getText(lb41))
      ZKSeleneseTestCase.assertEquals("", getText(lb42))
      //		findWidget("$tb42").clear().keys("abc").tab();
      //		Assert.assertEquals("",findWidget("$lb41").getValue());
      //		Assert.assertEquals("",findWidget("$lb42").getValue());

      click(btn2)
      waitResponse()
      ZKSeleneseTestCase.assertEquals("abc", getText(lb41))
      ZKSeleneseTestCase.assertEquals("do Command2", getText(lb42))
      //		findWidget("$btn2").click();
      //		Assert.assertEquals("abc",findWidget("$lb41").getValue());
      //		Assert.assertEquals("do Command2",findWidget("$lb42").getValue());      

    })
  }
}
