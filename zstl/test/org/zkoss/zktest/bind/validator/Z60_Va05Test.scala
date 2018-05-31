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
class Z60_Va05Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/validator/va05.zul"/>
"""

    runZTL(zul, () => {
      val UNDER_AGE = "Under Age";
      val OVER_AGE = "Over Age";
      val ADULT = "Adult";
      val NEGATIVE_ONE = "-1";

      val ageBox = engine $f "ageBox"
      val submitButton = engine $f "submitButton"
      val limitBox = engine $f "limitBox"
      val messageLabel = engine $f "messageLabel"

      `type`(ageBox, "-1");
      click(submitButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals(UNDER_AGE + " " + getValue(limitBox), getText(messageLabel));

      `type`(ageBox, "11");
      click(submitButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals(OVER_AGE + " " + getValue(limitBox), getText(messageLabel));

      `type`(limitBox, "20");
      click(submitButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals(UNDER_AGE + " " + getValue(limitBox), getText(messageLabel));

      `type`(ageBox, "22");
      click(submitButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals(OVER_AGE + " " + getValue(limitBox), getText(messageLabel));

    })
  }
}