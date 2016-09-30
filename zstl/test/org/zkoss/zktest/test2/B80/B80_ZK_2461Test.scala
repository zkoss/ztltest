/* B80_ZK_2461Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Oct 27 10:13:02 CST 2015, Created by chunfu

Copyright (C)  2015 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B80

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;
import org.junit.Test

/**
 * 
 * @author chunfu
 */
@Tags(tags = "B80-ZK-2461.zul")
class B80_ZK_2461Test extends ZTL4ScalaTestCase {
  @Test
	def testCase() = {
		runZTL(() => {
			var initWidth = 0
			for (w <- getZKLog.split('\n')) initWidth += w.toInt
			click(jq("@button"))
			waitResponse()
			click(jq("@button").eq(1))
			waitResponse()
			var afterWidth = 0
			for (w <- getZKLog.split('\n')) afterWidth += w.toInt
			println("************", initWidth, afterWidth)
			verifyTolerant(initWidth, afterWidth - initWidth, 2)
		})
	}
}
