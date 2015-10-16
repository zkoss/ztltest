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
		val zscript = { """
			|<?xml version="1.0" encoding="UTF-8"?>
			|
			|<!--
			|B70-ZK-2709.zul
			|
			|	Purpose:
			|
			|	Description:
			|
			|	History:
			|		Tue Jun  9 11:26:25 CST 2015, Created by jumperchen
			|
			|Copyright (C)  Potix Corporation. All Rights Reserved.
			|
			|-->
			|<zk>
			|<label multiline="true">
			|1. Open the datebox's popup and focus in the first word of the timebox.
			|2. Quickly type 11 and press "ENTER" key (Firefox only)
			|3. You should see the input of the datebox should be updated to what you type.
			|
			|</label>
			|<datebox width="250px" format="medium+short"/>
			|</zk>
			|
		""".stripMargin
		}

		runZTL(zscript, () => {
			click(jq(".z-datebox-button"))
			waitResponse()
			var timebox = jq("@timebox input")
			focus(timebox)
			waitResponse()
			sendKeys(timebox, Keys.HOME)
			keyPress(timebox, "11")
			sendKeys(timebox, Keys.ENTER)
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
