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
class Z60_Va10Test extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = """
      <include src="/bind/validator/va10.zul"/>
"""

    runZTL(zul, () => {

      val start = engine $f "start"
      val end = engine $f "end"
      val okButton = engine $f "okButton"
      val startLabel = engine $f "startLabel"
      val endLabel = engine $f "endLabel"

      `type`(start.$n("real"), "2011/11/02");
      `type`(end.$n("real"), "2011/11/03");
      //check input is correct
      ZKSeleneseTestCase.assertEquals("2011/11/02", jq(start.$n("real")).`val`());
      ZKSeleneseTestCase.assertEquals("2011/11/03", jq(end.$n("real")).`val`());
      click(okButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("Wed Nov 02 00:00:00 CST 2011", jq(startLabel).text());
      ZKSeleneseTestCase.assertEquals("Thu Nov 03 00:00:00 CST 2011", jq(endLabel).text());

      `type`(end.$n("real"), "2011/11/01");
      ZKSeleneseTestCase.assertEquals("2011/11/01", jq(end.$n("real")).`val`());
      click(okButton);
      waitResponse();
      ZKSeleneseTestCase.assertEquals("Wed Nov 02 00:00:00 CST 2011", jq(startLabel).text());
      ZKSeleneseTestCase.assertEquals("Thu Nov 03 00:00:00 CST 2011", jq(endLabel).text());

    })
  }
}
