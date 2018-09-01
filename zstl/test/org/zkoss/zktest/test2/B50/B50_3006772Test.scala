/* B50_3006772Test.java

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


class B50_3006772Test extends ZTL4ScalaTestCase {
  @Test
  def testfocusArrow() = {
    var zscript =
      """
			<zk>
				<tree id="tree" multiple="true">
					<treechildren>
						<treeitem>
							<treerow>
								<treecell label="1" />
							</treerow>
							<treechildren>
								<treeitem>
									<treerow>
										<treecell label="1.1" />
									</treerow>
									<treechildren>
										<treeitem id="ti1">
											<treerow id="tr1">
												<treecell label="1.1.1" id="tc1"/>
											</treerow>
										</treeitem>
										<treeitem id="ti2">
											<treerow id="tr2">
												<treecell label="1.1.2" id="tc2"/>
											</treerow>
										</treeitem>
										<treeitem>
											<treerow>
												<treecell label="1.1.3" />
											</treerow>
										</treeitem>
									</treechildren>
								</treeitem>
							</treechildren>
						</treeitem>
					</treechildren>
				</tree>
			</zk>
		"""
    val ztl$engine = engine()
    val tree = ztl$engine.$f("tree")
    val ti1 = ztl$engine.$f("ti1")
    val tr1 = ztl$engine.$f("tr1")
    val tc1 = ztl$engine.$f("tc1")
    val ti2 = ztl$engine.$f("ti2")
    val tr2 = ztl$engine.$f("tr2")
    val tc2 = ztl$engine.$f("tc2")
    runZTL(zscript, () => {
      click(jq("@treecell:contains(1.1.1)"))
      waitResponse(true)
      click(jq("@treerow").toWidget().$n("icon"))
      waitResponse(true)
      click(jq("@treerow").toWidget().$n("icon"))
      waitResponse(true)
      click(jq("@treecell:contains(1.1.2)"))
      waitResponse(true)
      verifyEquals(1, jq("tr.z-treerow-selected").length())
    })
  }
}



