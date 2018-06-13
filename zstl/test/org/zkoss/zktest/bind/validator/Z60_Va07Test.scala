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
package org.zkoss.zktest.bind.validator
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_Va07Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/validator/va07.zul"/>
"""

    runZTL(zul, () => {

      val ageBox = engine.$f("ageBox")
      val ageLabel = engine.$f("ageLabel")

      `type`(ageBox, "-1");
      click(ageLabel);
      waitResponse();
      verifyEquals("0", getText(ageLabel));

      `type`(ageBox, "2");
      click(ageLabel);
      waitResponse();
      verifyEquals("2", getText(ageLabel));

    })
  }
}
