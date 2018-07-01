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

import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_B0004Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = """
      <include src="/bind/issue/B0004.zul"/>
"""

    runZTL(zul, () => {
      val l11 = engine.$f("l11")
      val l12 = engine.$f("l12")
      val msg1 = engine.$f("msg1")
      val msg2 = engine.$f("msg2")
      val msg3 = engine.$f("msg3")

      verifyEquals("0", getText(l11));
      verifyEquals("", getText(l12));
      verifyEquals("", getText(msg1));
      verifyEquals("", getText(msg2));
      verifyEquals("", getText(msg3));

      //		Assert.assertEquals("0",findWidget("$l11").getText());
      //		Assert.assertEquals("",findWidget("$l12").getText());
      //		Assert.assertEquals("",findWidget("$msg1").getText());
      //		Assert.assertEquals("",findWidget("$msg2").getText());
      //		Assert.assertEquals("",findWidget("$msg3").getText());

      click(engine.$f("btn1"))
      waitResponse()
      verifyEquals("0", getText(l11));
      verifyEquals("", getText(l12));
      verifyEquals("value 1 have to large than 10", getText(msg1));
      verifyEquals("", getText(msg2));
      verifyEquals("", getText(msg3));
      //		findWidget("$btn1").click();
      //		Assert.assertEquals("0",findWidget("$l11").getText());
      //		Assert.assertEquals("",findWidget("$l12").getText());
      //		Assert.assertEquals("value 1 have to large than 10",findWidget("$msg1").getText());
      //		Assert.assertEquals("",findWidget("$msg2").getText());
      //		Assert.assertEquals("",findWidget("$msg3").getText());

      val t21 = engine.$f("t21")
      `type`(t21, "32")
      sendKeys(t21, Keys.TAB)
      waitResponse()
      verifyEquals("0", getText(l11));
      verifyEquals("", getText(l12));
      verifyEquals("", getText(msg1));
      verifyEquals("", getText(msg2));
      verifyEquals("", getText(msg3));
      //		findWidget("$t21").clear().keys("32").tab();
      //		Assert.assertEquals("0",findWidget("$l11").getText());
      //		Assert.assertEquals("",findWidget("$l12").getText());
      //		Assert.assertEquals("",findWidget("$msg1").getText());
      //		Assert.assertEquals("",findWidget("$msg2").getText());
      //		Assert.assertEquals("",findWidget("$msg3").getText());

      click(engine.$f("btn1"))
      waitResponse()
      verifyEquals("0", getText(l11));
      verifyEquals("", getText(l12));
      verifyEquals("", getText(msg1));
      verifyEquals("value 2 is not valid For input string: \"\"", getText(msg2));
      verifyEquals("", getText(msg3));
      //    	findWidget("$btn1").click();
      //		Assert.assertEquals("0",findWidget("$l11").getText());
      //		Assert.assertEquals("",findWidget("$l12").getText());
      //		Assert.assertEquals("",findWidget("$msg1").getText());
      //		Assert.assertEquals("value 2 is not valid For input string: \"\"",findWidget("$msg2").getText());
      //		Assert.assertEquals("",findWidget("$msg3").getText());

      val t22 = engine.$f("t22")
      `type`(t22, "13")
      sendKeys(t22, Keys.TAB)
      waitResponse()
      verifyEquals("0", getText(l11));
      verifyEquals("", getText(l12));
      verifyEquals("", getText(msg1));
      verifyEquals("value 2 have to large than 20", getText(msg2));
      verifyEquals("", getText(msg3));
      //		findWidget("$t22").clear().keys("13").tab();
      //		Assert.assertEquals("0",findWidget("$l11").getText());
      //		Assert.assertEquals("",findWidget("$l12").getText());
      //		Assert.assertEquals("",findWidget("$msg1").getText());
      //		Assert.assertEquals("value 2 have to large than 20",findWidget("$msg2").getText());
      //		Assert.assertEquals("",findWidget("$msg3").getText());

      `type`(t22, "22")
      sendKeys(t22, Keys.TAB)
      waitResponse()
      verifyEquals("0", getText(l11));
      verifyEquals("", getText(l12));
      verifyEquals("", getText(msg1));
      verifyEquals("", getText(msg2));
      verifyEquals("", getText(msg3));
      //		findWidget("$t22").clear().keys("22").tab();
      //		Assert.assertEquals("0",findWidget("$l11").getText());
      //		Assert.assertEquals("",findWidget("$l12").getText());
      //		Assert.assertEquals("",findWidget("$msg1").getText());
      //		Assert.assertEquals("",findWidget("$msg2").getText());
      //		Assert.assertEquals("",findWidget("$msg3").getText());

      click(engine.$f("btn1"))
      waitResponse()
      verifyEquals("0", getText(l11));
      verifyEquals("", getText(l12));
      verifyEquals("", getText(msg1));
      verifyEquals("value 2 have to large than value 1", getText(msg2));
      verifyEquals("", getText(msg3));
      //    	findWidget("$btn1").click();
      //		Assert.assertEquals("0",findWidget("$l11").getText());
      //		Assert.assertEquals("",findWidget("$l12").getText());
      //		Assert.assertEquals("",findWidget("$msg1").getText());
      //		Assert.assertEquals("value 2 have to large than value 1",findWidget("$msg2").getText());
      //		Assert.assertEquals("",findWidget("$msg3").getText());

      `type`(t22, "42")
      sendKeys(t22, Keys.TAB)
      waitResponse()
      verifyEquals("0", getText(l11));
      verifyEquals("", getText(l12));
      verifyEquals("", getText(msg1));
      verifyEquals("", getText(msg2));
      verifyEquals("", getText(msg3));
      //    	findWidget("$t22").clear().keys("42").tab();
      //		Assert.assertEquals("0",findWidget("$l11").getText());
      //		Assert.assertEquals("",findWidget("$l12").getText());
      //		Assert.assertEquals("",findWidget("$msg1").getText());
      //		Assert.assertEquals("",findWidget("$msg2").getText());
      //		Assert.assertEquals("",findWidget("$msg3").getText());

      click(engine.$f("btn1"))
      waitResponse()
      verifyEquals("32", getText(l11));
      verifyEquals("42", getText(l12));
      verifyEquals("", getText(msg1));
      verifyEquals("", getText(msg2));
      verifyEquals("execute command 1", getText(msg3));
      //		findWidget("$btn1").click();
      //		Assert.assertEquals("32",findWidget("$l11").getText());
      //		Assert.assertEquals("42",findWidget("$l12").getText());
      //		Assert.assertEquals("",findWidget("$msg1").getText());
      //		Assert.assertEquals("",findWidget("$msg2").getText());
      //		Assert.assertEquals("execute command 1",findWidget("$msg3").getText());      
    })
  }
}
