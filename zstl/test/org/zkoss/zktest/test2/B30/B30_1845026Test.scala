/* B30_1845026Test.java

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


class B30_1845026Test extends ZTL4ScalaTestCase {
  @Test
  def testchangeLabel() = {
    var zscript =
      """
<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
	<n:ol>
		<n:li>click on item 1</n:li>
		<n:li>in the text box enter "a"</n:li>
		<n:li>click on item 2</n:li>
	</n:ol>
	Notice that item 1's label will change to "a".
	<window id="win" title="tree demo" width="400px" border="normal">
		<tree id="tree" width="300px" height="200px" rows="5"
			onSelect="
                 tbox.detach();
                 tbox.setParent(win);">
			<treecols sizable="true">
				<treecol label="Name" />
				<treecol label="Description" />
			</treecols>
			<treechildren>
				<treeitem selected="true">
					<treerow draggable="x" droppable="y">
						<treecell id="item1" label="Item 1" />
					</treerow>
				</treeitem>
				<treeitem>
					<treerow draggable="x" droppable="y">
						<treecell id="item2" label="Item 2" />
					</treerow>
				</treeitem>
			</treechildren>
		</tree>
		Change label:
		<textbox id="txtbox" onChange="changeLabel()" />
		<zscript>
			tbox = win.getFellow("txtbox");
			void changeLabel() {
				tree.selectedItem.children.get(0).children.get(0).setLabel(tbox.value);
			}
		</zscript>
	</window>
</zk>

		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val win = ztl$engine.$f("win")
    val tree = ztl$engine.$f("tree")
    val item1 = ztl$engine.$f("item1")
    val item2 = ztl$engine.$f("item2")
    val txtbox = ztl$engine.$f("txtbox")
    runZTL(zscript, () => {
      var $txtbox = jq("$txtbox")
      var firstRow = jq("@treerow:eq(0)")
      clickAt(firstRow, "1,1"); //get selected
      waitResponse()
      clickAt(firstRow, "1,1"); //get selected
      waitResponse()
      focus($txtbox)
      typeKeys($txtbox, "a")
      waitResponse()
      clickAt(jq("@treerow:eq(1)"), "1,1")
      //when textbox onChange , the first row will be changed
      waitResponse()
      var rowtext = firstRow.text()
      //"item 1 should be change to a but it is:"+ rowtext
      verifyTrue(rowtext != null && rowtext.indexOf("a") != -1)
    })
  }
}



