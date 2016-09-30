/* B80_ZK_3217Test.scala

	Purpose:
		
	Description:
		
	History:
		Thu, Sep 29, 2016 11:41:45 AM, Created by Sefi

Copyright (C)  Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
 * 
 * @author Sefi
 */
@Tags(tags = "")
class B80_ZK_3217Test extends ZTL4ScalaTestCase {
	@Test
	def test() = {
		runZTL(() => {
			val db = jq("@datebox")
			val window = driver.manage().window()
			val clientHeight = getEval("window.innerHeight").toInt
			val offset = db.offsetTop() + db.outerHeight() - clientHeight
			val button = jq(".z-datebox-button")
			runScript("window.scrollTo(0," + offset + ")")
			click(button)
			val popup = jq(".z-datebox-popup")
			val orgHeight = popup.positionTop()
			sleep(300)
			verifyEquals(orgHeight, popup.positionTop())
		})
	}
}
