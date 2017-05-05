/* B50_ZK_548Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 14:47:36 TST 2011, Created by jumperchen

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
@Tags(tags = "B50-ZK-548.zul,B,M,Toolbar,CSS,VisionTest")
class B50_ZK_548Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = """
			<zk>
				<div>
					Breeze only. The background color should not be cut in half.
				</div>
				<window title="new page title" border="normal">
					<toolbar orient="vertical" height="300px">
						<toolbarbutton label="Example"/>
						<toolbarbutton label="Example"/>
						<toolbarbutton label="Example"/>
						<toolbarbutton label="Example"/>
						<toolbarbutton label="Example"/>
						<toolbarbutton label="Example"/>
						<toolbarbutton label="Example"/>
					</toolbar>
				</window>
			</zk>
		"""
runZTL(zscript, () => {
			verifyImage()
		})
	}
}
