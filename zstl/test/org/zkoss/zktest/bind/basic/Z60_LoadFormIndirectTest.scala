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

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_LoadFormIndirectTest extends ZTL4ScalaTestCase {
  def testBasic() = {
    val zul = """
      <include src="/bind/basic/load-form-indirect.zul"/>
"""
    
    runZTL(zul, () => {
      val t1 = engine $f "l1"
      val l2 = engine $f "l2"
      val l3 = engine $f "l3"
      val l4 = engine $f "l4"
      val l5 = engine $f "l5"
      val t6 = engine $f "l6"
      val l7 = engine $f "l7"
      val l8 = engine $f "l8"

      ZKSeleneseTestCase.assertEquals("First1", getValue(t1));
      ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
      ZKSeleneseTestCase.assertEquals("First1 Last1", getText(l3));
      ZKSeleneseTestCase.assertEquals("First1", getText(l4));
      ZKSeleneseTestCase.assertEquals("First1", getText(l5));
      ZKSeleneseTestCase.assertEquals("", getValue(t6));
      ZKSeleneseTestCase.assertEquals("", getText(l7));
      ZKSeleneseTestCase.assertEquals("", getText(l8));
      //    	Assert.assertEquals("First1", findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("First1 Last1",	findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("First1", findWidget("$l4").getAttribute("value"));
      //		Assert.assertEquals("First1", findWidget("$l5").getAttribute("value"));
      //		Assert.assertEquals("", findWidget("$l6").getAttribute("value"));
      //		Assert.assertEquals("", findWidget("$l7").getAttribute("value"));
      //		Assert.assertEquals("", findWidget("$l8").getAttribute("value"));

      `type`(t1, "XXX")
      val btn1 = engine $f "btn1"
      click(btn1)
      waitResponse()
      ZKSeleneseTestCase.assertEquals("XXX", getValue(t1));
      ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
      ZKSeleneseTestCase.assertEquals("First1 Last1", getText(l3));
      ZKSeleneseTestCase.assertEquals("XXX", getText(l4));
      ZKSeleneseTestCase.assertEquals("First1", getText(l5));
      ZKSeleneseTestCase.assertEquals("", getValue(t6));
      ZKSeleneseTestCase.assertEquals("", getText(l7));
      ZKSeleneseTestCase.assertEquals("", getText(l8));
      //		findWidget("$l1").clear().keys("XXX");
      //		findWidget("$btn1").focus();
      //		Assert.assertEquals("XXX", findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("First1 Last1",	findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("First1", findWidget("$l4").getAttribute("value"));
      //		Assert.assertEquals("First1", findWidget("$l5").getAttribute("value"));
      //		Assert.assertEquals("", findWidget("$l6").getAttribute("value"));
      //		Assert.assertEquals("", findWidget("$l7").getAttribute("value"));
      //		Assert.assertEquals("", findWidget("$l8").getAttribute("value"));

      val btn2 = engine $f "btn2"
      click(btn2)
      waitResponse()
      ZKSeleneseTestCase.assertEquals("Last1", getText(l4));
      ZKSeleneseTestCase.assertEquals("Last1", getText(l5));
      ZKSeleneseTestCase.assertEquals("", getText(l8));
      //		findWidget("$btn2").click();
      //		Assert.assertEquals("First1", findWidget("$l4").getAttribute("value"));
      //		Assert.assertEquals("Last1", findWidget("$l5").getAttribute("value"));
      //		Assert.assertEquals("", findWidget("$l8").getAttribute("value"));

      val btn3 = engine $f "btn3"
      click(btn3)
      waitResponse()
      ZKSeleneseTestCase.assertEquals("First1 Last1", getText(l4));
      ZKSeleneseTestCase.assertEquals("First1 Last1", getText(l5));
      ZKSeleneseTestCase.assertEquals("", getText(l8));
      //		findWidget("$btn3").click();
      //		Assert.assertEquals("First1", findWidget("$l4").getAttribute("value"));
      //		Assert.assertEquals("First1 Last1",
      //				findWidget("$l5").getAttribute("value"));
      //		Assert.assertEquals("", findWidget("$l8").getAttribute("value"));

      val btn4 = engine $f "btn4"
      click(btn4)
      waitResponse()
      ZKSeleneseTestCase.assertEquals("XXX", getValue(t1));
      ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
      ZKSeleneseTestCase.assertEquals("XXX Last1", getText(l3));
      ZKSeleneseTestCase.assertEquals("XXX Last1", getText(l4));
      ZKSeleneseTestCase.assertEquals("XXX Last1", getText(l5));
      ZKSeleneseTestCase.assertEquals("XXX", getValue(t6));
      ZKSeleneseTestCase.assertEquals("Last1", getText(l7));
      ZKSeleneseTestCase.assertEquals("XXX Last1", getText(l8));
      //    	findWidget("$btn4").click();
      //		Assert.assertEquals("XXX", findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("XXX Last1", findWidget("$l3")
      //				.getAttribute("value"));
      //		Assert.assertEquals("XXX Last1", findWidget("$l4")
      //				.getAttribute("value"));
      //		Assert.assertEquals("XXX Last1", findWidget("$l5")
      //				.getAttribute("value"));
      //		Assert.assertEquals("XXX", findWidget("$l6").getAttribute("value"));
      //		Assert.assertEquals("Last1", findWidget("$l7").getAttribute("value"));
      //		Assert.assertEquals("XXX Last1", findWidget("$l8")
      //				.getAttribute("value"));

      `type`(t1, "YYY")
      click(btn1)
      waitResponse()
      ZKSeleneseTestCase.assertEquals("YYY", getText(l4));
      ZKSeleneseTestCase.assertEquals("XXX", getText(l5));
      ZKSeleneseTestCase.assertEquals("XXX Last1", getText(l8));
      //		findWidget("$l1").clear().keys("YYY");
      //		findWidget("$btn1").focus();
      //		findWidget("$btn1").click();
      //		Assert.assertEquals("XXX Last1", findWidget("$l4").getAttribute("value"));
      //		Assert.assertEquals("XXX", findWidget("$l5").getAttribute("value"));
      //		Assert.assertEquals("XXX Last1", findWidget("$l8").getAttribute("value"));

      click(btn4)
      waitResponse()
      ZKSeleneseTestCase.assertEquals("YYY", getValue(t1));
      ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
      ZKSeleneseTestCase.assertEquals("YYY Last1", getText(l3));
      ZKSeleneseTestCase.assertEquals("YYY", getText(l4));
      ZKSeleneseTestCase.assertEquals("YYY", getText(l5));
      ZKSeleneseTestCase.assertEquals("YYY", getValue(t6));
      ZKSeleneseTestCase.assertEquals("Last1", getText(l7));
      ZKSeleneseTestCase.assertEquals("YYY Last1", getText(l8));
      //    	findWidget("$btn4").click();
      //		Assert.assertEquals("YYY", findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("YYY Last1", findWidget("$l3")
      //				.getAttribute("value"));
      //		Assert.assertEquals("YYY", findWidget("$l4").getAttribute("value"));
      //		Assert.assertEquals("YYY", findWidget("$l5").getAttribute("value"));
      //
      //		Assert.assertEquals("YYY", findWidget("$l6").getAttribute("value"));
      //		Assert.assertEquals("Last1", findWidget("$l7").getAttribute("value"));
      //		Assert.assertEquals("YYY Last1", findWidget("$l8")
      //				.getAttribute("value"));

    })
  }
}
