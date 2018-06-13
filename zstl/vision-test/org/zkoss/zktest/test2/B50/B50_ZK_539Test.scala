/* B50_ZK_539Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 14:44:48 TST 2011, Created by jumperchen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;
import org.junit.Test

/**
 *
 * @author jumperchen
 */
@Tags(tags = "B50-ZK-539.zul,B,E,Groupbox,VisionTest")
class B50_ZK_539Test extends ZTL4ScalaTestCase {
  
  @Test
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
		val zscript = """
			<groupbox width="200px" mold="3d" height="200px" open="false">
				<caption image="/test2/img/inet.png" label="Testing Group Box">
				</caption>
				<div style="background:#B8D335" vflex="1"> or vflex="1"</div>
			</groupbox>
		}
		try {
			runZTL(
				<zk></zk>,
				() => {
					for (theme <- List("breeze", "classicblue", "sapphire", "silvertail", "iceblue")) {
						runRawZscript({
							"""<zk>
								<zscript><![CDATA[
									org.zkoss.zkplus.theme.Themes.setTheme(Executions.getCurrent(), """" + theme + """");
								]]></zscript>
							</zk>"""
						})
						refresh()
						waitForPageToLoad("10000")
						waitResponse()

						runRawZscript(zscript.toString())
						waitResponse()
						verifyImage()
					}
				});
		} finally {
			resetTheme("iceblue")
		}
	}
}
