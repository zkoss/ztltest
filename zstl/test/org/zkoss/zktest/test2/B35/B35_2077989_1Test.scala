/* B35_2077989Test.java

	Purpose:

	Description:

	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase


class B35_2077989_1Test extends ZTL4ScalaTestCase {
  @Test
  def testminWin() = {
    val ztl$engine = engine()
    val win = ztl$engine.$f("win")
    val hidebtn = ztl$engine.$f("hidebtn")
    val zscript = """
     <include src="/test2/B35-2077989.zul"/>
    """
    runZTL(zscript, () => {
      verifyEquals(true, jq("$win").isVisible())
      click(win.$n("min"))
      waitResponse()
      verifyEquals(false, jq("$win").isVisible());
    })
  }
}



