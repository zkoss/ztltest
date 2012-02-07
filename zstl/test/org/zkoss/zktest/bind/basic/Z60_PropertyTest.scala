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
class Z60_PropertyTest extends ZTL4ScalaTestCase {
  def testBasic() = {
    val zul = {
      <include src="/bind/basic/property.zul"/>
    }
    runZTL(zul, () => {
      val t1 = engine $f "t1"
      val l1 = engine $f "l1"
      val l1x = engine $f "l1x"
      ZKSeleneseTestCase.assertEquals("A", getValue(t1));
      ZKSeleneseTestCase.assertEquals("A", getText(l1));
      ZKSeleneseTestCase.assertEquals("", getText(l1x));
      //		Assert.assertEquals("A",findWidget("$t1").getAttribute("value"));
      //		Assert.assertEquals("A",findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("",findWidget("$l1x").getAttribute("value"));

      typeKeys(t1, "XX")
      waitResponse()
      //FIXME XX or AXX
      ZKSeleneseTestCase.assertEquals("AXX", getValue(t1));
      ZKSeleneseTestCase.assertEquals("AXX", getText(l1));
      ZKSeleneseTestCase.assertEquals("", getText(l1x));
      //		findWidget("$t1").keys("XX");
      //		findWidget("$cmd1").focus();
      //		Assert.assertEquals("AXX",findWidget("$t1").getAttribute("value"));
      //		Assert.assertEquals("AXX",findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("",findWidget("$l1x").getAttribute("value"));

      click(engine $f "cmd1")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("AXX", getValue(t1));
      ZKSeleneseTestCase.assertEquals("AXX", getText(l1));
      ZKSeleneseTestCase.assertEquals("AXX", getText(l1x));
      //		findWidget("$cmd1").click();
      //		Assert.assertEquals("AXX",findWidget("$t1").getAttribute("value"));
      //		Assert.assertEquals("AXX",findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("AXX",findWidget("$l1x").getAttribute("value"));

      //test 2
      val t2 = engine $f "t2"
      val l2 = engine $f "l2"
      val l2x = engine $f "l2x"
      ZKSeleneseTestCase.assertEquals("", getValue(t2));
      ZKSeleneseTestCase.assertEquals("B", getText(l2));
      ZKSeleneseTestCase.assertEquals("", getText(l2x));
      //		Assert.assertEquals("",findWidget("$t2").getAttribute("value"));
      //		Assert.assertEquals("B",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("",findWidget("$l2x").getAttribute("value"));

      `type`(t2, "YY")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("YY", getValue(t2));
      ZKSeleneseTestCase.assertEquals("YY", getText(l2));
      ZKSeleneseTestCase.assertEquals("", getText(l2x));
      //		findWidget("$t2").keys("YY");
      //		findWidget("$cmd2").focus();
      //		Assert.assertEquals("YY",findWidget("$t2").getAttribute("value"));
      //		Assert.assertEquals("YY",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("",findWidget("$l2x").getAttribute("value"));

      click(engine $f "cmd2")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("YY-by-cmd2", getValue(t2));
      ZKSeleneseTestCase.assertEquals("YY", getText(l2));
      ZKSeleneseTestCase.assertEquals("YY-by-cmd2", getText(l2x));
      //		findWidget("$cmd2").click();
      //		Assert.assertEquals("YY-by-cmd2",findWidget("$t2").getAttribute("value"));
      //		Assert.assertEquals("YY",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("YY-by-cmd2",findWidget("$l2x").getAttribute("value"));

      //test 3
      val t3 = engine $f "t3"
      val l3 = engine $f "l3"
      val l3x = engine $f "l3x"
      ZKSeleneseTestCase.assertEquals("C", getValue(t3));
      ZKSeleneseTestCase.assertEquals("", getText(l3));
      ZKSeleneseTestCase.assertEquals("", getText(l3x));
      //		Assert.assertEquals("C",findWidget("$t3").getAttribute("value"));
      //		Assert.assertEquals("",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("",findWidget("$l3x").getAttribute("value"));

      typeKeys(t3, "ZZ")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("CZZ", getValue(t3));
      ZKSeleneseTestCase.assertEquals("", getText(l3));
      ZKSeleneseTestCase.assertEquals("", getText(l3x));
      //		findWidget("$t3").keys("ZZ");
      //		findWidget("$cmd3").focus();
      //		Assert.assertEquals("CZZ",findWidget("$t3").getAttribute("value"));
      //		Assert.assertEquals("",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("",findWidget("$l3x").getAttribute("value"));

      click(engine $f "cmd3")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("CZZ-by-cmd3", getValue(t3));
      ZKSeleneseTestCase.assertEquals("CZZ", getText(l3));
      ZKSeleneseTestCase.assertEquals("CZZ-by-cmd3", getText(l3x));
      //		findWidget("$cmd3").click();
      //		Assert.assertEquals("CZZ-by-cmd3",findWidget("$t3").getAttribute("value"));
      //		Assert.assertEquals("CZZ",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("CZZ-by-cmd3",findWidget("$l3x").getAttribute("value"));

      `type`(t3, "GG")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("GG", getValue(t3));
      ZKSeleneseTestCase.assertEquals("CZZ", getText(l3));
      ZKSeleneseTestCase.assertEquals("CZZ-by-cmd3", getText(l3x));
      //		findWidget("$t3").clear().keys("GG");
      //		findWidget("$cmd3").focus();
      //		Assert.assertEquals("GG",findWidget("$t3").getAttribute("value"));
      //		Assert.assertEquals("CZZ",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("CZZ-by-cmd3",findWidget("$l3x").getAttribute("value"));

      click(engine $f "change3")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("CZZ-by-cmd3-by-change3", getValue(t3));
      ZKSeleneseTestCase.assertEquals("CZZ", getText(l3));
      ZKSeleneseTestCase.assertEquals("CZZ-by-cmd3", getText(l3x));
      //		findWidget("$change3").click();
      //		Assert.assertEquals("CZZ-by-cmd3-by-change3",findWidget("$t3").getAttribute("value"));
      //		Assert.assertEquals("CZZ",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("CZZ-by-cmd3",findWidget("$l3x").getAttribute("value"));      
    })
  }
}
