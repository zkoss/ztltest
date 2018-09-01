/* B36_2810794Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2810794Test extends ZTL4ScalaTestCase {
  @Test
  def testjsError() = {
    var zscript =
      """
			<zk>
			You should not see any Javascript error in IE only
			<grid>
			<columns>
			<column label='column 1'/>
			<column label='column 2'/>
			<column label='column 3'/>
			<column label='column 4'/>
			<column label='column 5'/>
			</columns>
			</grid>
			</zk>
		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      verifyFalse(jq("div.z-error").exists())
    })
  }
}



