/* B50_2988187Test.java

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


class B50_2988187Test extends ZTL4ScalaTestCase {
  @Test
  def testPopup() = {
    var zscript =
      """
		<zk>
			<tabbox>
				<tabs>
					<tab label="tab1"/>
				</tabs>
				<tabpanels>
					<tabpanel>
						<button id="btn" label="click me" popup="pp"/>
						<popup id="pp" width="300px">
							Here is a Popup.
						</popup>
					</tabpanel>
				</tabpanels>
			</tabbox>
		</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val btn = ztl$engine.$f("btn")
    val pp = ztl$engine.$f("pp")
    runZTL(zscript, () => {
      click(btn)
      waitResponse();
      verifyTrue(isVisible(pp))
    })
  }
}



