/* B50_ZK_535Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 14:40:01 TST 2011, Created by jumperchen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
 *
 * @author jumperchen
 */
@Tags(tags = "B50-ZK-535.zul,B,E,Listbox,Listhead,Style,IE8,VisionTest")
class B50_ZK_535Test extends ZTL4ScalaTestCase {
	def resetTheme(theme: String) {
		runZTL({
			"""<zk>
				<zscript><![CDATA[
					org.zkoss.zkplus.theme.Themes.setTheme(Executions.getCurrent(), """" + theme + """");
				]]></zscript>
			</zk>"""
		},
			() => {
				refresh();
			})
	}
	def testCase() = {
		val zscript = {
			<zk>
				1. Please click the blue button to change the theme.
				<separator/>
				2. In IE8, you should see a border between the headers.
				<vbox>
					<listbox width="300px">
						<listhead sizable="true">
							<listheader align="center" width="40px" label="xxs"/>
							<listheader align="center" width="40px" label="xxs"/>
							<listheader align="center" width="40px" label="xxs"/>
							<listheader sort="auto" label="Subject"/>
							<listheader label="Received"/>
						</listhead>
					</listbox>
				</vbox>
			</zk>
		}
		try {
			runZTL(<zk></zk>, () => {
				runRawZscript({
					"""<zk>
						<zscript><![CDATA[
							org.zkoss.zkplus.theme.Themes.setTheme(Executions.getCurrent(), "classicblue");
						]]></zscript>
					</zk>"""
				})
				refresh()
				waitForPageToLoad("10000")
				waitResponse

				runRawZscript(zscript.toString())
				waitResponse
				verifyImage()
			})
		} finally {
			resetTheme("breeze")
		}
	}
}
