/* B80_ZK_2890Test.scala

	Purpose:

	Description:

	History:
		Tue, Jun  7, 2016 11:30:17 AM, Created by Sefi

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
class B80_ZK_2890Test extends ZTL4ScalaTestCase {
	@Test
	def test() = {
		runZTL(() => {
			val treerow = jq(".z-treerow").eq(0)
			mouseDownAt(treerow, "10,10")
			waitResponse()
			mouseMoveAt(treerow, "100,10")
			waitResponse()

			val ghost = jq("#zk_ddghost")
			verifyTrue(ghost.exists())
			val content = ghost.find(".z-drop-content")
			verifyEquals(content.length(), 3)
			verifyTrue(content.eq(0).text().endsWith("1"))
			verifyTrue(content.eq(1).text().endsWith("2"))
			verifyTrue(content.eq(2).text().endsWith("2.1"))
		})
	}
}
