/* B30_1729253Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase


class B30_1729253Test extends ZTL4ScalaTestCase {
  @Test
  def testForward() = {
    runZTL(() => {
      verifyTrue(jq("@window[title=\"My First window\"]").exists())
    })
  }
}



