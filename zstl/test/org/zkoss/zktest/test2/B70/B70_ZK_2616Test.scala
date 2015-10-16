/* B70_ZK_2616Test.scala

	Purpose:
		
	Description:
		
	History:
		Thu Oct  8 17:08:19 CST 2015, Created by chunfu

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
@Tags(tags = "B70-ZK-2616.zul")
class B70_ZK_2616Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = { """
			|<?xml version="1.0" encoding="UTF-8"?>
			|
			|<!--
			|B70-ZK-2616.zul
			|
			|	Purpose:
			|
			|	Description:
			|
			|	History:
			|		Thu Jun  4 10:02:42 CST 2015, Created by jumperchen
			|
			|Copyright (C)  Potix Corporation. All Rights Reserved.
			|
			|-->
			|<zk>
			|	<window apply="org.zkoss.bind.BindComposer"
			|		viewModel="@id('vm')@init('org.zkoss.zktest.test2.ZK_2616VM')"
			|		validationMessages="@id('vmsgs')">
			|		<label multiline="true">
			|			1. Please click the "Hit me first".
			|			2. Quickly click the "Hit me second" many times.
			|			3. After the process loading icon disappeared, you should not see a timeout page. (i.e. the page should stay in the same page)
			|		</label>
			|		<button label="Hit me first!" onClick="@command('cmd')"/>
			|      <button label="Hit me second!" onClick="@command('cmd2')" />
			|	</window>
			|</zk>
			|
		""".stripMargin
		}

		runZTL(zscript, () => {
			click(jq("@button"))
			for (i <- 0 to 5) {
				click(jq("@button").eq(1))
			}
			waitResponse()

			var window = jq(".z-window-header");
			verifyTrue(!window.exists() || window.text().equals("Session Timeout"))

		})
	}
}
