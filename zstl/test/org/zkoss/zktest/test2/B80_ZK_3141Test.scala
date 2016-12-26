/* B80_ZK_3141Test.scala

	Purpose:
		
	Description:
		
	History:
		Fri, Sep 30, 2016 11:52:08 AM, Created by Sefi

Copyright (C)  Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{Tags, ZK};

/**
 * 
 * @author Sefi
 */
@Tags(tags = "")
class B80_ZK_3141Test extends ZTL4ScalaTestCase {
	@Test
	def test() = {
		runZTL(() => {
			var t = jq("@textbox")
			focus(t)
			blur(t)
			waitResponse()
			verifyTrue(jq(".z-errorbox:visible").length() > 0)
			chkpos

			click(jq("@button:eq(0)"))
			waitResponse()
			chkpos

			click(jq("@button:eq(1)"))
			waitResponse()
			chkpos

			click(jq("@button:eq(2)"))
			waitResponse()
			chkpos

			click(jq("@button:eq(0)"))
			waitResponse()

			val hd = jq(".z-window-header")
			mouseDownAt(hd, "10, 10")
			mouseMoveAt(hd, "30, 30")
			mouseUp(hd)
			waitResponse()
			chkpos
		})
	}
	def chkpos() = {
		val t = jq("@textbox")
		val tt = t.offsetTop()
		val tr = t.offsetLeft() + t.outerWidth()
		val er = jq(".z-errorbox:visible")
		if (isEdge() || ZK.is("ie10_") || ZK.is("ie11_")) {
			verifyTolerant(tt, er.offsetTop(), 1)
		} else {
			verifyEquals(tt, er.offsetTop())
		}
		if (isEdge() || ZK.is("ie10_") || ZK.is("ie11_")) {
			verifyTolerant(tr, er.offsetLeft(), 1)
		} else {
			verifyEquals(tr, er.offsetLeft())
		}
	}
}
