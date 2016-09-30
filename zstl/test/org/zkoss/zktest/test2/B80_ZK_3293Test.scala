/* B80_ZK_3293Test.scala

	Purpose:
		
	Description:
		
	History:
		Fri, Sep 30, 2016 11:29:15 AM, Created by Sefi

Copyright (C)  Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
 * 
 * @author Sefi
 */
@Tags(tags = "")
class B80_ZK_3293Test extends ZTL4ScalaTestCase {
	@Test
	def test() = {
		runZTL(() => {
			val sp = jq("@splitter")
			val tb = jq("@tabbox")
			val tbw = tb.width()
			mouseDownAt(sp, "2, 2")
			mouseMoveAt(sp, "22, 2")
			mouseUp(sp)
			waitResponse()
			verifyEquals(tbw - 20, tb.width())
		})
	}
}
