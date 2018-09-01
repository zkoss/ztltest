/* B50_2994060Test.java

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


class B50_2994060Test extends ZTL4ScalaTestCase {
  @Test
  def testsetdisable() = {
    var zscript =
      """
			<zk>
			1. Mouse Click "Item 1" 
			<tree id="tree" width="400px" rows="8">
				<treecols sizable="true">
					<treecol label="Name" />
					<treecol label="Description" />
				</treecols>
				<treechildren>
					<treeitem id="item1">
						<treerow>
							<treecell id="cell" label="Item 1" >
								<attribute name="onClick">
									item2.setDisabled(true);
									item3.setDisabled(true);
									item4.setDisabled(true);
									item5.setDisabled(true);
									item6.setDisabled(true);
									item7.setDisabled(true);
									item8.setDisabled(true);
									String fun = 	"				function checkIfHasDuplicateTreeitem (rowsUuid, rowUuid, msgUuid) {"
													+ "					var itemLength =  jq(rowsUuid).children(rowUuid).length;"
													+ "					if (itemLength > 1)"
													+ "						zk.Widget.$(msgUuid).setValue('Wrong: treeitem has duplicate treeitem');	"
													+ "				}";
									String str = " checkIfHasDuplicateTreeitem('#" + tree.getUuid() + "-rows', '#" +
														row.getUuid() + "', '" + 	msg.getUuid() + "')";			
									Clients.evalJavaScript(fun + str);
								</attribute>
							</treecell>
							<treecell label="Item 1 description" />
						</treerow>
					</treeitem>
					<treeitem id="item2">
						<treerow>
							<treecell label="Item 2" />
							<treecell label="Item 2 description" />
						</treerow>
						<treechildren>
							<treeitem id="item3">
								<treerow id="row" >
									<treecell label="Item 2.1" />
								</treerow>
								<treechildren>
									<treeitem id="item4">
										<treerow>
											<treecell label="Item 2.1.1" />
										</treerow>
									</treeitem>
									<treeitem id="item5">
										<treerow>
											<treecell label="Item 2.1.2" />
										</treerow>
									</treeitem>
								</treechildren>
							</treeitem>
							<treeitem id="item6">
								<treerow>
									<treecell label="Item 2.2" />
								</treerow>
								<treechildren>
									<treeitem id="item7">
										<treerow>
											<treecell label="Item 2.2.1" />
										</treerow>
									</treeitem>
								</treechildren>
							</treeitem>
						</treechildren>
					</treeitem>
					<treeitem id="item8" label="Item 3" />
				</treechildren>
			</tree>
			
			<separator/>
			2. If the tree has duplicate treeitem (example: has 2 "Item 2.1"), that's wrong, check if has error message : 
			<label id="msg" style="color:red;"/>
			
			</zk>
		"""
    val ztl$engine = engine()
    val tree = ztl$engine.$f("tree")
    val item1 = ztl$engine.$f("item1")
    val cell = ztl$engine.$f("cell")
    val item2 = ztl$engine.$f("item2")
    val item3 = ztl$engine.$f("item3")
    val row = ztl$engine.$f("row")
    val item4 = ztl$engine.$f("item4")
    val item5 = ztl$engine.$f("item5")
    val item6 = ztl$engine.$f("item6")
    val item7 = ztl$engine.$f("item7")
    val item8 = ztl$engine.$f("item8")
    val msg = ztl$engine.$f("msg")
    runZTL(zscript, () => {
      click(cell)
      waitResponse()
      verifyEquals(msg.attr("value"), "")
    })
  }
}



