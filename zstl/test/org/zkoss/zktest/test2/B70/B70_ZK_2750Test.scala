/* B70_ZK_2750Test.scala

	Purpose:
		
	Description:
		
	History:
		Wed Oct 14 18:25:36 CST 2015, Created by chunfu

Copyright (C)  2015 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B70

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
 * 
 * @author chunfu
 */
@Tags(tags = "B70-ZK-2750.zul")
class B70_ZK_2750Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2750.zul

	Purpose:

	Description:

	History:
		Thu Jun  4 17:48:53 CST 2015, Created by chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<label multiline="true">
	1. click each button in IE
	2. the width of West won't change
	</label>
	<borderlayout id="borderLayout">
		<west>
			<vlayout>
				resize the browserwindow, or pressing any of the buttons will move the separator 1px to the right
				<button label="invalidate center" onClick="center.invalidate();"/>
				<button label="invalidate borderlayout" onClick="borderLayout.invalidate();"/>
				<button label="resize borderlayout" onClick="Clients.resize(borderLayout);"/>
			</vlayout>
		</west>
		<center id="center">
		</center>
	</borderlayout>
</zk>


		"""
runZTL(zscript, () => {
			var buttons = jq("@button")
			var beginWidth = jq("@west").width();
			for (i <- 0 to buttons.length() - 1) {
				for (j <- 0 to 5) {
					click(buttons.eq(i))
					waitResponse()
				}
			}
			verifyEquals(beginWidth, jq("@west").width())
		})
	}
}
