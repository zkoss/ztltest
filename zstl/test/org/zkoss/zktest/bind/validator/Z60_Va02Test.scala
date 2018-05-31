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
import org.zkoss.ztl.{Tags, ZKSeleneseTestCase}

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

      val ageBox = engine $f "ageBox"
      val addButton = engine $f "addButton"
      val adultLabel = engine $f "adultLabel"
      val beforeAge = engine $f "beforeAge"
      val ageLabel = engine $f "ageLabel"

      ZKSeleneseTestCase.assertEquals(NEGATIVE_ONE, getValue(ageBox));
      click(addButton);
      ZKSeleneseTestCase.assertEquals(UNDER_AGE, getText(adultLabel));

      `type`(ageBox, "1");
      click(addButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("1", getText(beforeAge));
      ZKSeleneseTestCase.assertEquals("11", getText(ageLabel));
      ZKSeleneseTestCase.assertEquals(UNDER_AGE, getText(adultLabel));

      `type`(ageBox, "18");
      click(addButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals(ADULT, getText(adultLabel));

    })
  }
}
