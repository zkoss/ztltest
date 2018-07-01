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
import org.zkoss.ztl.annotation.Tags

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_F0015Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = """
      <include src="/bind/issue/F0015.zul"/>
"""

    runZTL(zul, () => {
      val l11 = engine.$f("l11")
      val l12 = engine.$f("l12")
      val l13 = engine.$f("l13")
      val l21 = engine.$f("l21")
      val l22 = engine.$f("l22")
      val l23 = engine.$f("l23")

      verifyEquals("A", getText(l11))
      verifyEquals("B", getText(l12))
      verifyEquals("C", getText(l13))
      verifyEquals("", getText(l21))
      verifyEquals("", getText(l22))
      verifyEquals("", getText(l23))
      //			Assert.assertEquals("A",findWidget("$l11").getValue());
      //			Assert.assertEquals("B",findWidget("$l12").getValue());
      //			Assert.assertEquals("C",findWidget("$l13").getValue());
      //			Assert.assertEquals("",findWidget("$l21").getValue());
      //			Assert.assertEquals("",findWidget("$l22").getValue());
      //			Assert.assertEquals("",findWidget("$l23").getValue());

      click(engine.$f("btn1"))
      waitResponse()
      verifyEquals("doCommand1", getText(l11))
      verifyEquals("B", getText(l12))
      verifyEquals("C", getText(l13))
      verifyEquals("doCommand1", getText(l21))
      verifyEquals("", getText(l22))
      verifyEquals("", getText(l23))
      //			findWidget("$btn1").click();
      //			Assert.assertEquals("doCommand1",findWidget("$l11").getValue());
      //			Assert.assertEquals("B",findWidget("$l12").getValue());
      //			Assert.assertEquals("C",findWidget("$l13").getValue());
      //			Assert.assertEquals("doCommand1",findWidget("$l21").getValue());
      //			Assert.assertEquals("",findWidget("$l22").getValue());
      //			Assert.assertEquals("",findWidget("$l23").getValue());

      click(engine.$f("btn2"))
      waitResponse()
      verifyEquals("doCommand1", getText(l11))
      verifyEquals("doCommand2", getText(l12))
      verifyEquals("doCommand3", getText(l13))
      verifyEquals("doCommand1", getText(l21))
      verifyEquals("doCommand2", getText(l22))
      verifyEquals("doCommand3", getText(l23))
      //			findWidget("$btn2").click();
      //			Assert.assertEquals("doCommand1",findWidget("$l11").getValue());
      //			Assert.assertEquals("doCommand2",findWidget("$l12").getValue());
      //			Assert.assertEquals("doCommand3",findWidget("$l13").getValue());
      //			Assert.assertEquals("doCommand1",findWidget("$l21").getValue());
      //			Assert.assertEquals("doCommand2",findWidget("$l22").getValue());
      //			Assert.assertEquals("doCommand3",findWidget("$l23").getValue());		  

    })
  }
}
