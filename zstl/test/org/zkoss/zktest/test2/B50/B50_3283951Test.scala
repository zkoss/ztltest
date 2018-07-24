/* B50_3283951Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3283951Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tree = ztl$engine.$f("tree")
    val titem = ztl$engine.$f("titem")
    runZTL(() => {
      click(jq("@button:eq(0)"))
      waitResponse()
      verifyTrue(titem.is("selected"))
      click(jq("@button:eq(1)"))
      waitResponse()
      verifyContains(getAlertMessage(), "<Treeitem")
    })
  }
}



