/* B85_ZK_3974Test.java

        Purpose:
        
        Description:
        
        History:
                Thu Jun 28 16:58:46 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B85_ZK_3974Test extends ZTL4ScalaTestCase {
	@Test
	def test()=  {
		runZTL(() => {
			for (i <- 0 to 1) {
				click(jq(".z-spinner-down"))
				waitResponse()
			}
			verifyEquals("1", jq(".z-spinner-input").`val`)
		})
	}
}
