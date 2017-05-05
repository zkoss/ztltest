/* B35_2182111Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 12:33:19 TST 2011, Created by jumperchen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;
import org.junit.Test

/**
 *
 * @author jumperchen
 */
@Tags(tags = "B35-2182111.zul,A,E,Tabbox,VisionTest")
class B35_2182111Test extends ZTL4ScalaTestCase {
  @Test
	def testCase() = {
		val zscript = """
			<window>
				<tabbox width="400px">
					<tabs>
						<tab label=""/>
						<tab label="Tab 2"/>
					</tabs>
					<tabpanels>
						<tabpanel>This is panel 1 and the tab with an empty label, if you see the tab styling looks strange that is a bug.</tabpanel>
						<tabpanel>
							This is panel 2 
The second panel
						</tabpanel>
					</tabpanels>
				</tabbox>
			</window>
		"""
runZTL(zscript, () => {
			verifyImage()
		})
	}
}
