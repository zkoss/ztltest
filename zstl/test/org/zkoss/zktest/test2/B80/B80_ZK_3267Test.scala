/* B80_ZK_3267Test.scala

	Purpose:

	Description:

	History:
		Fri, Sep 30, 2016 11:38:39 AM, Created by Sefi

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
class B80_ZK_3267Test extends ZTL4ScalaTestCase {
	@Test
	def test() = {
		runZTL(() => {
			click(jq("@combobox"))
			waitResponse()
			`type`(jq(".z-combobox-input"), "a")
			waitResponse()
			verifyFalse(jq(".z-combobox-popup").exists())
		})
	}
}
