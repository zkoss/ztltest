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
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

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
      verifyEquals(5, jq("@button").length())
      click(jq("@button").first())
      //		Assert.assertEquals(5,findWidgets("@button").size());
      //		Widget b = findWidget("@button");
      //		b.click();

      waitResponse()
      verifyEquals(4, jq("@button").length())
      click(jq("@button").first())
      //		Assert.assertEquals(4,findWidgets("@button").size());
      //		b = findWidget("@button");
      //		b.click();

      waitResponse()
      verifyEquals(3, jq("@button").length())
      click(jq("@button").first())
      //		Assert.assertEquals(3,findWidgets("@button").size());
      //		b = findWidget("@button");
      //		b.click();

      waitResponse()
      verifyEquals(2, jq("@button").length())
      click(jq("@button").first())
      //		Assert.assertEquals(2,findWidgets("@button").size());
      //		b = findWidget("@button");
      //		b.click();

      waitResponse()
      verifyEquals(1, jq("@button").length())
      click(jq("@button").first())
      //		Assert.assertEquals(1,findWidgets("@button").size());
      //		b = findWidget("@button");
      //		b.click();

      waitResponse()
      verifyEquals(0, jq("@button").length())
      //		Assert.assertEquals(0,findWidgets("@button").size());
      //		b = findWidget("@button");
      //		Assert.assertNull(b);
    })
  }
}
