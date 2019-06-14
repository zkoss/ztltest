/* B36_2838782Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase


class B36_2838782Test extends ZTL4ScalaTestCase {
  @Test
  def testnavigate() = {
    val ztl$engine = engine()
    val tree = ztl$engine.$f("tree")
    runZTL(() => {
      click(jq("@treecell:contains(3)"))
      waitResponse()
      click(jq("@treerow:eq(0)").toWidget().$n("icon"))
      waitResponse()
      click(jq("@treerow:eq(0)").toWidget().$n("icon"))
      waitResponse()
      sendKeys(jq(tree).find(".z-focus-a"), Keys.DOWN)
      waitResponse()
      sendKeys(jq(tree).find(".z-focus-a"), Keys.DOWN)
      waitResponse()
      sendKeys(jq(tree).find(".z-focus-a"), Keys.UP)
      waitResponse()
      verifyTrue(jq("@treecell:contains(7)").parent(".z-treerow").hasClass("z-treerow-selected"))
    })
  }
}



