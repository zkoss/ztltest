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
class Z60_Va09Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/validator/va09.zul"/>
"""

    runZTL(zul, () => {

      val keywordBox = engine.$f("keywordBox")
      val keywordLabel = engine.$f("keywordLabel")
      val lengthBox = engine.$f("lengthBox")

      `type`(keywordBox, "123");
      click(lengthBox); //to change focus
      waitResponse();
      verifyEquals("123", getText(keywordLabel));

      `type`(keywordBox, "1234");
      click(lengthBox);
      waitResponse();
      verifyEquals("123", getText(keywordLabel));

      `type`(lengthBox, "5");
      `type`(keywordBox, "12345");
      click(keywordLabel);
      waitResponse();
      verifyEquals("12345", getText(keywordLabel));

    })
  }
}