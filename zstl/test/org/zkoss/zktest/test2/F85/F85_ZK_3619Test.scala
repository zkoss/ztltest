/* F85_ZK_3619Test.java

		Purpose:

		Description:

		History:
				Thu May 24 17:49:46 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.F85

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.JQuery

class F85_ZK_3619Test extends ZTL4ScalaTestCase {
	
	def test()=  {
		runZTL(() => {
			val buttons = jq(".z-button")
			
			click(buttons.eq(0))
			waitResponse()
			
			for (i <- 0 to 1) {
				click(jq(".z-calendar-left"))
				waitResponse()
			}
			
			testDisabled(jq(".z-calendar-cell:visible"))
			
			click(buttons.eq(1))
			waitResponse()
			
			for (i <- 0 to 3) {
				click(jq(".z-calendar-right"))
				waitResponse()
			}
			
			testDisabled(jq(".z-calendar-cell:visible"))
		})
	}
	
	def testDisabled(cells: JQuery)=  {
			verifyEquals(jq(".z-calendar-cell:visible").length, jq(".z-calendar-cell.z-calendar-disabled:visible").length)
	}
}
