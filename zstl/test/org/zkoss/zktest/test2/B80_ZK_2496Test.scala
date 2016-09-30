/* B80_ZK_2496Test.scala

	Purpose:
		
	Description:
		
	History:
		Fri, Sep 30, 2016 11:45:54 AM, Created by Sefi

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
class B80_ZK_2496Test extends ZTL4ScalaTestCase {
	@Test
	def test() = {
		runZTL(() => {
			val pn = jq("@panel")
			val wnx = pn.positionLeft()
			val wny = pn.positionTop()
			mouseDownAt(pn, (pn.outerWidth() - 2) + "," + (pn.outerHeight() - 2))
			mouseMoveAt(pn, (pn.outerWidth() + 20) + "," + (pn.outerHeight() + 20))
			mouseUp(pn)
			waitResponse()
			verifyEquals(wnx, pn.positionLeft())
			verifyEquals(wny, pn.positionTop())
		})
	}
}
