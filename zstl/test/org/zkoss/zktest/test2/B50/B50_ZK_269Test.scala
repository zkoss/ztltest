/* B50_ZK_269Test.java

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


class B50_ZK_269Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """

			<zk>
				<div>1. Opera only</div>
				<div>2. The width of each Listheader should be exactly 50% of the whole Listbox width.</div>
				<listbox id="lb" width="200px">
					<listhead>
						<listheader id="lh" label="header1"/>
						<listheader id="lh2" label="header2"/>
					</listhead>
				</listbox>
			</zk>

		"""
    val ztl$engine = engine()
    val lb = ztl$engine.$f("lb")
    val lh = ztl$engine.$f("lh")
    val lh2 = ztl$engine.$f("lh2")
    runZTL(zscript, () => {
      var lbw = jq(lb.$n()).width()
      var lhw = jq(lh.$n()).outerWidth()
      var lhw2 = jq(lh2.$n()).outerWidth()
      verifyTolerant(lhw, lhw2, 1)
      verifyTolerant((lhw + lhw2), lbw, 1)
    })
  }
}



