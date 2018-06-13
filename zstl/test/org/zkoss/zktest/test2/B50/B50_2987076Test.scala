/* B50_2987076Test.java

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


class B50_2987076Test extends ZTL4ScalaTestCase {
  @Test
  def testtooltiptext() = {
    var zscript =
      """
			<zk>
				<button id="setBtn" onClick='tr.tooltiptext="row"'/>
				<button id="getBtn" onClick='msg.value = tr.tooltiptext'/>
				<label id="msg"/>
			   <tree>
					<treechildren>
						<treeitem>
							<treerow id="tr">
								<treecell>
									Item 1
								</treecell>					
							</treerow>
						</treeitem>
					</treechildren>
				</tree>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val setBtn = ztl$engine.$f("setBtn")
    val getBtn = ztl$engine.$f("getBtn")
    val msg = ztl$engine.$f("msg")
    val tr = ztl$engine.$f("tr")
    runZTL(zscript, () => {
      click(setBtn)
      waitResponse()
      click(getBtn)
      waitResponse()
      verifyEquals("row", jq(msg).html())
    })
  }
}



