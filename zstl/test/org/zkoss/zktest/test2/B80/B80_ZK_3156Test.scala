/* B80_ZK_3156Test.scala

	Purpose:

	Description:

	History:
		Thu, Sep 29, 2016 11:19:15 AM, Created by Sefi

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
class B80_ZK_3156Test extends ZTL4ScalaTestCase {
	@Test
	def test() = {
		runZTL(() => {
			val lb = jq(".z-label:eq(1)").text();
			if (isEdge()) {
				verifyTrue(lb.length > 6)
			}
		})
	}
}
