/* B36_2820552Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase


class B36_2820552Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
      verifyFalse(jq("@window").exists())
      verifyFalse(jq(".z-error").exists())
    })
  }
}



