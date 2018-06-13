/* B50_2941554Test.java

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


class B50_2941554Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<tabbox>
				    <tabs>
				        <tab id="t1" label="t1"/>
				        <tab id="t2" label="t2"/>
				    </tabs>
				    <tabpanels>
				        <tabpanel>
				            <textbox constraint="no empty, after_start" focus="true"/>
				            <button id="btn" label="click me" popup="pp"/>
				            <popup width="300px" id="pp">
				                After click the t2 tab, the popup and the errorbox should be hidden.
				            </popup>
				        </tabpanel>
				    </tabpanels>
				</tabbox>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val t1 = ztl$engine.$f("t1")
    val t2 = ztl$engine.$f("t2")
    val btn = ztl$engine.$f("btn")
    val pp = ztl$engine.$f("pp")
    runZTL(zscript, () => {
      verifyFalse(jq("@popup").exists())
      verifyFalse(jq("@errorbox").exists())
      click(jq("@button"))
      waitResponse()
      verifyTrue(jq("@popup").isVisible())
      verifyTrue(jq("@errorbox").isVisible())
      click(t2)
      waitResponse()
      sleep(500)
      verifyFalse(jq("@popup").isVisible())
      verifyFalse(jq("@errorbox").isVisible())
    })
  }
}



