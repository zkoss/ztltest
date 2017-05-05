/* B70_ZK_2773Test.scala

	Purpose:
		
	Description:
		
	History:
		Thu Oct 15 10:36:48 CST 2015, Created by chunfu

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
@Tags(tags = "B70-ZK-2773.zul")
class B70_ZK_2773Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2773.zul

	Purpose:

	Description:

	History:
		Tue Jun  9 10:40:46 CST 2015, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<window border="normal" title="hello">
	Please click the datebox's icon to show the popup, and it shouldn't cover the datebox itself.
	<vlayout>
		<div height="800px">Welcome to ZK</div>
		<datebox format="dd/MM/yyyy" />
		<div height="1200px">Welcome to ZK</div>
	</vlayout>
</window>


		"""
runZTL(zscript, () => {
			click(jq(".z-datebox-button"))
			waitResponse()
			var pp = jq(".z-datebox-popup")
			var input = jq("@datebox")
			//compare top left corner
			var tl = input.offsetLeft() > pp.offsetLeft() && input.offsetLeft() < pp.offsetLeft() + pp.width() &&
				input.offsetTop() > pp.offsetTop() && input.offsetTop() < pp.offsetTop() + pp.height()
			//compare top right corner
			var tr = input.offsetLeft() + input.width() > pp.offsetLeft() && input.offsetLeft() + input.width() < pp.offsetLeft() + pp.width() &&
				input.offsetTop() > pp.offsetTop() && input.offsetTop() < pp.offsetTop() + pp.height()
			//compare bottom left corner
			var bl = input.offsetLeft() > pp.offsetLeft() && input.offsetLeft() < pp.offsetLeft() + pp.width() &&
				input.offsetTop() + input.height() > pp.offsetTop() && input.offsetTop() + input.height() < pp.offsetTop() + pp.height()
			//compare bottom right corner
			var br = input.offsetLeft() + input.width() > pp.offsetLeft() && input.offsetLeft() + input.width() < pp.offsetLeft() + pp.width() &&
				input.offsetTop() + input.height() > pp.offsetTop() && input.offsetTop() + input.height() < pp.offsetTop() + pp.height()
			println("********input info: ", input.offsetLeft(), input.offsetTop(), input.width(), input.height())
			println("********pp info: ", pp.offsetLeft(), pp.offsetTop(), pp.width(), pp.height())
			verifyFalse(tl || tr || bl || br)

		})
	}
}
