/* B70_ZK_2709Test.scala

	Purpose:
		
	Description:
		
	History:
		Fri Oct 16 09:16:52 CST 2015, Created by chunfu

Copyright (C)  2015 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B70

import java.text.SimpleDateFormat
import java.util.Calendar

import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
 * 
 * @author chunfu
 */
@Tags(tags = "B70-ZK-2709.zul")
class B70_ZK_2709Test extends ZTL4ScalaTestCase {
	def testCase() = {
		runZTL(() => {
			click(jq(".z-datebox-button"))
			waitResponse()
			var timebox = jq("@timebox input")
			click(timebox)
			waitResponse()
			for (_ <- 1 to 10) sendKeys(timebox, Keys.ARROW_LEFT)
			waitResponse()
			sendKeys(timebox, "11" + Keys.ENTER)
			waitResponse()
			var dateboxInput = jq(".z-datebox-input").`val`()
			var today = Calendar.getInstance()
			today.set(Calendar.HOUR, 11);

			var timeFormat = new SimpleDateFormat("hh")
			//only compare hour
			verifyTrue(dateboxInput.contains(timeFormat.format(today.getTime())))
		})
	}
}
