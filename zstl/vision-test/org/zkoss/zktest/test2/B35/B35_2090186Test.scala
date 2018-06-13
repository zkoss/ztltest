/* B35_2090186Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 12:15:23 TST 2011, Created by jumperchen

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
@Tags(tags = "B35-2090186.zul,B,E,Window,VisionTest")
class B35_2090186Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = """
			<window title="window1">
				1. click the maximized button of window2
				<separator/>
				2. try to re-size window2 by dragging the right border of window2.
				<separator/>
				3.If you can drag-drop the window, that is wrong.
				<window id="minmaxWin" title="window2" sizable="true" minimizable="true" maximizable="true" border="normal">
					<window title="window3" border="normal" width="50%" height="50%">
						aaaa
					</window>
				</window>
			</window>
		"""
runZTL(zscript, () => {
			verifyImage()
			click(jq("$minmaxWin").toWidget().$n("max"))
			waitResponse()
			mouseDownAt(jq("$minmaxWin"), "5,5")
			mouseMoveAt(jq("$minmaxWin"), "10,5");
			verifyImage()
		})
	}
}
