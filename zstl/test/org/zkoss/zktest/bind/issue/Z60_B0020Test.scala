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
package org.zkoss.zktest.bind.issue

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{Tags, ZKSeleneseTestCase}

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_B0020Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = """
      <include src="/bind/issue/B0020.zul"/>
"""

    runZTL(zul, () => {
      //test property init
      waitResponse()
      ZKSeleneseTestCase.assertEquals(5, jq("@button").length())
      click(jq("@button").first())
      //		Assert.assertEquals(5,findWidgets("@button").size());
      //		Widget b = findWidget("@button");
      //		b.click();

      waitResponse()
      ZKSeleneseTestCase.assertEquals(4, jq("@button").length())
      click(jq("@button").first())
      //		Assert.assertEquals(4,findWidgets("@button").size());
      //		b = findWidget("@button");
      //		b.click();

      waitResponse()
      ZKSeleneseTestCase.assertEquals(3, jq("@button").length())
      click(jq("@button").first())
      //		Assert.assertEquals(3,findWidgets("@button").size());
      //		b = findWidget("@button");
      //		b.click();

      waitResponse()
      ZKSeleneseTestCase.assertEquals(2, jq("@button").length())
      click(jq("@button").first())
      //		Assert.assertEquals(2,findWidgets("@button").size());
      //		b = findWidget("@button");
      //		b.click();

      waitResponse()
      ZKSeleneseTestCase.assertEquals(1, jq("@button").length())
      click(jq("@button").first())
      //		Assert.assertEquals(1,findWidgets("@button").size());
      //		b = findWidget("@button");
      //		b.click();

      waitResponse()
      ZKSeleneseTestCase.assertEquals(0, jq("@button").length())
      //		Assert.assertEquals(0,findWidgets("@button").size());
      //		b = findWidget("@button");
      //		Assert.assertNull(b);
    })
  }
}
