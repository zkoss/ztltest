/* B35_2313445Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 12:43:21 TST 2011, Created by jumperchen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
 *
 * @author jumperchen
 */
@Tags(tags = "B35-2313445.zul,B,E,Tabbox,VisionTest")
class B35_2313445Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = """
			<zk>
				After you click the button, the layout of the tabbox should be the same as previous one.
				<tabbox id="tb2" orient="vertical">
					<tabs id="tabs" width="20px">
						<tab label="A"/>
						<tab label="B"/>
						<tab label="C"/>
						<tab label="D"/>
						<tab label="E"/>
					</tabs>
				</tabbox>
				<button id="btn" label="tabs.invalidate()" onClick="tabs.invalidate();"/>
			</zk>
		"""
runZTL(zscript, () => {
			verifyImage();
			click(engine.$f("btn"));
			waitResponse();
			verifyImage();
		})
	}
}
