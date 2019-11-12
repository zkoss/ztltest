/* B30_1736858Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B30_1736858Test extends ZTL4ScalaTestCase {
  @Test
  def testSession() = {
    runZTL(() => {
      click(jq("@button")); // here there doesn't exsit anything in zk session
      waitResponse()
      sleep(1000)
      click(jq("@button")); // here will be a timeout
      verifyTrue(jq(":contains(The resource you request is no longer available)").exists())
    })
  }
}



