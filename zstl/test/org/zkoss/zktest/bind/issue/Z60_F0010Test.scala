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
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_F0010Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = """
      <include src="/bind/issue/F0010.zul"/>
"""

    runZTL(zul, () => {
      val l0 = engine.$f("l0")
      val l1 = engine.$f("l1")
      val l2 = engine.$f("l2")
      val t0 = engine.$f("t0")
      val t1 = engine.$f("t1")
      val t2 = engine.$f("t2")

      verifyEquals("A-toUI-c0", getText(l0))
      verifyEquals("B-toUI-c1", getText(l1))
      verifyEquals("C-toUI-c2", getText(l2))
      verifyEquals("A-toUI-c0", getValue(t0))
      verifyEquals("B-toUI-c1", getValue(t1))
      verifyEquals("C-toUI-c2", getValue(t2))
      //		Assert.assertEquals("A-toUI-c0",findWidget("$l0").getValue());
      //		Assert.assertEquals("B-toUI-c1",findWidget("$l1").getValue());
      //		Assert.assertEquals("C-toUI-c2",findWidget("$l2").getValue());
      //		Assert.assertEquals("A-toUI-c0",findWidget("$t0").getValue());
      //		Assert.assertEquals("B-toUI-c1",findWidget("$t1").getValue());
      //		Assert.assertEquals("C-toUI-c2",findWidget("$t2").getValue());

      `type`(t0, "I")
      sendKeys(t0, Keys.TAB)
      waitResponse()
      verifyEquals("I-toBean-c0-toUI-c0", getText(l0))
      verifyEquals("B-toUI-c1", getText(l1))
      verifyEquals("C-toUI-c2", getText(l2))
      verifyEquals("I-toBean-c0-toUI-c0", getValue(t0))
      verifyEquals("B-toUI-c1", getValue(t1))
      verifyEquals("C-toUI-c2", getValue(t2))
      //		findWidget("$t0").clear().keys("I").tab();
      //		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$l0").getValue());
      //		Assert.assertEquals("B-toUI-c1",findWidget("$l1").getValue());
      //		Assert.assertEquals("C-toUI-c2",findWidget("$l2").getValue());
      //		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$t0").getValue());
      //		Assert.assertEquals("B-toUI-c1",findWidget("$t1").getValue());
      //		Assert.assertEquals("C-toUI-c2",findWidget("$t2").getValue());

      `type`(t1, "J")
      sendKeys(t1, Keys.TAB)
      waitResponse()
      verifyEquals("I-toBean-c0-toUI-c0", getText(l0))
      verifyEquals("J-toBean-c1-toUI-c1", getText(l1))
      verifyEquals("C-toUI-c2", getText(l2))
      verifyEquals("I-toBean-c0-toUI-c0", getValue(t0))
      verifyEquals("J-toBean-c1-toUI-c1", getValue(t1))
      verifyEquals("C-toUI-c2", getValue(t2))
      //		findWidget("$t1").clear().keys("J").tab();
      //		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$l0").getValue());
      //		Assert.assertEquals("J-toBean-c1-toUI-c1",findWidget("$l1").getValue());
      //		Assert.assertEquals("C-toUI-c2",findWidget("$l2").getValue());
      //		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$t0").getValue());
      //		Assert.assertEquals("J-toBean-c1-toUI-c1",findWidget("$t1").getValue());
      //		Assert.assertEquals("C-toUI-c2",findWidget("$t2").getValue());

      `type`(t2, "K")
      sendKeys(t2, Keys.TAB)
      waitResponse()
      verifyEquals("I-toBean-c0-toUI-c0", getText(l0))
      verifyEquals("J-toBean-c1-toUI-c1", getText(l1))
      verifyEquals("K-toBean-c2-toUI-c2", getText(l2))
      verifyEquals("I-toBean-c0-toUI-c0", getValue(t0))
      verifyEquals("J-toBean-c1-toUI-c1", getValue(t1))
      verifyEquals("K-toBean-c2-toUI-c2", getValue(t2))
      //		findWidget("$t2").clear().keys("K").tab();
      //		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$l0").getValue());
      //		Assert.assertEquals("J-toBean-c1-toUI-c1",findWidget("$l1").getValue());
      //		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$l2").getValue());
      //		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$t0").getValue());
      //		Assert.assertEquals("J-toBean-c1-toUI-c1",findWidget("$t1").getValue());
      //		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$t2").getValue());

      `type`(t1, "X")
      sendKeys(t1, Keys.TAB)
      waitResponse()
      verifyEquals("I-toBean-c0-toUI-c0", getText(l0))
      verifyEquals("X-toBean-c1-toUI-c1", getText(l1))
      verifyEquals("K-toBean-c2-toUI-c2", getText(l2))
      verifyEquals("I-toBean-c0-toUI-c0", getValue(t0))
      verifyEquals("X-toBean-c1-toUI-c1", getValue(t1))
      verifyEquals("K-toBean-c2-toUI-c2", getValue(t2))
      //test converter dependency
      //		findWidget("$t1").clear().keys("X").tab();
      //		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$l0").getValue());
      //		Assert.assertEquals("X-toBean-c1-toUI-c1",findWidget("$l1").getValue());
      //		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$l2").getValue());
      //		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$t0").getValue());
      //		Assert.assertEquals("X-toBean-c1-toUI-c1",findWidget("$t1").getValue());
      //		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$t2").getValue());

      click(engine.$f("btn1"))
      waitResponse()
      verifyEquals("I-toBean-c0-toUI-c0", getText(l0))
      verifyEquals("X-toBean-c1-toUI-c3", getText(l1))
      verifyEquals("K-toBean-c2-toUI-c2", getText(l2))
      verifyEquals("I-toBean-c0-toUI-c0", getValue(t0))
      verifyEquals("X-toBean-c1-toUI-c3", getValue(t1))
      verifyEquals("K-toBean-c2-toUI-c2", getValue(t2))
      //    	findWidget("$btn1").click();
      //		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$l0").getValue());
      //		Assert.assertEquals("X-toBean-c1-toUI-c3",findWidget("$l1").getValue());
      //		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$l2").getValue());
      //		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$t0").getValue());
      //		Assert.assertEquals("X-toBean-c1-toUI-c3",findWidget("$t1").getValue());
      //		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$t2").getValue());

      `type`(t1, "X")
      sendKeys(t1, Keys.TAB)
      waitResponse()
      verifyEquals("I-toBean-c0-toUI-c0", getText(l0))
      verifyEquals("X-toBean-c3-toUI-c3", getText(l1))
      verifyEquals("K-toBean-c2-toUI-c2", getText(l2))
      verifyEquals("I-toBean-c0-toUI-c0", getValue(t0))
      verifyEquals("X-toBean-c3-toUI-c3", getValue(t1))
      verifyEquals("K-toBean-c2-toUI-c2", getValue(t2))
      //		findWidget("$t1").clear().keys("X").tab();
      //		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$l0").getValue());
      //		Assert.assertEquals("X-toBean-c3-toUI-c3",findWidget("$l1").getValue());//
      //		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$l2").getValue());
      //		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$t0").getValue());
      //		Assert.assertEquals("X-toBean-c3-toUI-c3",findWidget("$t1").getValue());//
      //		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$t2").getValue());

      click(engine.$f("btn2"))
      waitResponse()
      verifyEquals("I-toBean-c0-toUI-c0", getText(l0))
      verifyEquals("X-toBean-c3-toUI-c4", getText(l1))
      verifyEquals("K-toBean-c2-toUI-c2", getText(l2))
      verifyEquals("I-toBean-c0-toUI-c0", getValue(t0))
      verifyEquals("X-toBean-c3-toUI-c4", getValue(t1))
      verifyEquals("K-toBean-c2-toUI-c2", getValue(t2))
      //		findWidget("$btn2").click();
      //		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$l0").getValue());
      //		Assert.assertEquals("X-toBean-c3-toUI-c4",findWidget("$l1").getValue());//
      //		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$l2").getValue());
      //		Assert.assertEquals("I-toBean-c0-toUI-c0",findWidget("$t0").getValue());
      //		Assert.assertEquals("X-toBean-c3-toUI-c4",findWidget("$t1").getValue());//
      //		Assert.assertEquals("K-toBean-c2-toUI-c2",findWidget("$t2").getValue());
    })
  }
}
