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

import java.text.SimpleDateFormat
import java.util.Calendar

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.ZKSeleneseTestCase

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_ConverterTest extends ZTL4ScalaTestCase {
  def testBasic() = {
    val zul = {
      <include src="/bind/basic/converter.zul"/>
    }
    
    runZTL(zul, () => {
      var sdf = new SimpleDateFormat("yyyy/MM/dd");

      var c = Calendar.getInstance();
      c.setTime(sdf.parse("1975/02/13"));
      var age1 = "" + (Calendar.getInstance().get(Calendar.YEAR) - c.get(Calendar.YEAR));
      c.setTime(sdf.parse("1980/02/13"));
      var age2 = "" + (Calendar.getInstance().get(Calendar.YEAR) - c.get(Calendar.YEAR));
      c.setTime(sdf.parse("1985/02/13"));
      var age3 = "" + (Calendar.getInstance().get(Calendar.YEAR) - c.get(Calendar.YEAR));

      val t1 = engine $f "t1"
      val l1 = engine $f "l1"
      val t2 = engine $f "t2"
      val l2 = engine $f "l2"

      ZKSeleneseTestCase.assertEquals("1975/02/13", getValue(t1));
      ZKSeleneseTestCase.assertEquals(age1, getText(l1));
      ZKSeleneseTestCase.assertEquals("1975/02/13", getValue(t2));
      ZKSeleneseTestCase.assertEquals(age1, getText(l2));
      //      Assert.assertEquals("1975/02/13",findWidget("$t1").getAttribute("value"));
      //      Assert.assertEquals("36",findWidget("$l1").getAttribute("value"));
      //      Assert.assertEquals("1975/02/13",findWidget("$t2").getAttribute("value"));
      //      Assert.assertEquals("36",findWidget("$l2").getAttribute("value"));

      `type`(t1, "1980/02/AA")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("", getValue(t1));
      ZKSeleneseTestCase.assertEquals("0", getText(l1));
      ZKSeleneseTestCase.assertEquals("1975/02/13", getValue(t2));
      ZKSeleneseTestCase.assertEquals(age1, getText(l2));
      //      findWidget("$t1").clear().keys("1980/02/AA");
      //      findWidget("$saveForm").focus();
      //      Assert.assertEquals("",findWidget("$t1").getAttribute("value"));
      //      Assert.assertEquals("0",findWidget("$l1").getAttribute("value"));
      //      Assert.assertEquals("1975/02/13",findWidget("$t2").getAttribute("value"));
      //      Assert.assertEquals("36",findWidget("$l2").getAttribute("value"));

      `type`(t1, "1980/02/13")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("1980/02/13", getValue(t1));
      ZKSeleneseTestCase.assertEquals(age2, getText(l1));
      ZKSeleneseTestCase.assertEquals("1975/02/13", getValue(t2));
      ZKSeleneseTestCase.assertEquals(age1, getText(l2));
      //      findWidget("$t1").clear().keys("1980/02/13");
      //      findWidget("$saveForm").focus();
      //      Assert.assertEquals("1980/02/13",findWidget("$t1").getAttribute("value"));
      //      Assert.assertEquals("31",findWidget("$l1").getAttribute("value"));
      //      Assert.assertEquals("1975/02/13",findWidget("$t2").getAttribute("value"));
      //      Assert.assertEquals("36",findWidget("$l2").getAttribute("value"));

      `type`(t2, "1985/02/13")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("1980/02/13", getValue(t1));
      ZKSeleneseTestCase.assertEquals(age2, getText(l1));
      ZKSeleneseTestCase.assertEquals("1985/02/13", getValue(t2));
      ZKSeleneseTestCase.assertEquals(age1, getText(l2));
      //      findWidget("$t2").clear().keys("1985/02/13");
      //      findWidget("$saveForm").focus();
      //      Assert.assertEquals("1980/02/13",findWidget("$t1").getAttribute("value"));
      //      Assert.assertEquals("31",findWidget("$l1").getAttribute("value"));
      //      Assert.assertEquals("1985/02/13",findWidget("$t2").getAttribute("value"));
      //      Assert.assertEquals("36",findWidget("$l2").getAttribute("value"));

      click(engine $f "saveForm")
      waitResponse()
      ZKSeleneseTestCase.assertEquals("1985/02/13", getValue(t1));
      ZKSeleneseTestCase.assertEquals(age3, getText(l1));
      ZKSeleneseTestCase.assertEquals("1985/02/13", getValue(t2));
      ZKSeleneseTestCase.assertEquals(age3, getText(l2));
      //      findWidget("$saveForm").click();
      //      Assert.assertEquals("1985/02/13",findWidget("$t1").getAttribute("value"));
      //      Assert.assertEquals("26",findWidget("$l1").getAttribute("value"));
      //      Assert.assertEquals("1985/02/13",findWidget("$t2").getAttribute("value"));
      //      Assert.assertEquals("26",findWidget("$l2").getAttribute("value"));
    })
  }
}
