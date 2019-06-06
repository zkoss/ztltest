/* B50_3131173Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3131173Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    val ztl$engine = engine()
    val tree = ztl$engine.$f("tree")
    val cell = ztl$engine.$f("cell")
    runZTL(() => {
      click(jq(".z-treerow-checkbox:eq(0)"));
      waitResponse()
      click(jq(".z-treerow-checkbox:eq(0)"));
      waitResponse()
      click(jq(".z-treerow-checkbox:eq(0)"));
      waitResponse()
      click(jq(".z-treerow-checkbox:eq(0)"));
      waitResponse()
      click(jq(".z-treerow-checkbox:eq(0)"));
      waitResponse()
      click(jq(".z-treerow-checkbox:eq(0)"));
      waitResponse()
      click(jq(".z-treerow-checkbox:eq(0)"));
      waitResponse()
      verifyContains(jq("@treecell:eq(0)").text(), "Item 4: / selected:true")
      click(jq(".z-treerow-checkbox:eq(0)"));
      waitResponse()
      verifyContains(jq("@treecell:eq(0)").text(), "Item 4: / selected:false")
    })
  }
}



