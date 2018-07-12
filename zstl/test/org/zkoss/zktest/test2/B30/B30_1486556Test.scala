/* B30_1486556Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase


class B30_1486556Test extends ZTL4ScalaTestCase {
	val textbox = jq(".z-textbox")
	
	@Test
	def testConstraint1() = {
		runZTL(() => {
			testConstraintWithAction(() => {
				blur(textbox)
			})
		})
	}
	
	@Test
	def testConstraint2() = {
		runZTL(() => {
			testConstraintWithAction(() => {
				click(jq(".z-button"))
			})
		})
	}
	
	def testConstraintWithAction(action: () => Unit) = {
		focus(textbox)
		waitResponse()
		action()
		waitResponse()
		verifyTrue(textbox.hasClass("z-textbox-invalid"))
	}
}



