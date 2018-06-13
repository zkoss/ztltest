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
class Z60_Va02Test extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/validator/va02.zul"/>
"""

    runZTL(zul, () => {
      val UNDER_AGE = "Under Age";
      val ADULT = "Adult";
      val NEGATIVE_ONE = "-1";

      val ageBox = engine.$f("ageBox")
      val addButton = engine.$f("addButton")
      val adultLabel = engine.$f("adultLabel")
      val beforeAge = engine.$f("beforeAge")
      val ageLabel = engine.$f("ageLabel")

      verifyEquals(NEGATIVE_ONE, getValue(ageBox));
      click(addButton);
      verifyEquals(UNDER_AGE, getText(adultLabel));

      `type`(ageBox, "1");
      click(addButton);
      waitResponse();
      verifyEquals("1", getText(beforeAge));
      verifyEquals("11", getText(ageLabel));
      verifyEquals(UNDER_AGE, getText(adultLabel));

      `type`(ageBox, "18");
      click(addButton);
      waitResponse();
      verifyEquals(ADULT, getText(adultLabel));

    })
  }
}
