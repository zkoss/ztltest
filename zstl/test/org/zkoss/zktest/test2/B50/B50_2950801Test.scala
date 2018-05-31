/* B50_2950801Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_2950801Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<zk>
					Check it will not happen js error
					<borderlayout>
						<east>
							<hbox hflex="1" vflex="1" style="padding-top:20px"/>
						</east>
						<center>
							<label value="center" />
						</center>
					</borderlayout>
				</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      verifyFalse(jq(".z-error").exists())
    })
  }
}



