/* F85_ZK_3624Test.java

        Purpose:
        
        Description:
        
        History:
                Fri Jun 01 15:36:02 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.F85

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase

class F85_ZK_3624Test extends ZTL4ScalaTestCase {
	
	@Test
	def test(): Unit = {
		runZTL(() => {
			testBy(increaseByButton, decreaseByButton)
			testBy(increaseByKeyboard, decreaseByKeyboard)
		})
	}
	
	def testBy(increase: () => Unit, decrease: () => Unit): Unit = {
		click(jq("@button:eq(0)"))
		waitResponse()
		
		increase()
		verifyEquals("1", jq(".z-spinner-input").`val`)
		clearSpinnerValue()
		
		click(jq("@button:eq(1)"))
		waitResponse()
		
		increase()
		verifyEquals("2", jq(".z-spinner-input").`val`)
		clearSpinnerValue()
		
		click(jq("@button:eq(2)"))
		waitResponse()
		
		decrease()
		verifyEquals("-1", jq(".z-spinner-input").`val`)
		clearSpinnerValue()
		
		click(jq("@button:eq(3)"))
		waitResponse()
		
		decrease()
		verifyEquals("-2", jq(".z-spinner-input").`val`)
		clearSpinnerValue()
	}
	
	
	def increaseByButton(): Unit = {
		click(jq(".z-spinner-up"))
		waitResponse()
	}
	
	def decreaseByButton(): Unit = {
		click(jq(".z-spinner-down"))
		waitResponse()
	}
	
	def increaseByKeyboard(): Unit = {
		sendKeys(jq(".z-spinner-input"), Keys.UP)
		waitResponse()
	}
	
	def decreaseByKeyboard(): Unit = {
		sendKeys(jq(".z-spinner-input"), Keys.DOWN)
		waitResponse()
	}
	
	def clearSpinnerValue(): Unit = {
		`type`(jq(".z-spinner-input"), "")
		waitResponse()
	}
}
