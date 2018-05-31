/* B36_2787876Test.java

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
import org.zkoss.ztl.Widget


class B36_2787876Test extends ZTL4ScalaTestCase {
  @Test
  def testconstraint() = {
    var zscript =
      """
			<zk>
			Please type the word '-' and then focus out the box, you should see a warning box.
			<textbox id="txt_test" constraint="/[a-z\\]*/, server"></textbox>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val txt_test = ztl$engine.$f("txt_test")
    runZTL(zscript, () => {
      sendKeys(txt_test, "-")
      blur(txt_test)
      verifyTrue(jq(".z-errorbox").exists())
    })
  }
}



