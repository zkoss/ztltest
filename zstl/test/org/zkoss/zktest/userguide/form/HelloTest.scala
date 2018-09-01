/* HelloTest.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.userguide.form

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class HelloTest extends ZTL4ScalaTestCase {
  @Test
  def testHello() = {
    var zscript =
      """
		<window title="My First window" border="normal" width="200px">
			<label value="Hello, World!" />
			<button label="Hi" onClick='alert("Welcome")'/>
		</window>
				  
		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      verifyEquals("My First window", jq(".z-window-header").text())
      verifyEquals("Hello, World!", jq(".z-label").text())
    })
  }
}



