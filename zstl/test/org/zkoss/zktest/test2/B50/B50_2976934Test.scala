/* B50_2976934Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_2976934Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    var zscript =
      """
					<zk>
						<div onClick="">
							<checkbox id="cb" label="click me"/>
						</div>
					</zk>
                """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val cb = ztl$engine.$f("cb")
    runZTL(zscript, () => {
      click(cb.$n("real"))
      verifyEquals(true, jq(cb.$n("real")).eval("prop('checked')"));
    })
  }
}



