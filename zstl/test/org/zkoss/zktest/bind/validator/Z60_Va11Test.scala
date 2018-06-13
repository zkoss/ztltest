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
class Z60_Va11Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/validator/va11.zul"/>
"""

    runZTL(zul, () => {

      val LESS_13 = "Less than 13";
      val LESS_18 = "Less than 18";
      val OVER_18 = "Over 18";

      val ageBox = engine.$f("ageBox")
      val submitButton = engine.$f("submitButton")
      val less13 = engine.$f("less13")
      val less18 = engine.$f("less18")
      val over18 = engine.$f("over18")

      `type`(ageBox, "-1");
      click(submitButton);
      waitResponse();
      verifyEquals(true, isVisible(less13));
      verifyEquals(true, isVisible(less18));
      verifyEquals(false, isVisible(over18));

      `type`(ageBox, "1");
      click(submitButton);
      waitResponse();
      verifyEquals(true, isVisible(less13));
      verifyEquals(true, isVisible(less18));
      verifyEquals(false, isVisible(over18));

      `type`(ageBox, "15");
      click(submitButton);
      waitResponse();
      verifyEquals(false, isVisible(less13));
      verifyEquals(true, isVisible(less18));
      verifyEquals(false, isVisible(over18));

      `type`(ageBox, "18");
      click(submitButton);
      waitResponse();
      verifyEquals(false, isVisible(less13));
      verifyEquals(false, isVisible(less18));
      verifyEquals(true, isVisible(over18));

    })
  }
}