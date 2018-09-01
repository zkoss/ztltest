/* B30_1486556Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase


class B30_1486556Test extends ZTL4ScalaTestCase {
	@Test
	def testConstraint1() = {
		runZTL(() => {
      var tb = jq(".z-textbox")
      focus(tb)
      waitResponse()
      blur(tb)
      waitResponse()
      verifyTrue(tb.hasClass("z-textbox-invalid"))
		})
	}
}



