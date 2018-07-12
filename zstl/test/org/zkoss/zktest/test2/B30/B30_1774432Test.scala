/* B30_1774432Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1774432Test extends ZTL4ScalaTestCase {
  @Test
  def testTree() = {
    var zscript =
      """
		<window>
		<html><![CDATA[
		To reproduce the bug:
		<ol>
		<li>Select "Item 2"</li>
		<li>Click remove</li>
		<li>Click append</li>
		<li>"Item 3" is appended</li>
		<li>Click append</li>
		<li>"Item 4" is appended</li>
		<li>Click append</li>
		</ol>
		Error Message:
		"Failed to invoke zkTree.setAttr
		el has no properties". And, it shall not appear.
		]]></html>
		<tree id="t" mold="paging" pageSize="3">
			<treechildren id="tc">
						<treeitem>
										<treerow >
											<treecell label="Item 1"/>
										</treerow>
						</treeitem>
						<treeitem>
										<treerow >
											<treecell id="item2" label="Item 2"/>
										</treerow>
						</treeitem>
			</treechildren>
		</tree>
		<zscript>
			int count =2;
			public void append() {
				count++;
				Treeitem ti = new Treeitem("Item "+count);
				Treechildren tc = t.getTreechildren();
				ti.setParent(tc);
			}
			public void remove() {
				Treeitem ti = t.getSelectedItem();
				if (ti != null) ti.detach();
				else alert("You have to select an item first");
			}
			public void removeLast() {
				List kids = t.getTreechildren().getChildren();
				if (!kids.isEmpty())
					kids.get(kids.size() - 1).detach();
			}
		</zscript>
		<button id="append" label="append" onClick="append()"/>
		<button id="remove" label="remove" onClick="remove()"/>
		<button id="removelast" label="remove last" onClick="removeLast()"/>
		<button id="redraw" label="redraw" onClick="t.invalidate()"/>
		</window>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val t = ztl$engine.$f("t")
    val tc = ztl$engine.$f("tc")
    val item2 = ztl$engine.$f("item2")
    val append = ztl$engine.$f("append")
    val remove = ztl$engine.$f("remove")
    val removelast = ztl$engine.$f("removelast")
    val redraw = ztl$engine.$f("redraw")
    runZTL(zscript, () => {
      click(item2)
      waitResponse()
      click(remove)
      waitResponse()
      verifyFalse(item2.exists())
      verifyFalse(jq(".z-error").exists())
      click(append)
      waitResponse()
      verifyEquals(2, tc.nChildren())
      verifyEquals(2, t.$n("rows").attr("rows.length").toInt)
      verifyFalse(jq(".z-error").exists())
      click(append)
      waitResponse()
      verifyEquals(3, tc.nChildren())
      verifyEquals(3, t.$n("rows").attr("rows.length").toInt)
      verifyFalse(jq(".z-error").exists())
      click(append)
      waitResponse()
      verifyFalse(jq(".z-error").exists())
      verifyTrue(isVisible(t.getChild("paging")))
      click(removelast)
      waitResponse()
      click(removelast)
      waitResponse()
      verifyEquals(2, tc.nChildren())
      verifyEquals(2, t.$n("rows").attr("rows.length").toInt)
      verifyFalse(jq(".z-error").exists())
      verifyFalse(isVisible(t.getChild("paging")))
      click(redraw)
      waitResponse()
      verifyEquals(2, t.$n("rows").attr("rows.length").toInt)
      verifyFalse(jq(".z-error").exists())
      verifyFalse(isVisible(t.getChild("paging")))
    })
  }
}



