/* B35_2103813Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 12:20:33 TST 2011, Created by jumperchen

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
@Tags(tags = "B35-2103813.zul,B,E,Button,VisionTest")
class B35_2103813Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = {
			<zk>
				If the outline of the button looks great, the bug is fixed.
				<window>
					<window>
						<button width="100px" height="200px" label="Hello World, Bla Bla Bla"/>
					</window>
				</window>
			</zk>
		}
		runZTL(zscript, () => {
			verifyImage()
		})
	}
}
