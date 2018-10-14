/* B50_ZK_352Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_ZK_352Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """

			<zk>
				<div>Scroll to the right. You should NOT see the last 2 Columns.</div>
				<listbox id="lb" width="400px">
					<listhead>
						<listheader label="Column 1" width="250px" />
						<listheader label="Column 2" width="250px" />
						<listheader id="lh1" label="Column 3" hflex="2" />
						<listheader id="lh2" label="Column 4" hflex="1" />
					</listhead>
					<listitem forEach="1,2,3">
						<listcell forEach="1,2,3,4">Listcell</listcell>
					</listitem>
				</listbox>
			</zk>

		"""
    val ztl$engine = engine()
    val lb = ztl$engine.$f("lb")
    val lh1 = ztl$engine.$f("lh1")
    val lh2 = ztl$engine.$f("lh2")
    runZTL(zscript, () => {
      lb.$n("body").eval("scrollLeft = 500")
      waitResponse()
      verifyTrue(parseInt(lb.$n("body").attr("scrollLeft")) < 110)
      verifyEquals(lh1.$n().attr("width"), "")
      verifyEquals(lh1.$n("cave").attr("width"), "")
      verifyEquals(lh2.$n().attr("width"), "")
      verifyEquals(lh2.$n("cave").attr("width"), "")
    })
  }
}



