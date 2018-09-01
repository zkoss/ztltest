/* B36_2796335Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2796335Test extends ZTL4ScalaTestCase {
  @Test
  def testscrollIntoView() = {
    var zscript =
      """
			<borderlayout height="100%" style="background:white;">
				<west title="ScrollIntoView" size="350px" flex="true">
					<tabbox>
						<tabs>
							<tab label="Test" />
						</tabs>
						<tabpanels height="100%" style="overflow:auto;">
							<tabpanel id="treeTabpanel">
								<panel border="normal">
									<panelchildren
										style="border:0;overflow:auto;">
										<div height="100px" style="overflow:auto" id="div1">
											<div height="150px"
												style="overflow:auto"  id="div2">
												<label id="t1" value="Top Div target" />
												<div height="200px"></div>
												<label id="t2" value="Bottom Div target" />
											</div>
										</div>
										<button label="Click Me, you should see 'Bottom Div target'"
											onClick="Clients.scrollIntoView(t2)" id="bottom"/>
										<button label="Click Me, you should see 'Top Div target'"
											onClick="Clients.scrollIntoView(t1)" id="top"/>
									</panelchildren>
								</panel>
							</tabpanel>
						</tabpanels>
					</tabbox>
				</west>
			</borderlayout>
		"""
    val ztl$engine = engine()
    val treeTabpanel = ztl$engine.$f("treeTabpanel")
    val div1 = ztl$engine.$f("div1")
    val div2 = ztl$engine.$f("div2")
    val t1 = ztl$engine.$f("t1")
    val t2 = ztl$engine.$f("t2")
    val bottom = ztl$engine.$f("bottom")
    val top = ztl$engine.$f("top")
    runZTL(zscript, () => {
      click(bottom)
      waitResponse()
      verifyEquals("50", div1.attr("scrollTop"))
      var scrollTop = 84
      verifyTolerant(scrollTop, parseInt(div2.attr("scrollTop")), 6)
      click(top)
      waitResponse()
      scrollTop = 0
      verifyEquals("0", div1.attr("scrollTop"))
      verifyTolerant(scrollTop, parseInt(div2.attr("scrollTop")), 6)
    })
  }
}



