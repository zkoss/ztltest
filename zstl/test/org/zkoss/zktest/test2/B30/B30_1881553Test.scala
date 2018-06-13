/* B30_1881553Test.java

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


class B30_1881553Test extends ZTL4ScalaTestCase {
  @Test
  def testHeightOperating() = {
    var zscript =
      """
			<window>
				The tabbox's height shall be changed accordingly.
				<tabbox id="t" width="400px">
					<tabs>
						<tab label="Tab 1"/>
						<tab label="Tab 2"/>
					</tabs>
					<tabpanels>
						<tabpanel>This is panel 1</tabpanel>
						<tabpanel>This is panel 2</tabpanel>
					</tabpanels>
				</tabbox>
				<button id="oneHd" label="100" onClick='t.height = "100px"'/>
				<button id="twoHd" label="200" onClick='t.height = "200px"'/>
				<button id="threeHd" label="300" onClick='t.height = "300px"'/>
			</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val t = ztl$engine.$f("t")
    val oneHd = ztl$engine.$f("oneHd")
    val twoHd = ztl$engine.$f("twoHd")
    val threeHd = ztl$engine.$f("threeHd")
    runZTL(zscript, () => {
      click(oneHd)
      waitResponse()
      verifyTolerant(100, jq(t).height(), 2)
      click(twoHd)
      waitResponse()
      verifyTolerant(200, jq(t).height(), 2)
      click(threeHd)
      waitResponse()
      verifyTolerant(300, jq(t).height(), 2)
    })
  }
}



