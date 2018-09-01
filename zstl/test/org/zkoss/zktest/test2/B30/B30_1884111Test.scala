/* B30_1884111Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1884111Test extends ZTL4ScalaTestCase {
  @Test
  def testClosingWindow() = {
    var zscript =
      """
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
			<n:p>
			<n:ol>
			<n:li>
			Click on "Please Click Me"
			</n:li>
			<n:li>
			Click on "Ok" in the modal window
			</n:li>
			<n:li>
			Modal Window disappears
			</n:li>
			<n:li>
			If the modal window disappears in 7 seconds, it is correct
			</n:li>
			</n:ol>
			</n:p>
			<window id="form" width="750px" height="490px" border="normal"
				contentStyle="background:#D3DBF4;">
				<tabbox width="400px">
					<tabs>
						<tab label="Tab 1" />
						<tab label="Tab 2" />
						<tab label="Tab 3" />
						<tab label="Tab 4" />
					</tabs>
					<tabpanels>
						<tabpanel>This is panel 1</tabpanel>
						<tabpanel>
							<vbox>
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
							</vbox>
						</tabpanel>
						<tabpanel>
							<vbox>
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
							</vbox>
						</tabpanel>
						<tabpanel>
							<vbox>
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
								<textbox visible="false" />
							</vbox>
						</tabpanel>
					</tabpanels>
				</tabbox>
				<button id="myBtn"
					onClick='alert("If you close the dialog, the background shall appear soon (IE7 only)")'
					label="Please Click Me" />
			</window>
			</zk>
		"""
    val ztl$engine = engine()
    val form = ztl$engine.$f("form")
    val myBtn = ztl$engine.$f("myBtn")
    runZTL(zscript, () => {
      click(myBtn)
      waitResponse()
      verifyTrue(jq(".z-window-highlighted").exists())
      click(jq(".z-messagebox-button"))
      waitResponse()
      verifyFalse(jq(".z-window-highlighted").exists())
    })
  }
}



