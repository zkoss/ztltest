/* B30_1958774Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B30_1958774Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
      verifyTrue(jq("@window[title=\"tree demo\"]").exists())
      verifyFalse(jq("@window:not(@window[title=\"tree demo\"])").exists())
    })
  }
}



