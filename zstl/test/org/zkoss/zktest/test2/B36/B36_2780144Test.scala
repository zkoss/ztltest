/* B36_2780144Test.java

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


class B36_2780144Test extends ZTL4ScalaTestCase {
  @Test
  def testUI() = {
    var zscript =
      """
			<zk>
				You should see the both tree are the same display.
				<tree zclass="z-dottree">
					<treechildren>
						<treeitem>
							<treerow>
								<treecell label="a" />
							</treerow>
							<treechildren>
								<treeitem>
									<treerow>
										<treecell label="b" />
									</treerow>
									<treechildren>
										<treeitem>
											<treerow>
												<treecell label="c" id="treecell1"/>
											</treerow>
										</treeitem>
										<treeitem visible="false">
												<treerow>
													<treecell label="d" />
												</treerow>
										</treeitem>
									</treechildren>
								</treeitem>
								<treeitem   visible="false" >
									<treerow>
										<treecell label="e"/>
									</treerow>
								</treeitem>
							</treechildren>
						</treeitem>
					</treechildren>
				</tree>
				<tree zclass="z-dottree" id="tree2">
					<treechildren>
						<treeitem>
							<treerow>
								<treecell label="a" />
							</treerow>
							<treechildren>
								<treeitem>
									<treerow>
										<treecell label="b" />
									</treerow>
									<treechildren>
										<treeitem>
											<treerow>
												<treecell label="c" id="treecell2"/>
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
    val treecell1 = ztl$engine.$f("treecell1")
    val tree2 = ztl$engine.$f("tree2")
    val treecell2 = ztl$engine.$f("treecell2")
    runZTL(zscript, () => {
      verifyEquals(jq(treecell1).find("span:eq(1)").attr("class"), jq(treecell2).find("span:eq(1)").attr("class"))
    })
  }
}



