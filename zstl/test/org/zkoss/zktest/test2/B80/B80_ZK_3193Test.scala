/* B80_ZK_3193Test.scala

	Purpose:

	Description:

	History:
		Wed, Jun  8, 2016  2:39:51 PM, Created by Sefi

Copyright (C)  Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
 * 
 * @author Sefi
 */
@Tags(tags = "")
class B80_ZK_3193Test extends ZTL4ScalaTestCase {
	@Test
	def test() = {
		runZTL(() => {
			val bandbox = jq("@bandbox")
			click(bandbox.find(".z-bandbox-button"))
			waitResponse()

			val listbox = jq("@listbox")
			clickAt(listbox, (listbox.width()-5).toString + "," + (listbox.height()-5).toString)
			waitResponse()
			click(jq("body"))
			waitResponse()
			verifyEquals("", getZKLog)
		})
	}
}
