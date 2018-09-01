/* B50_ZK_444Test.java

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
import org.zkoss.ztl.unit.Widget


class B50_ZK_444Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """

			<zk>
				<toolbar>
					<toolbarbutton id="btn" label="click me" onClick='alert(componentScope.get("key"))' >
						<custom-attributes key="SomeValue" />
					</toolbarbutton>
				</toolbar>
				<div>
					Click on the Toolbarbutton. There should be a Messagebox and no javascript error.
				</div>
			</zk>

		"""
    val ztl$engine = engine()
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      click(btn)
      waitResponse()
      verifyTrue(jq(".z-messagebox-window").exists())
      verifyFalse(jq(".z-error").exists())
    })
  }
}



