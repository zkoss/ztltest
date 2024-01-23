/* B30_1989387Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B30_1989387Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
      click(jq("@button"))
      waitResponse()
      verifyFalse(jq(".z-error").exists())
      verifyFalse(jq("@window").exists())
    })
  }
}