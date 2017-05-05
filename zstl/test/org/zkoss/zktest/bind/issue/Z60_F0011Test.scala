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

import java.text.SimpleDateFormat
import java.util.Date

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.ZKSeleneseTestCase

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_F0011Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = """
      <include src="/bind/issue/F0011.zul"/>
"""

    runZTL(zul, () => {
      val sdf = new SimpleDateFormat("yyyy/MM/dd");
      var now = new Date()
      val today = sdf.format(now).toString();
      val yesterday = sdf.format(new Date(now.getTime() - 1000 * 60 * 60 * 24)).toString();
      val tomorrow = sdf.format(new Date(now.getTime() + 1000 * 60 * 60 * 24));

      val db1 = engine $f "db1"
      val lb11 = engine $f "lb11"
      val lb12 = engine $f "lb12"
      //validate date1
      ZKSeleneseTestCase.assertEquals(today, getValue(db1.$n("real")))
      ZKSeleneseTestCase.assertEquals(today, getText(lb11))
      ZKSeleneseTestCase.assertEquals("", getText(lb12))

      //		Assert.assertEquals(today,findWidget("$db1").getText());
      //		Assert.assertEquals(today,findWidget("$lb11").getValue());
      //		Assert.assertEquals("",findWidget("$lb12").getValue());

      `type`(db1.$n("real"), tomorrow)
      waitResponse()
      ZKSeleneseTestCase.assertEquals(tomorrow, getValue(db1.$n("real")))
      ZKSeleneseTestCase.assertEquals(today, getText(lb11))
      ZKSeleneseTestCase.assertEquals("date bday1 must small than today", getText(lb12))
      //		findWidget("$db1").clear().keys(tomorrow).tab();
      //		Assert.assertEquals(tomorrow,findWidget("$db1").getText());
      //		Assert.assertEquals(today,findWidget("$lb11").getValue());
      //		Assert.assertEquals("date bday1 must small than today",findWidget("$lb12").getValue());
      `type`(db1.$n("real"), yesterday)
      waitResponse()
      ZKSeleneseTestCase.assertEquals(yesterday, getValue(db1.$n("real")))
      ZKSeleneseTestCase.assertEquals(yesterday, getText(lb11))
      ZKSeleneseTestCase.assertEquals("", getText(lb12))
      //		findWidget("$db1").clear().keys(yesterday).tab();
      //		Assert.assertEquals(yesterday,findWidget("$db1").getText());
      //		Assert.assertEquals(yesterday,findWidget("$lb11").getValue());
      //		Assert.assertEquals("",findWidget("$lb12").getValue());
      //validate date2
      val db2 = engine $f "db2"
      val lb21 = engine $f "lb21"
      val lb22 = engine $f "lb22"
      ZKSeleneseTestCase.assertEquals("", getValue(db2.$n("real")))
      ZKSeleneseTestCase.assertEquals("", getText(lb21))
      ZKSeleneseTestCase.assertEquals("", getText(lb22))
      //		Assert.assertEquals("",findWidget("$db2").getText());
      //		Assert.assertEquals("",findWidget("$lb21").getValue());
      //		Assert.assertEquals("",findWidget("$lb22").getValue());

      `type`(db2.$n("real"), yesterday)
      waitResponse()
      ZKSeleneseTestCase.assertEquals(yesterday, getValue(db2.$n("real")))
      ZKSeleneseTestCase.assertEquals("", getText(lb21))
      ZKSeleneseTestCase.assertEquals("date bday2 must large than today", getText(lb22))
      //		findWidget("$db2").clear().keys(yesterday).tab();
      //		Assert.assertEquals(yesterday,findWidget("$db2").getText());
      //		Assert.assertEquals("",findWidget("$lb21").getValue());
      //		Assert.assertEquals("date bday2 must large than today",findWidget("$lb22").getValue());

      `type`(db2.$n("real"), tomorrow)
      waitResponse()
      ZKSeleneseTestCase.assertEquals(tomorrow, getValue(db2.$n("real")))
      ZKSeleneseTestCase.assertEquals(tomorrow, getText(lb21))
      ZKSeleneseTestCase.assertEquals("", getText(lb22))
      //		findWidget("$db2").clear().keys(tomorrow).tab();
      //		Assert.assertEquals(tomorrow,findWidget("$db2").getText());
      //		Assert.assertEquals(tomorrow,findWidget("$lb21").getValue());
      //		Assert.assertEquals("",findWidget("$lb22").getValue());
    })
  }
}
