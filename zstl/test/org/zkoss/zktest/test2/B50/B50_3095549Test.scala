/* B50_3095549Test.java

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
import org.zkoss.ztl.unit.Widget


class B50_3095549Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	If we open the tree node 'Item 1' and click button to add 'Item
	1-3', the order is correct.
	<separator />
	Reload again, If we don't open the tree node and click button to add
	'Item 1-3', open the tree node 'Item 1', the order should be correct
	as the same as previous.
	<separator />
	<button label="Add Item 1-3">
		<attribute name="onClick">
	Treeitem item = new Treeitem();
	item.setParent(treechildren1);
	Treerow row = new Treerow();
	row.setParent(item);
	row.appendChild(new Treecell("Item 1-3"));
</attribute>
	</button>
	<separator height="50px" />
	<tree width="500px">
		<treecols>
			<treecol label="treecol 1" />
		</treecols>
		<treechildren>
			<treeitem open="false">
				<treerow>
					<treecell label="Item 1" />
				</treerow>
				<treechildren id="treechildren1">
					<treeitem open="false">
						<treerow>
							<treecell label="Item 1-1" />
						</treerow>
					</treeitem>
					<treeitem open="false">
						<treerow>
							<treecell label="Item 1-2" />
						</treerow>
					</treeitem>
				</treechildren>
			</treeitem>
		</treechildren>
	</tree>
</zk>

		"""
    val ztl$engine = engine()
    val treechildren1 = ztl$engine.$f("treechildren1")
    runZTL(zscript, () => {
      click(jq(".z-treerow").toWidget().$n("icon"))
      waitResponse()
      verifyEquals(3, jq("@treerow").length())
      click(jq("@button"))
      waitResponse()
      verifyEquals(4, jq("@treerow").length())
      verifyContains(jq("@treerow:eq(3)").text(), "Item 1-3")
    })
  }

  @Test
  def testztl1() = {
    var zscript =
      """
			


<zk>
	If we open the tree node 'Item 1' and click button to add 'Item
	1-3', the order is correct.
	<separator />
	Reload again, If we don't open the tree node and click button to add
	'Item 1-3', open the tree node 'Item 1', the order should be correct
	as the same as previous.
	<separator />
	<button label="Add Item 1-3">
		<attribute name="onClick">
	Treeitem item = new Treeitem();
	item.setParent(treechildren1);
	Treerow row = new Treerow();
	row.setParent(item);
	row.appendChild(new Treecell("Item 1-3"));
</attribute>
	</button>
	<separator height="50px" />
	<tree width="500px">
		<treecols>
			<treecol label="treecol 1" />
		</treecols>
		<treechildren>
			<treeitem open="false">
				<treerow>
					<treecell label="Item 1" />
				</treerow>
				<treechildren id="treechildren1">
					<treeitem open="false">
						<treerow>
							<treecell label="Item 1-1" />
						</treerow>
					</treeitem>
					<treeitem open="false">
						<treerow>
							<treecell label="Item 1-2" />
						</treerow>
					</treeitem>
				</treechildren>
			</treeitem>
		</treechildren>
	</tree>
</zk>

		"""
    val ztl$engine = engine()
    val treechildren1 = ztl$engine.$f("treechildren1")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      click(jq(".z-treerow").toWidget().$n("icon"))
      waitResponse()
      verifyEquals(4, jq("@treerow").length())
      verifyContains(jq("@treerow:eq(3)").text(), "Item 1-3")
    })
  }
}



