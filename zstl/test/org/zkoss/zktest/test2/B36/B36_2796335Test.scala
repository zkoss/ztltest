/* B36_2796335Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B36_2796335Test extends ZTL4ScalaTestCase {
  @Test
  def testscrollIntoView() = {
    runZTL(() => {
      click(jq("@button:eq(0)"))
      waitResponse()
      val div1 = jq("@div:eq(0)")
      val div2 = jq("@div:eq(1)")
      val expectedDiv1 = div1.scrollHeight() - div1.outerHeight()
      val expectedDiv2 = div2.scrollHeight() - div2.outerHeight()
      verifyTolerant(expectedDiv1, div1.scrollTop(), 1) // bottom
      verifyTolerant(expectedDiv2, div2.scrollTop(), 1) // bottom

      click(jq("@button:eq(1)"))
      waitResponse()
      verifyTolerant(0, div1.scrollTop(), 1)
      verifyTolerant(0, div2.scrollTop(), 1)
    })
  }
}



