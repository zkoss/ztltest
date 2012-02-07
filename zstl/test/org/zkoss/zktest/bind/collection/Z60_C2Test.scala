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
package org.zkoss.zktest.bind.collection
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.ZKSeleneseTestCase

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_C2 extends ZTL4ScalaTestCase {
  def testArg = {

    val zul = {
      <include src="/bind/collection/c2.zul"/>
    }

    runZTL(zul, () => {

      click(jq("@button").first());
      waitResponse();
      ZKSeleneseTestCase.assertEquals(jq("@button").length(), 4);

      click(jq("@button").first());
      waitResponse();
      ZKSeleneseTestCase.assertEquals(jq("@button").length(), 3);

      click(jq("@button").first());
      waitResponse();
      ZKSeleneseTestCase.assertEquals(jq("@button").length(), 2);

      click(jq("@button").first());
      waitResponse();
      ZKSeleneseTestCase.assertEquals(jq("@button").length(), 1);

      click(jq("@button").first());
      waitResponse();
      ZKSeleneseTestCase.assertEquals(jq("@button").exists(), false);
    })
  }
}