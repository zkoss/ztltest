/* B50_ZK_414Test.java

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


class B50_ZK_414Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """

			<window title="Scrollbar Issue" border="normal" width="700px"
				height="500px">
				1. Please scroll to the end of the tree.
				<separator/>
				2. Click +/- button to open the treeitem "something".
				<separator/>
				3. You should see the scrollbar won't jump to the top of the tree.
				<tree id="groupTree" mold="paging" pageSize="500" vflex="true"
					zclass="z-dottree">
					<treecols>
						<treecol hflex="min" />
					</treecols>
					<treechildren>
						<treeitem open="true" label="something">
							<treechildren>
								<zscript>
									Object o = new Object[30];
								</zscript>
								<treeitem label="nested" forEach="${o}" />
							</treechildren>
						</treeitem>
						<treeitem id="st" open="false" label="something">
							<treechildren>
								<zscript>
			            </zscript>
								<treeitem label="nested" forEach="${o}" />
			
							</treechildren>
						</treeitem>
					</treechildren>
				</tree>
			</window>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val groupTree = ztl$engine.$f("groupTree")
    val st = ztl$engine.$f("st")
    runZTL(zscript, () => {
      verScroll(groupTree, 1)
      waitResponse()
      click(jq(".z-treerow:contains(something):eq(1)").toWidget().$n("open"))
      waitResponse()
      sleep(2000)
      verifyTrue(java.lang.Math.abs(getScrollTop(groupTree)) > 200)
    })
  }
}



