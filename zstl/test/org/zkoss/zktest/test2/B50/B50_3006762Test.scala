/* B50_3006762Test.java

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


class B50_3006762Test extends ZTL4ScalaTestCase {
  @Test
  def testscrollHeight() = {
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
										<treeitem>
											<treerow>
												<treecell label="1.1.1" />
											</treerow>
										</treeitem>
										<treeitem>
											<treerow>
												<treecell label="1.1.2" />
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
    runZTL(zscript, () => {
      click(jq("@treecell[label=\"1.1.1\"]"))
      click(jq("@treerow").toWidget().$n("icon"))
      waitResponse()
      var node = tree.$n().firstChild()
      verifyTolerant(parseInt(node.attr("clientHeight")), parseInt(node.attr("scrollHeight")), 1)
    })
  }
}



