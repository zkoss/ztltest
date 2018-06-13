/* B50_ZK_460Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_ZK_460Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """

			<zk>
				<div>Click on the up/down button of Spinner/Timebox. 
				The value should NOT be shown immediately on the right. 
				(i.e. onChange shall NOT be fire upon clicking on up/down button.)</div>
				<listbox width="350px">
					<listitem>
						<listcell>
							<spinner onChange='lc1.label = event.value' />
						</listcell>
						<listcell id="lc1" />
					</listitem>
					<listitem>
						<listcell>
							<timebox onChange='lc2.label = event.value' />
						</listcell>
						<listcell id="lc2" />
					</listitem>
				</listbox>
			</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val lc1 = ztl$engine.$f("lc1")
    val lc2 = ztl$engine.$f("lc2")
    runZTL(zscript, () => {
      click(jq(".z-spinner").toWidget().$n("btn-up"))
      waitResponse()
      verifyTrue(lc1.$n().get("value").length() == 0)
      click(jq(".z-spinner").toWidget().$n("btn-down"))
      waitResponse()
      verifyTrue(lc1.$n().get("value").length() == 0)
      click(jq(".z-timebox").toWidget().$n("btn-up"))
      waitResponse()
      click(jq(".z-timebox").toWidget().$n("btn-up"))
      waitResponse()
      verifyTrue(lc2.$n().get("value").length() == 0)
      click(jq(".z-timebox").toWidget().$n("btn-down"))
      waitResponse()
      verifyTrue(lc2.$n().get("value").length() == 0)
    })
  }
}



