/* B50_2887722Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_2887722Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<zk>
Please check the dot in the tree displays correctly. (Item 2.2 should not connect to Item 3)
<tree id="tree" width="400px" rows="8" zclass="z-dottree">
	<treecols sizable="true">
		<treecol label="Name" />
		<treecol label="Description" />
	</treecols>
	<treechildren>
		<treeitem>
			<treerow>
				<treecell label="Item 1" />
				<treecell label="Item 1 description" />
			</treerow>
		</treeitem>
		<treeitem>
			<treerow>
				<treecell label="Item 2" />
				<treecell label="Item 2 description" />
			</treerow>
			<treechildren>
				<treeitem>
					<treerow>
						<treecell label="Item 2.1" />
					</treerow>
					<treechildren>
						<treeitem>
							<treerow>
								<treecell label="Item 2.1.1" />
							</treerow>
						</treeitem>
						<treeitem>
							<treerow>
								<treecell label="Item 2.1.2" />
							</treerow>
						</treeitem>
					</treechildren>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 2.2" />
					</treerow>
					<treechildren>
						<treeitem>
							<treerow>
								<treecell label="Item 2.2.1" />
							</treerow>
						</treeitem>
					</treechildren>
				</treeitem>
			</treechildren>
		</treeitem>
		<treeitem label="Item 3" />
	</treechildren>
</tree>
</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tree = ztl$engine.$f("tree")
    runZTL(zscript, () => {
      verifyEquals(1, jq("@treecell[label=\"Item 3\"]").children().length());
    })
  }
}



