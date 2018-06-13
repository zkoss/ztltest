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
class Z60_Va04Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/validator/va04.zul"/>
"""

    runZTL(zul, () => {
      val UNDER_AGE = "Under Age";
      val ADULT = "Adult";
      val NEGATIVE_ONE = "-1";

      val ageBox = engine.$f("ageBox")
      val addButton = engine.$f("addButton")
      val originalAge = engine.$f("originalAge")
      val afterAge = engine.$f("afterAge")
      val adultLabel = engine.$f("adultLabel")

      `type`(ageBox, "1");
      click(addButton);
      waitResponse();
      verifyEquals("1", getText(originalAge));
      verifyEquals("11", getText(afterAge));

      `type`(ageBox, "22");
      click(addButton);
      waitResponse();
      verifyEquals(ADULT, getText(adultLabel));

      `type`(ageBox, "33");
      click(addButton);
      waitResponse();
      verifyEquals(ADULT, getText(adultLabel));

    })
  }
}
