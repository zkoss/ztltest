/* B70_ZK_2709_1Test.scala

	Purpose:
		
	Description:
		
	History:
		Fri Oct 16 12:50:04 CST 2015, Created by chunfu

Copyright (C)  2015 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B70

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;
import org.junit.Test

/**
 * 
 * @author chunfu
 */
@Tags(tags = "B70-ZK-2709-1.zul")
class B70_ZK_2709_1Test extends ZTL4ScalaTestCase {
  @Test
	def testCase() = {
		val zscript = { """
			|<?xml version="1.0" encoding="UTF-8"?>
			|
			|<!--
			|B70-ZK-2709-1.zul
			|
			|	Purpose:
			|
			|	Description:
			|
			|	History:
			|		Tue Jun  9 11:51:52 CST 2015, Created by jumperchen
			|
			|Copyright (C)  Potix Corporation. All Rights Reserved.
			|
			|-->
			|<zk>
			|<label multiline="true" popup="pp">
			|1. click "ME" to open popup
			|2. press enter at the textbox
			|
			|3. you should see "it works" message at zk console (Firefox only)
			|</label>
			|<popup id="pp">
			|<textbox onBlur='Clients.log("it works")' onOK="self.parent.close()"></textbox>
			|</popup>
			|</zk>
			|
		""".stripMargin
		}

		runZTL(zscript, () => {
			//click on label!!!!!!
			clickAt(jq("@label"), "50,30")
			waitResponse()
			keyPress(jq("input"), "selenium is really suck!!!!!!")
			waitResponse()
			blur(jq("input"))
			waitResponse(500)
			verifyTrue(getZKLog().contains("it works"))
		})
	}
}
