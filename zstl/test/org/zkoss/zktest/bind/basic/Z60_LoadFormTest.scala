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
import org.zkoss.ztl.ZKSeleneseTestCase

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_LoadFormTest extends ZTL4ScalaTestCase {
  def testBasic() = {
    val zul = {
      <include src="/bind/basic/load-form.zul"/>
    }

    runZTL(zul, () => {
      val t1 = engine $f "l1"
      val l2 = engine $f "l2"
      val l3 = engine $f "l3"
      val t5 = engine $f "l5"
      val l6 = engine $f "l6"
      val l7 = engine $f "l7"
      val t9 = engine $f "l9"
      val la = engine $f "la"
      val lb = engine $f "lb"

      ZKSeleneseTestCase.assertEquals("First1", getValue(t1));
      ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
      ZKSeleneseTestCase.assertEquals("First1 Last1", getText(l3));
      ZKSeleneseTestCase.assertEquals("First1", getValue(t5));
      ZKSeleneseTestCase.assertEquals("Last1", getText(l6));
      ZKSeleneseTestCase.assertEquals("First1 Last1", getText(l7));
      ZKSeleneseTestCase.assertEquals("", getValue(t9));
      ZKSeleneseTestCase.assertEquals("", getText(la));
      ZKSeleneseTestCase.assertEquals("", getText(lb));
      //		Assert.assertEquals("First1", findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("First1 Last1",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("First1", findWidget("$l5").getAttribute("value"));
      //		Assert.assertEquals("Last1", findWidget("$l6").getAttribute("value"));
      //		Assert.assertEquals("First1 Last1", findWidget("$l7").getAttribute("value"));
      //		Assert.assertEquals("", findWidget("$l9").getAttribute("value"));
      //		Assert.assertEquals("", findWidget("$la").getAttribute("value"));
      //		Assert.assertEquals("", findWidget("$lb").getAttribute("value"));

      `type`(t1, "XXX")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("XXX", getValue(t1));
      ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
      ZKSeleneseTestCase.assertEquals("XXX Last1", getText(l3));
      //		findWidget("$l1").clear().keys("XXX");
      //		findWidget("$btn1").focus();
      //		Assert.assertEquals("XXX", findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("XXX Last1", findWidget("$l3")
      //				.getAttribute("value"));

      // spec change, p1.first change will not effect p1 -> fx
      ZKSeleneseTestCase.assertEquals("First1", getValue(t5));
      ZKSeleneseTestCase.assertEquals("Last1", getText(l6));
      ZKSeleneseTestCase.assertEquals("First1 Last1", getText(l7));
      ZKSeleneseTestCase.assertEquals("", getValue(t9));
      ZKSeleneseTestCase.assertEquals("", getText(la));
      ZKSeleneseTestCase.assertEquals("", getText(lb));
      //		Assert.assertEquals("First1", findWidget("$l5").getAttribute("value"));
      //		Assert.assertEquals("Last1", findWidget("$l6").getAttribute("value"));
      //		Assert.assertEquals("First1 Last1",	findWidget("$l7").getAttribute("value"));
      //		Assert.assertEquals("", findWidget("$l9").getAttribute("value"));
      //		Assert.assertEquals("", findWidget("$la").getAttribute("value"));
      //		Assert.assertEquals("", findWidget("$lb").getAttribute("value"));

      `type`(t5, "YYY")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("XXX", getValue(t1));
      ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
      ZKSeleneseTestCase.assertEquals("XXX Last1", getText(l3));
      ZKSeleneseTestCase.assertEquals("YYY", getValue(t5));
      ZKSeleneseTestCase.assertEquals("Last1", getText(l6));
      ZKSeleneseTestCase.assertEquals("First1 Last1", getText(l7));
      ZKSeleneseTestCase.assertEquals("", getValue(t9));
      ZKSeleneseTestCase.assertEquals("", getText(la));
      ZKSeleneseTestCase.assertEquals("", getText(lb));
      //		findWidget("$l5").clear().keys("YYY");
      //		findWidget("$btn1").focus();
      //		Assert.assertEquals("XXX", findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("XXX Last1", findWidget("$l3")
      //				.getAttribute("value"));
      //		Assert.assertEquals("YYY", findWidget("$l5").getAttribute("value"));
      //		Assert.assertEquals("Last1", findWidget("$l6").getAttribute("value"));
      //		Assert.assertEquals("First1 Last1",	findWidget("$l7").getAttribute("value"));
      //		Assert.assertEquals("", findWidget("$l9").getAttribute("value"));
      //		Assert.assertEquals("", findWidget("$la").getAttribute("value"));
      //		Assert.assertEquals("", findWidget("$lb").getAttribute("value"));

      click(engine $f "btn1")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("YYY", getValue(t1));
      ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
      ZKSeleneseTestCase.assertEquals("YYY Last1", getText(l3));
      ZKSeleneseTestCase.assertEquals("YYY", getValue(t5));
      ZKSeleneseTestCase.assertEquals("Last1", getText(l6));
      ZKSeleneseTestCase.assertEquals("YYY Last1", getText(l7));
      ZKSeleneseTestCase.assertEquals("YYY", getValue(t9));
      ZKSeleneseTestCase.assertEquals("Last1", getText(la));
      ZKSeleneseTestCase.assertEquals("YYY Last1", getText(lb));
      //		findWidget("$btn1").click();
      //		Assert.assertEquals("YYY", findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Last1", findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("YYY Last1", findWidget("$l3")
      //				.getAttribute("value"));
      //		Assert.assertEquals("YYY", findWidget("$l5").getAttribute("value"));
      //		Assert.assertEquals("Last1", findWidget("$l6").getAttribute("value"));
      //		Assert.assertEquals("YYY Last1", findWidget("$l7")
      //				.getAttribute("value"));
      //		Assert.assertEquals("YYY", findWidget("$l9").getAttribute("value"));
      //		Assert.assertEquals("Last1", findWidget("$la").getAttribute("value"));
      //		Assert.assertEquals("YYY Last1", findWidget("$lb")
      //				.getAttribute("value"));
    })
  }
}
