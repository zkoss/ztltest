/* B50_2984382Test.java

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
import org.zkoss.ztl.unit.Widget


class B50_2984382Test extends ZTL4ScalaTestCase {
  @Test
  def testdropdownList() = {
    var zscript =
      """
					<zk>
						<grid>
							<rows>
								<row>
									<label value="name" />
									<combobox id="cb"/>
								</row>			
							</rows>
						</grid>
					</zk>
                """
    val ztl$engine = engine()
    val cb = ztl$engine.$f("cb")
    runZTL(zscript, () => {
      click(cb.$n("btn"))
      verifyEquals(jq(cb.$n()).offsetLeft() + "px", jq(cb.$n("pp")).css("left"));
    })
  }
}



