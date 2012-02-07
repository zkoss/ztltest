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
import org.zkoss.ztl.Tags
import org.zkoss.ztl.ZKSeleneseTestCase

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_Va06Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = {
      <include src="/bind/validator/va06.zul"/>
    }

    runZTL(zul, () => {
      val UNDER_AGE = "Under Age";
      val ADULT = "Adult";
      val NEGATIVE_ONE = "-1";

      val checkBox = engine $f "adultBox"
      val ageBox = engine $f "ageBox"
      val checkButton = engine $f "checkButton"

      `type`(ageBox, "-1");
      click(checkButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("false", checkBox.get("checked"));

      `type`(ageBox, "22");
      click(checkButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("true", checkBox.get("checked"));

      `type`(ageBox, "1");
      click(checkButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("false", checkBox.get("checked"));
    })
  }
}