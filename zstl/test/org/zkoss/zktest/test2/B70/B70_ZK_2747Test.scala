/* B70_ZK_2720Test.scala

	Purpose:
		
	Description:
		
	History:
		Wed Oct  7 16:49:43 CST 2015, Created by chunfu

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
@Tags(tags = "")
class B70_ZK_2747Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript ="""
<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2747.zul

	Purpose:

	Description:

	History:
		Mon Jun  1 14:27:27 CST 2015, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<window apply="org.zkoss.zktest.test2.B70_ZK_2747AsyncController">
	<label>You should see the message "I am busy" disappears in 3 seconds.(Servlet 3.0 only)</label>
	<!-- <window apply="org.zkoss.zktest.test2.B70_ZK_2747TimerController">
		<label>to be detached after 5 sec</label>
		<timer id="timer" />
	</window> -->
</window>
"""
		runZTL(zscript, () => {
			verifyTrue(jq("#zk_showBusy").exists())
			sleep(3000)
			verifyTrue(!jq("#zk_showBusy").exists())
		
		})
	}
}
