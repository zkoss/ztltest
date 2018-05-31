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
import org.zkoss.ztl.{Tags, ZKSeleneseTestCase}

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_ValidationTest extends ZTL4ScalaTestCase {
  def testBasic() = {
    val zul = """
      <include src="/bind/basic/validation.zul"/>
"""

    runZTL(zul, () => {
      val l11 = engine $f "l11"
      val l12 = engine $f "l12"
      val t21 = engine $f "t21"
      val t22 = engine $f "t22"
      val t31 = engine $f "t31"
      val t32 = engine $f "t32"
      val msg1 = engine $f "msg1"
      val msg2 = engine $f "msg2"

      ZKSeleneseTestCase.assertEquals("0", getText(l11));
      ZKSeleneseTestCase.assertEquals("", getText(l12));
      ZKSeleneseTestCase.assertEquals("0", getValue(t21));
      ZKSeleneseTestCase.assertEquals("", getValue(t22));
      ZKSeleneseTestCase.assertEquals("0", getValue(t31));
      ZKSeleneseTestCase.assertEquals("", getValue(t32));
      ZKSeleneseTestCase.assertEquals("", getText(msg1));
      ZKSeleneseTestCase.assertEquals("", getText(msg2));
      //    	Assert.assertEquals("0", findWidget("$l11").getValue());
      //		Assert.assertEquals("", findWidget("$l12").getValue());
      //		Assert.assertEquals("0", findWidget("$t21").getValue());
      //		Assert.assertEquals("", findWidget("$t22").getValue());
      //		Assert.assertEquals("0", findWidget("$t31").getValue());
      //		Assert.assertEquals("", findWidget("$t32").getValue());
      //		Assert.assertEquals("", findWidget("$msg1").getValue());
      //		Assert.assertEquals("", findWidget("$msg2").getValue());

      `type`(t31, "1")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("0", getText(l11));
      ZKSeleneseTestCase.assertEquals("", getText(l12));
      ZKSeleneseTestCase.assertEquals("0", getValue(t21));
      ZKSeleneseTestCase.assertEquals("", getValue(t22));
      ZKSeleneseTestCase.assertEquals("1", getValue(t31));
      ZKSeleneseTestCase.assertEquals("", getValue(t32));
      ZKSeleneseTestCase.assertEquals("", getText(msg1));
      ZKSeleneseTestCase.assertEquals("", getText(msg2));
      //		findWidget("$t31").clear().keys("1").tab();
      //		Assert.assertEquals("0", findWidget("$l11").getValue());
      //		Assert.assertEquals("", findWidget("$l12").getValue());
      //		Assert.assertEquals("0", findWidget("$t21").getValue());
      //		Assert.assertEquals("", findWidget("$t22").getValue());
      //		Assert.assertEquals("1", findWidget("$t31").getValue());
      //		Assert.assertEquals("", findWidget("$t32").getValue());
      //		Assert.assertEquals("", findWidget("$msg1").getValue());
      //		Assert.assertEquals("", findWidget("$msg2").getValue());

      `type`(t32, "3")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("0", getText(l11));
      ZKSeleneseTestCase.assertEquals("", getText(l12));
      ZKSeleneseTestCase.assertEquals("0", getValue(t21));
      ZKSeleneseTestCase.assertEquals("", getValue(t22));
      ZKSeleneseTestCase.assertEquals("1", getValue(t31));
      ZKSeleneseTestCase.assertEquals("3", getValue(t32));
      ZKSeleneseTestCase.assertEquals("", getText(msg1));
      ZKSeleneseTestCase.assertEquals("", getText(msg2));
      //    	findWidget("$t32").clear().keys("3").tab();
      //		Assert.assertEquals("0", findWidget("$l11").getValue());
      //		Assert.assertEquals("", findWidget("$l12").getValue());
      //		Assert.assertEquals("0", findWidget("$t21").getValue());
      //		Assert.assertEquals("", findWidget("$t22").getValue());
      //		Assert.assertEquals("1", findWidget("$t31").getValue());
      //		Assert.assertEquals("3", findWidget("$t32").getValue());
      //		Assert.assertEquals("", findWidget("$msg1").getValue());
      //		Assert.assertEquals("", findWidget("$msg2").getValue());

      val btn1 = engine $f "btn1"
      click(btn1)
      waitResponse()
      ZKSeleneseTestCase.assertEquals("0", getText(l11));
      ZKSeleneseTestCase.assertEquals("", getText(l12));
      ZKSeleneseTestCase.assertEquals("0", getValue(t21));
      ZKSeleneseTestCase.assertEquals("", getValue(t22));
      ZKSeleneseTestCase.assertEquals("1", getValue(t31));
      ZKSeleneseTestCase.assertEquals("3", getValue(t32));
      ZKSeleneseTestCase.assertEquals("value 1 have to large than 10", getText(msg1));
      ZKSeleneseTestCase.assertEquals("", getText(msg2));
      //    	findWidget("$btn1").click();
      //		Assert.assertEquals("0", findWidget("$l11").getValue());
      //		Assert.assertEquals("", findWidget("$l12").getValue());
      //		Assert.assertEquals("0", findWidget("$t21").getValue());
      //		Assert.assertEquals("", findWidget("$t22").getValue());
      //		Assert.assertEquals("1", findWidget("$t31").getValue());
      //		Assert.assertEquals("3", findWidget("$t32").getValue());
      //		Assert.assertEquals("value 1 have to large than 10",
      //				findWidget("$msg1").getValue());
      //		Assert.assertEquals("", findWidget("$msg2").getValue());

      `type`(t31, "15")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("0", getText(l11));
      ZKSeleneseTestCase.assertEquals("", getText(l12));
      ZKSeleneseTestCase.assertEquals("0", getValue(t21));
      ZKSeleneseTestCase.assertEquals("", getValue(t22));
      ZKSeleneseTestCase.assertEquals("15", getValue(t31));
      ZKSeleneseTestCase.assertEquals("3", getValue(t32));
      ZKSeleneseTestCase.assertEquals("value 1 have to large than 10", getText(msg1));
      ZKSeleneseTestCase.assertEquals("", getText(msg2));
      //		findWidget("$t31").clear().keys("15").tab();
      //		Assert.assertEquals("0", findWidget("$l11").getValue());
      //		Assert.assertEquals("", findWidget("$l12").getValue());
      //		Assert.assertEquals("0", findWidget("$t21").getValue());
      //		Assert.assertEquals("", findWidget("$t22").getValue());
      //		Assert.assertEquals("15", findWidget("$t31").getValue());
      //		Assert.assertEquals("3", findWidget("$t32").getValue());
      //		Assert.assertEquals("value 1 have to large than 10",
      //				findWidget("$msg1").getValue());
      //		Assert.assertEquals("", findWidget("$msg2").getValue());

      click(btn1)
      waitResponse()
      ZKSeleneseTestCase.assertEquals("0", getText(l11));
      ZKSeleneseTestCase.assertEquals("", getText(l12));
      ZKSeleneseTestCase.assertEquals("0", getValue(t21));
      ZKSeleneseTestCase.assertEquals("", getValue(t22));
      ZKSeleneseTestCase.assertEquals("15", getValue(t31));
      ZKSeleneseTestCase.assertEquals("3", getValue(t32));
      ZKSeleneseTestCase.assertEquals("", getText(msg1));
      ZKSeleneseTestCase.assertEquals("value 2 have to large than 20", getText(msg2));
      //		findWidget("$btn1").click();
      //		Assert.assertEquals("0", findWidget("$l11").getValue());
      //		Assert.assertEquals("", findWidget("$l12").getValue());
      //		Assert.assertEquals("0", findWidget("$t21").getValue());
      //		Assert.assertEquals("", findWidget("$t22").getValue());
      //		Assert.assertEquals("15", findWidget("$t31").getValue());
      //		Assert.assertEquals("3", findWidget("$t32").getValue());
      //		Assert.assertEquals("", findWidget("$msg1").getValue());
      //		Assert.assertEquals("value 2 have to large than 20",
      //				findWidget("$msg2").getValue());

      `type`(t32, "35")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("0", getText(l11));
      ZKSeleneseTestCase.assertEquals("", getText(l12));
      ZKSeleneseTestCase.assertEquals("0", getValue(t21));
      ZKSeleneseTestCase.assertEquals("", getValue(t22));
      ZKSeleneseTestCase.assertEquals("15", getValue(t31));
      ZKSeleneseTestCase.assertEquals("35", getValue(t32));
      ZKSeleneseTestCase.assertEquals("", getText(msg1));
      ZKSeleneseTestCase.assertEquals("value 2 have to large than 20", getText(msg2));
      //		findWidget("$t32").clear().keys("35").tab();
      //		Assert.assertEquals("0", findWidget("$l11").getValue());
      //		Assert.assertEquals("", findWidget("$l12").getValue());
      //		Assert.assertEquals("0", findWidget("$t21").getValue());
      //		Assert.assertEquals("", findWidget("$t22").getValue());
      //		Assert.assertEquals("15", findWidget("$t31").getValue());
      //		Assert.assertEquals("35", findWidget("$t32").getValue());
      //		Assert.assertEquals("", findWidget("$msg1").getValue());
      //		Assert.assertEquals("value 2 have to large than 20",
      //				findWidget("$msg2").getValue());

      click(btn1)
      waitResponse()
      ZKSeleneseTestCase.assertEquals("15", getText(l11));
      ZKSeleneseTestCase.assertEquals("35", getText(l12));
      ZKSeleneseTestCase.assertEquals("15", getValue(t21));
      ZKSeleneseTestCase.assertEquals("35", getValue(t22));
      ZKSeleneseTestCase.assertEquals("15", getValue(t31));
      ZKSeleneseTestCase.assertEquals("35", getValue(t32));
      ZKSeleneseTestCase.assertEquals("", getText(msg1));
      ZKSeleneseTestCase.assertEquals("", getText(msg2));
      //		findWidget("$btn1").click();
      //		Assert.assertEquals("15", findWidget("$l11").getValue());
      //		Assert.assertEquals("35", findWidget("$l12").getValue());
      //		Assert.assertEquals("15", findWidget("$t21").getValue());
      //		Assert.assertEquals("35", findWidget("$t22").getValue());
      //		Assert.assertEquals("15", findWidget("$t31").getValue());
      //		Assert.assertEquals("35", findWidget("$t32").getValue());
      //		Assert.assertEquals("", findWidget("$msg1").getValue());
      //		Assert.assertEquals("", findWidget("$msg2").getValue());

    })
  }
}
