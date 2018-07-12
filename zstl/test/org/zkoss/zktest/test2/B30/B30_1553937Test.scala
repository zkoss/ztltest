/* B30_1553937Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1553937Test extends ZTL4ScalaTestCase {
  @Test
  def testWidth() = {
    var zscript =
      """
		<zk>
			listbox's horizontal scrollbar causes side effects
			<separator />
			<hbox width="300px">
				<listbox id="list" width="200px" height="200px" sizedByContent="true">
					<listitem>
						<listcell style="white-space: nowrap;"
							label="xxxx x xxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxx
		xxxxxxxxx xxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxx
		xxxxxxxxxxxxxxxxx" />
					</listitem>
				</listbox>
				<label value="Hi" style="font-size: 16px; font-weight: bold" />
			</hbox>
		</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val list = ztl$engine.$f("list")
    runZTL(zscript, () => {
      var w = Integer.valueOf(list.$n().parentNode().attr("offsetWidth"))
      verifyEquals(200, w)
    })
  }
}



