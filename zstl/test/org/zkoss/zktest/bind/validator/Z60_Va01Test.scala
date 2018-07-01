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
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_Va01 extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/validator/va01.zul"/>
"""

    runZTL(zul, () => {
      val UNDER_AGE = "Under Age";
      val ADULT = "Adult";
      val NEGATIVE_ONE = "-1";

      val ageBox = engine.$f("ageBox")
      val submitButton = engine.$f("submitButton")
      val adultLabel = engine.$f("adultLabel")

      verifyEquals(NEGATIVE_ONE, getValue(ageBox));

      `type`(ageBox, "22");
      click(submitButton);
      waitResponse();
      verifyEquals(ADULT, getText(adultLabel));

      `type`(ageBox, "-1");
      click(submitButton);
      waitResponse();
      verifyEquals(ADULT, getText(adultLabel));

      `type`(ageBox, "11");
      click(submitButton);
      waitResponse();
      verifyEquals(UNDER_AGE, getText(adultLabel));

    })
  }
}