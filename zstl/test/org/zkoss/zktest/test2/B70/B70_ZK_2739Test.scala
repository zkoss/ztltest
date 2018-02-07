/* B70_ZK_2739Test.scala

	Purpose:
		
	Description:
		
	History:
		Wed Oct 14 18:31:19 CST 2015, Created by chunfu

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
@Tags(tags = "B70-ZK-2739.zul")
class B70_ZK_2739Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2739.zul

	Purpose:

	Description:

	History:
		Fri, Jun 5, 2015  14:30:29 PM, Created by Jameschu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<script>
		<![CDATA[
		setInterval(function () {
			if (zk.currentFocus && zk.currentFocus._label) {
				zk.log(zk.currentFocus._label);
			}
		}, 100)
		]]>
	</script>
	<window border="normal" title="Test" height="500px"
		contentStyle="overflow-y:scroll;" mode="modal">
		<vlayout spacing="10px">
			<textbox />
			<label multiline="true">
    			1. Click one of the buttons in the end of the page, one new modal is created.
    			2. Click 'close'
    			3. The focus must return to the last element focused in the previous popup.(Must test in Chrome)
			</label>
			<hlayout>
				<textbox />
				<button label="Open Modal button without autodisabled"
					onClick='Executions.createComponents("test2/B70-ZK-2739_1.zul", null, null)' />
			</hlayout>
			<hlayout>
				<textbox />
				<button label="Open Modal button with autodisabled"
					onClick='Executions.createComponents("test2/B70-ZK-2739_1.zul", null, null)' autodisable="self" />
			</hlayout>
		</vlayout>
	</window>
</zk>


		"""
runZTL(zscript, () => {
			var buttons = jq("@button")
			for (i <- 0 to buttons.length() - 1) {
				click(buttons.eq(i))
				waitResponse()
				click(jq("@window").last().find("@button"))
				waitResponse()
				sleep(200)
				var log: Array[String] = jq("#zk_log").`val`().split('\n');
				verifyEquals(buttons.eq(i).text(), log(log.length -1).trim)
			}
		})
	}
}
