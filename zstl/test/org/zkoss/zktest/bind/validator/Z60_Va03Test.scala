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
class Z60_Va03Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/validator/va03.zul"/>
"""

    runZTL(zul, () => {

      val UNDER_AGE = "Under Age";
      val ADULT = "Adult";
      val NEGATIVE_ONE = "-1";

      val ageBox = engine.$f("ageBox")
      val minusButton = engine.$f("minusButton")
      val adultLabel = engine.$f("adultLabel")
      val ageLabel = engine.$f("ageLabel")

      `type`(ageBox, "1");
      click(minusButton);
      waitResponse();
      verifyEquals(UNDER_AGE, getText(adultLabel));

      `type`(ageBox, "28");
      click(minusButton);
      waitResponse();
      verifyEquals(ADULT, getText(adultLabel));
      verifyEquals("18", getText(ageLabel));

    })
  }
}