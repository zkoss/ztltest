/* B50_2936132Test.java

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


class B50_2936132Test extends ZTL4ScalaTestCase {
  @Test
  def testtree() = {
    var zscript =
      """
				<zk>
					If we open the tree node 'Item 1' and click button to add 'Item 1-3', the
					order is correct.
					<separator/>
					Reload again, If we don't open the tree node and click button to add 'Item
					1-3', open the tree node 'Item 1', the order should be correct as the same as previous.
					<separator/>
					<button id="btn" label="Add Item 1-3">
						<attribute name="onClick">
							Treeitem item = new Treeitem();
							item.setParent(treechildren1);
							Treerow row = new Treerow();
							row.setParent(item);
							row.appendChild(new Treecell("Item 1-3"));
						</attribute>
					</button>
					<separator height="50px"/>
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
						<treecell label="Item 1-1"/>
						</treerow>
						</treeitem>
						<treeitem open="false">
						<treerow><treecell label="Item 1-2"/></treerow>
						</treeitem>
						</treechildren>
						</treeitem>
						<treeitem id="treeitem2" open="false">
						<treerow id="treerow2">
						<treecell label="Item 2" />
						</treerow>
						<treechildren>
						<treeitem>
						<treerow>
						<treecell label="Item 2-1"/>
						</treerow>
						</treeitem>
						</treechildren>
						</treeitem>
						<treeitem open="false">
						<treerow>
						<treecell label="Item 3" />
						</treerow>
						</treeitem>
						</treechildren>
					</tree>
				</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val btn = ztl$engine.$f("btn")
    val treechildren1 = ztl$engine.$f("treechildren1")
    val treeitem2 = ztl$engine.$f("treeitem2")
    val treerow2 = ztl$engine.$f("treerow2")
    runZTL(zscript, () => {
      click(btn)
      waitResponse()
      click(jq(".z-treerow:eq(0)").toWidget().$n("icon"))
      waitResponse()
      verifyEquals(6, jq("tr.z-treerow").length())
      verifyContains(jq(jq(".z-treecell:eq(1)").toWidget().$n("cave")).text(), "Item 1-1")
      verifyContains(jq(jq(".z-treecell:eq(2)").toWidget().$n("cave")).text(), "Item 1-2")
      verifyContains(jq(jq(".z-treecell:eq(3)").toWidget().$n("cave")).text(), "Item 1-3")
    })
  }

  @Test
  def testtree1() = {
    var zscript =
      """
				<zk>
					If we open the tree node 'Item 1' and click button to add 'Item 1-3', the
					order is correct.
					<separator/>
					Reload again, If we don't open the tree node and click button to add 'Item
					1-3', open the tree node 'Item 1', the order should be correct as the same as previous.
					<separator/>
					<button id="btn" label="Add Item 1-3">
						<attribute name="onClick">
							Treeitem item = new Treeitem();
							item.setParent(treechildren1);
							Treerow row = new Treerow();
							row.setParent(item);
							row.appendChild(new Treecell("Item 1-3"));
						</attribute>
					</button>
					<separator height="50px"/>
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
						<treecell label="Item 1-1"/>
						</treerow>
						</treeitem>
						<treeitem open="false">
						<treerow><treecell label="Item 1-2"/></treerow>
						</treeitem>
						</treechildren>
						</treeitem>
						<treeitem id="treeitem2" open="false">
						<treerow id="treerow2">
						<treecell label="Item 2" />
						</treerow>
						<treechildren>
						<treeitem>
						<treerow>
						<treecell label="Item 2-1"/>
						</treerow>
						</treeitem>
						</treechildren>
						</treeitem>
						<treeitem open="false">
						<treerow>
						<treecell label="Item 3" />
						</treerow>
						</treeitem>
						</treechildren>
					</tree>
				</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val btn = ztl$engine.$f("btn")
    val treechildren1 = ztl$engine.$f("treechildren1")
    val treeitem2 = ztl$engine.$f("treeitem2")
    val treerow2 = ztl$engine.$f("treerow2")
    runZTL(zscript, () => {
      click(btn)
      waitResponse()
      click(jq(".z-treerow:eq(0)").toWidget().$n("icon"))
      waitResponse()
      verifyEquals(6, jq("tr.z-treerow").length())
      verifyContains(jq(jq(".z-treecell:eq(1)").toWidget().$n("cave")).text(), "Item 1-1")
      verifyContains(jq(jq(".z-treecell:eq(2)").toWidget().$n("cave")).text(), "Item 1-2")
      verifyContains(jq(jq(".z-treecell:eq(3)").toWidget().$n("cave")).text(), "Item 1-3")
    })
  }
}



