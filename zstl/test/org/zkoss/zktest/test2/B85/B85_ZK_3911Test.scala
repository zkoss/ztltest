/* B85_ZK_3911Test.java

        Purpose:
        
        Description:
        
        History:
                Mon May 28 17:55:15 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers

@IgnoreBrowsers("ie9")
class B85_ZK_3911Test extends ZTL4ScalaTestCase {
	@Test
	def test()=  {
		runZTL(() => {
			val h = jq(".z-page").height()
			val label = jq(".lb")
			
			windowMaximize()
			waitResponse()
			verifyEquals("desktop", label.text())
			
			windowResizeTo(768, h)
			waitResponse()
			verifyEquals("tablet", label.text())
			
			windowResizeTo(414, h)
			waitResponse()
			verifyEquals("mobile", label.text())
		})
	}
}
