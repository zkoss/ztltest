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
import org.junit.Test
import org.openqa.selenium.Keys

/**
  * @author Hawk
  *
  */
@Tags(tags = "zbind")
class Z60_PropertyTest extends ZTL4ScalaTestCase {
  @Test
  def testBasic() = {
    val zul =
      """
      <include src="/bind/basic/property.zul"/>
"""
//    runZTL(zul, () => {
//      val t1 = engine $f "t1"
//      val l1 = engine $f "l1"
//      val l1x = engine $f "l1x"
//      var str = "AXX"
//      verifyEquals("A", getValue(t1))
//      verifyEquals("A", getText(l1))
//      verifyEquals("", getText(l1x))
//
//      sendKeys(t1, Keys.END + "XX" + Keys.TAB)
//      waitResponse()
//      if (isIE) {
//        str = "XXA"
//      }
//      verifyEquals(str, getValue(t1));
//      verifyEquals(str, getText(l1));
//      verifyEquals("", getText(l1x));
//
//      click(engine $f "cmd1")
//      waitResponse()
//      verifyEquals(str, getValue(t1));
//      verifyEquals(str, getText(l1));
//      verifyEquals(str, getText(l1x));
//
//      //test 2
//      val t2 = engine $f "t2"
//      val l2 = engine $f "l2"
//      val l2x = engine $f "l2x"
//      verifyEquals("", getValue(t2));
//      verifyEquals("B", getText(l2));
//      verifyEquals("", getText(l2x));
//
//      `type`(t2, "YY")
//      waitResponse()
//      verifyEquals("YY", getValue(t2));
//      verifyEquals("YY", getText(l2));
//      verifyEquals("", getText(l2x));
//
//      click(engine $f "cmd2")
//      waitResponse()
//      verifyEquals("YY-by-cmd2", getValue(t2));
//      verifyEquals("YY", getText(l2));
//      verifyEquals("YY-by-cmd2", getText(l2x));
//
//      //test 3
//      val t3 = engine $f "t3"
//      val l3 = engine $f "l3"
//      val l3x = engine $f "l3x"
//      if (isIE)
//        str = "ZZC"
//      else
//        str = "CZZ"
//      verifyEquals("C", getValue(t3));
//      verifyEquals("", getText(l3));
//      verifyEquals("", getText(l3x));
//
//      sendKeys(t3, Keys.END + "ZZ")
//      waitResponse()
//      verifyEquals(str, getValue(t3));
//      verifyEquals("", getText(l3));
//      verifyEquals("", getText(l3x));
//
//      click(engine $f "cmd3")
//      waitResponse()
//      verifyEquals(str + "-by-cmd3", getValue(t3));
//      verifyEquals(str, getText(l3));
//      verifyEquals(str + "-by-cmd3", getText(l3x));
//
//      `type`(t3, "GG")
//      waitResponse()
//      verifyEquals("GG", getValue(t3));
//      verifyEquals(str, getText(l3));
//      verifyEquals(str + "-by-cmd3", getText(l3x));
//
//      click(engine $f "change3")
//      waitResponse()
//      verifyEquals(str + "-by-cmd3-by-change3", getValue(t3));
//      verifyEquals(str, getText(l3));
//      verifyEquals(str + "-by-cmd3", getText(l3x));
//    })
  }
}
