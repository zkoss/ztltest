/* B50_3085855Test.java

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


class B50_3085855Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			

<zk>
	<html><![CDATA[
		<ol>
			<li>If you see Item 2 in the tree, it is a bug.</li>
		</ol>
	]]></html>
	<tree width="400px">
		<treechildren>
			<treeitem>
				<treerow>
					<treecell label="Item 1" />
				</treerow>
			</treeitem>
			<treeitem visible="false">
				<treerow>
					<treecell />
				</treerow>
				<treechildren>
					<treeitem>
						<treerow>
							<treecell style="color: red" label="Item 2 (Bug!)" />
						</treerow>
					</treeitem>
				</treechildren>
			</treeitem>
		</treechildren>
	</tree>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      verifyFalse(jq(".z-treerow:contains(Item 2)").exists())
      verifyTrue(jq(".z-treerow:visible").text().contains("Item 1"))
    })
  }
}



