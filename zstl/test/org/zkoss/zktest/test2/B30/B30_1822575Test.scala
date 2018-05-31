/* B30_1822575Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B30_1822575Test extends ZTL4ScalaTestCase {
  @Test
  def testTreeSize() = {
    var zscript =
      """
<zk>
Change window's height, component won't resize
	<button id="btn1" label="Set window to 30%">
		<attribute name="onClick">win.setHeight("30%");</attribute>
	</button>
	<button id="btn2" label="invalidate Tree" onClick='win.getFellow("tree2").invalidate()'/>
	<window title = "Win" id="win" height="100%" width="90%" border="normal">
		<tree id="tree2" vflex="true">
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
				</treeitem>
				<treeitem label="Item 3" />
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
				</treeitem>
			</treechildren>
		</tree>
	</window>
</zk>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val btn1 = ztl$engine.$f("btn1")
    val btn2 = ztl$engine.$f("btn2")
    val win = ztl$engine.$f("win")
    val tree2 = ztl$engine.$f("tree2")
    runZTL(zscript, () => {
      var winHgh = jq(win.$n("cave")).height()
      var treeHgh = jq(tree2).outerHeight()
      verifyEquals(treeHgh, winHgh)
      click(btn1)
      waitResponse()
      var winHgh2 = jq(win.$n("cave")).height()
      var treeHgh2 = jq(tree2).outerHeight()
      verifyEquals(treeHgh2, winHgh2)
      verifyTrue(winHgh * 0.3 >= winHgh2)
      verifyTrue(treeHgh * 0.3 >= treeHgh2)
      click(btn2)
      waitResponse()
      winHgh2 = jq(win.$n("cave")).height()
      treeHgh2 = jq(tree2).outerHeight()
      verifyEquals(treeHgh2, winHgh2)
      verifyTrue(winHgh * 0.3 >= winHgh2)
      verifyTrue(treeHgh * 0.3 >= treeHgh2)
    })
  }
}



