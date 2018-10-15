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
import org.zkoss.ztl.annotation.Tags

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_Validation2Test extends ZTL4ScalaTestCase {
  def testBasic() = {
    val zul = """
      <include src="/bind/basic/validation.zul"/>
"""

    runZTL(zul, () => {
      val l11 = engine.$f("l11")
      val l12 = engine.$f("l12")
      val t21 = engine.$f("t21")
      val t22 = engine.$f("t22")
      val t31 = engine.$f("t31")
      val t32 = engine.$f("t32")
      val msg1 = engine.$f("msg1")
      val msg2 = engine.$f("msg2")

      verifyEquals("0", getText(l11));
      verifyEquals("", getText(l12));
      verifyEquals("0", getValue(t21));
      verifyEquals("", getValue(t22));
      verifyEquals("0", getValue(t31));
      verifyEquals("", getValue(t32));
      verifyEquals("", getText(msg1));
      verifyEquals("", getText(msg2));

      `type`(t21, "1")
      waitResponse()
      verifyEquals("0", getText(l11));
      verifyEquals("", getText(l12));
      verifyEquals("1", getValue(t21));
      verifyEquals("", getValue(t22));
      verifyEquals("0", getValue(t31));
      verifyEquals("", getValue(t32));
      verifyEquals("value 1 have to large than 10", getText(msg1));
      verifyEquals("", getText(msg2));

      `type`(t21, "12")
      waitResponse()
      verifyEquals("12", getText(l11));
      verifyEquals("", getText(l12));
      verifyEquals("12", getValue(t21));
      verifyEquals("", getValue(t22));
      verifyEquals("12", getValue(t31));
      verifyEquals("", getValue(t32));
      verifyEquals("", getText(msg1));
      verifyEquals("", getText(msg2));

      `type`(t22, "3")
      waitResponse()
      verifyEquals("12", getText(l11));
      verifyEquals("", getText(l12));
      verifyEquals("12", getValue(t21));
      verifyEquals("3", getValue(t22));
      verifyEquals("12", getValue(t31));
      verifyEquals("", getValue(t32));
      verifyEquals("", getText(msg1));
      verifyEquals("value 2 have to large than 20", getText(msg2));

      `type`(t22, "33")
      waitResponse()
      verifyEquals("12", getText(l11));
      verifyEquals("33", getText(l12));
      verifyEquals("12", getValue(t21));
      verifyEquals("33", getValue(t22));
      verifyEquals("12", getValue(t31));
      verifyEquals("33", getValue(t32));
      verifyEquals("", getText(msg1));
      verifyEquals("", getText(msg2));
    })
  }
}
