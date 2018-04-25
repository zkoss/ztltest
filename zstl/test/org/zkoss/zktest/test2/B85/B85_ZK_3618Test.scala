/* B85_ZK_3618Test.java

        Purpose:

        Description:

        History:
                Thu Mar 15 11:52:29 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B85_ZK_3618Test extends ZTL4ScalaTestCase {
	@Test
	def test() = {
		runZTL(() => {
			val img = jq(".z-image")

			click(img)
			waitResponse(true)

			verifyFalse(img.exists())
		})
	}
}
