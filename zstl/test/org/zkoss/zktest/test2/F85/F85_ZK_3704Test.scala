/* F85_ZK_3704Test.java

        Purpose:
        
        Description:
        
        History:
                Mon Jun 04 18:32:05 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.F85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class F85_ZK_3704Test extends ZTL4ScalaTestCase {
	
	@Test
	def test()=  {
		runZTL(() => {
			val testInput = "123456.789"
			val decimalboxOne = jq(".z-decimalbox:eq(0)")
			val decimalboxTwo = jq(".z-decimalbox:eq(1)")
			
			`type`(decimalboxOne, testInput)
			waitResponse()
			verifyEquals("1,23,456.789", decimalboxOne.`val`())
			
			`type`(decimalboxTwo, testInput)
			waitResponse()
			verifyEquals("123 456,789", decimalboxTwo.`val`())
			
			click(jq(".z-button"))
			waitResponse()
			verifyEquals("123.456,789", decimalboxOne.`val`())
		})
	}
}
