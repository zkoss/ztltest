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

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_F0013Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = """

      <include src="/bind/issue/F0013.zul"/>
"""

    runZTL(zul, () => {
      val l1 = engine.$f("l1")
      val l2 = engine.$f("l2")
      val t1 = engine.$f("t1")
      val t2 = engine.$f("t2")
      val a = null
      verifyEquals("A", getText(l1))
      verifyEquals("B", getText(l2))
      verifyEquals("A", getValue(t1))
      verifyEquals("B", getValue(t2))
      //			Assert.assertEquals("A",findWidget("$l1").getValue());
      //			Assert.assertEquals("B",findWidget("$l2").getValue());
      //			Assert.assertEquals("A",findWidget("$t1").getValue());
      //			Assert.assertEquals("B",findWidget("$t2").getValue());

      `type`(t1, "Dennis")
      `type`(t2, "Chen")
      click(engine.$f("btn1"))
      waitResponse()
      verifyEquals("Dennis-cmd1", getText(l1))
      verifyEquals("Chen-cmd1", getText(l2))
      verifyEquals("Dennis", getValue(t1))
      verifyEquals("Chen", getValue(t2))
      //			findWidget("$t1").clear().keys("Dennis");
      //			findWidget("$t2").clear().keys("Chen");
      //			findWidget("$btn1").click();
      //			Assert.assertEquals("Dennis-cmd1",findWidget("$l1").getValue());
      //			Assert.assertEquals("Chen-cmd1",findWidget("$l2").getValue());
      //			Assert.assertEquals("Dennis",findWidget("$t1").getValue());
      //			Assert.assertEquals("Chen",findWidget("$t2").getValue());

      `type`(t1, "Alice")
      `type`(t2, "Wu")
      click(engine.$f("btn2"))
      waitResponse()
      verifyEquals("Alice-cmd2", getText(l1))
      verifyEquals("Wu-cmd2", getText(l2))
      verifyEquals("Alice-cmd2", getValue(t1))
      verifyEquals("Wu-cmd2", getValue(t2))
      //			findWidget("$t1").clear().keys("Alice");
      //			findWidget("$t2").clear().keys("Wu");
      //			findWidget("$btn2").click();
      //			Assert.assertEquals("Alice-cmd2",findWidget("$l1").getValue());
      //			Assert.assertEquals("Wu-cmd2",findWidget("$l2").getValue());
      //			Assert.assertEquals("Alice-cmd2",findWidget("$t1").getValue());
      //			Assert.assertEquals("Wu-cmd2",findWidget("$t2").getValue());

      `type`(t1, "Jumper")
      `type`(t2, "Tj")
      click(engine.$f("btn3"))
      waitResponse()
      verifyEquals("Jumper-cmd3", getText(l1))
      verifyEquals("Tj-cmd3", getText(l2))
      verifyEquals("Jumper-cmd3", getValue(t1))
      verifyEquals("Tj-cmd3", getValue(t2))
      //			findWidget("$t1").clear().keys("Jumper");
      //			findWidget("$t2").clear().keys("Tj");
      //			findWidget("$btn3").click();
      //			Assert.assertEquals("Jumper-cmd3",findWidget("$l1").getValue());
      //			Assert.assertEquals("Tj-cmd3",findWidget("$l2").getValue());
      //			Assert.assertEquals("Jumper-cmd3",findWidget("$t1").getValue());
      //			Assert.assertEquals("Tj-cmd3",findWidget("$t2").getValue());

    })
  }
}
