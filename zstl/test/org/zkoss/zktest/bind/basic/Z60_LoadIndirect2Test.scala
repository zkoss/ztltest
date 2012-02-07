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
import org.zkoss.ztl.ClientWidget

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_LoadIndirect2Test extends ZTL4ScalaTestCase {
  def testBasic() = {
    val zul = {
      <include src="/bind/basic/load-indirect.zul"/>
    }

    runZTL(zul, () => {
      val t1 = engine $f "l1"
      val l2 = engine $f "l2"
      val l3 = engine $f "l3"
      val l4 = engine $f "l4"
      val selectBox = (engine $f "select")

      ZKSeleneseTestCase.assertEquals("First1", getValue(t1));
      ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
      ZKSeleneseTestCase.assertEquals("First1 Last1", getText(l3));
      ZKSeleneseTestCase.assertEquals("First1", getText(l4));
      ZKSeleneseTestCase.assertEquals("0", getSelectedIndex(selectBox));
      //		Assert.assertEquals("First1",findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("First1 Last1",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("First1",findWidget("$l4").getAttribute("value"));
      //		Assert.assertEquals(0L,findWidget("$select").getAttribute("selectedIndex"));

      `type`(t1, "AAA")
      click(engine $f "btn1")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
      ZKSeleneseTestCase.assertEquals("AAA Last1", getText(l3));
      ZKSeleneseTestCase.assertEquals("AAA", getText(l4));
      //		findWidget("$l1").clear().keys("AAA");
      //		findWidget("$btn1").focus();
      //		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("AAA Last1",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("AAA",findWidget("$l4").getAttribute("value"));

      select(selectBox, "lastName")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("AAA", getValue(t1));
      ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
      ZKSeleneseTestCase.assertEquals("AAA Last1", getText(l3));
      ZKSeleneseTestCase.assertEquals("Last1", getText(l4));
      ZKSeleneseTestCase.assertEquals("1", getSelectedIndex(selectBox));
      //		((SelectWidget)findWidget("$select")).select(1);
      //		Assert.assertEquals("AAA",findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("AAA Last1",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("Last1",findWidget("$l4").getAttribute("value"));
      //		Assert.assertEquals(1L,findWidget("$select").getAttribute("selectedIndex"));

      `type`(t1, "BBB")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
      ZKSeleneseTestCase.assertEquals("BBB Last1", getText(l3));
      ZKSeleneseTestCase.assertEquals("Last1", getText(l4));
      //		findWidget("$l1").clear().keys("BBB");
      //		findWidget("$btn1").focus();
      //		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("BBB Last1",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("Last1",findWidget("$l4").getAttribute("value"));

      select(selectBox, "fullName")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("BBB", getValue(t1));
      ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
      ZKSeleneseTestCase.assertEquals("BBB Last1", getText(l3));
      ZKSeleneseTestCase.assertEquals("BBB Last1", getText(l4));
      ZKSeleneseTestCase.assertEquals("2", getSelectedIndex(selectBox));
      //		((SelectWidget)findWidget("$select")).select(2);
      //		Assert.assertEquals("BBB",findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("BBB Last1",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("BBB Last1",findWidget("$l4").getAttribute("value"));
      //		Assert.assertEquals(2L,findWidget("$select").getAttribute("selectedIndex"));

      select(selectBox, "firstName")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("BBB", getValue(t1));
      ZKSeleneseTestCase.assertEquals("Last1", getText(l2));
      ZKSeleneseTestCase.assertEquals("BBB Last1", getText(l3));
      ZKSeleneseTestCase.assertEquals("BBB", getText(l4));
      ZKSeleneseTestCase.assertEquals("0", getSelectedIndex(selectBox));
      //		((SelectWidget)findWidget("$select")).select(0);
      //		Assert.assertEquals("BBB",findWidget("$l1").getAttribute("value"));
      //		Assert.assertEquals("Last1",findWidget("$l2").getAttribute("value"));
      //		Assert.assertEquals("BBB Last1",findWidget("$l3").getAttribute("value"));
      //		Assert.assertEquals("BBB",findWidget("$l4").getAttribute("value"));
      //		Assert.assertEquals(0L,findWidget("$select").getAttribute("selectedIndex"));

    })
  }
}
