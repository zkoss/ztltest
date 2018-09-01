/* B50_2991309Test.java

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


class B50_2991309Test extends ZTL4ScalaTestCase {
  @Test
  def testselecttreeitem() = {
    var zscript =
      """
			<zk>
			1. Click the cell in the tree,
			<tree id="tree" width="500px">
				<treechildren>
					<treeitem id="item">
						<treerow>
							<treecell label="cell" />
						</treerow>
					</treeitem>
				</treechildren>
			</tree> 
			<separator/>
			2. Click this
			<button id="btn" label="Invalidate">
				<attribute name="onClick">
					item.invalidate();
					String function =  	"					function compareSelectedItem (treeUuid, itemUuid, msgUuid) {"
										+ "						var tree = zk.Widget.$(treeUuid),"
										+ "							selectedItem = tree.getSelectedItem(),"
										+ "							itemUuid = zk.Widget.$(itemUuid);"
										+ "						if (selectedItem.$oid != itemUuid.$oid) {"
										+ "							zk.Widget.$(msgUuid).setValue(\"Wrong: Treeitem and selected item are not the same\");"
										+ "						}"
										+ "					}";
					Clients.evalJavaScript(function + " compareSelectedItem('" + tree.getUuid() + 
					"', '" + item.getUuid() + 
					"', '" + msg.getUuid() + "');");
				</attribute>
			</button>
			<separator/>
			3. Check if has error message:
			<label id="msg" style="color: red;" ></label>
			
			</zk>
		"""
    val ztl$engine = engine()
    val tree = ztl$engine.$f("tree")
    val item = ztl$engine.$f("item")
    val btn = ztl$engine.$f("btn")
    val msg = ztl$engine.$f("msg")
    runZTL(zscript, () => {
      click(item)
      waitResponse()
      click(btn)
      waitResponse()
      verifyEquals(msg.attr("value"), "")
    })
  }
}



