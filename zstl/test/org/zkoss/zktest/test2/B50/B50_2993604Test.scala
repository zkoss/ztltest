/* B50_2993604Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2993604Test extends ZTL4ScalaTestCase {
  @Test
  def testopen() = {
    var zscript =
      """
			<zk>
				<button id="btn" label="change label" onClick='treecell.label="new Name"' />
				<tree>
					<treechildren>
						<treeitem>
							<treerow id="treerow">
								<treecell label="Item" id="treecell" />
							</treerow>
							<treechildren>
								<treeitem>
									<treerow>
										<treecell label="Item 1" />
									</treerow>
								</treeitem>
							</treechildren>
						</treeitem>
					</treechildren>
				</tree>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val btn = ztl$engine.$f("btn")
    val treerow = ztl$engine.$f("treerow")
    val treecell = ztl$engine.$f("treecell")
    runZTL(zscript, () => {
      var openIcon = treerow.$n("open")
      click(openIcon)
      waitResponse()
      click(btn)
      waitResponse()
      click(openIcon)
      waitResponse()
      verifyTrue(jq(treerow.$n("icon")).is("[class*=down]"));
    })
  }
}



