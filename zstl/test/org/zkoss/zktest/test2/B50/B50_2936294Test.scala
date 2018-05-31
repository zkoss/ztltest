/* B50_2936294Test.java

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


class B50_2936294Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<zk>
					<listbox id="listbox">
						<listitem label="listitem 1"/>
						<listitem label="listitem 2" selected="true"/>
					</listbox>
					<button id="btn" label="Click Me to clear the selection" onClick='listbox.setSelectedItem(null)'/>
				</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val listbox = ztl$engine.$f("listbox")
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      verifyTrue(jq(".z-listitem-selected").exists())
      click(btn)
      waitResponse()
      verifyFalse(jq(".z-listitem-selected").exists())
    })
  }
}



