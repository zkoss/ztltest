/* B80_ZK_3143Test.scala

	Purpose:

	Description:

	History:
		Tue, Jun  7, 2016  4:31:50 PM, Created by Sefi

Copyright (C)  Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.{By, Keys}
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
 * 
 * @author Sefi
 */
@Tags(tags = "")
class B80_ZK_3143Test extends ZTL4ScalaTestCase {
	@Test
	def test() = {
		runZTL(() => {
			val shiftClick = new Actions(driver);
			val elements = driver().findElements(By.className("z-listitem-checkbox"))
			shiftKeyDown()

			shiftClick
				.click(elements.get(0))
				.keyDown(Keys.SHIFT)
				.click(elements.get(5))
				.keyUp(Keys.SHIFT)
				.perform()
			verifyEquals("", getEval("(zk.ie && zk.ie == 8) ? document.selection.createRange().text : window.getSelection().toString()"))
		})
	}
}
