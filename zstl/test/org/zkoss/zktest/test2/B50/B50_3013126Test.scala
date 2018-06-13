/* B50_3013126Test.java

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


class B50_3013126Test extends ZTL4ScalaTestCase {
  @Test
  def testDisable() = {
    var zscript =
      """
		<zk>
1. Please select "Item 2.1"
<separator/>
2. Click the "disabled" button
<separator/>
3. The "Item 2" should not disappear.

<tree id="tree" width="400px" rows="8">
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
			<treerow>
				<treecell label="Item 2" />
				<treecell label="Item 2 description" />
			</treerow>
		</treeitem>
		<treeitem label="Item 3" />
	</treechildren>
</tree>
<zscript>
boolean b = true;
</zscript>
<button label="disabled">
	<attribute name="onClick"><![CDATA[
	                                   
Treeitem selectItem = tree.getSelectedItem();
Collection c=tree.getItems();
Iterator ir=c.iterator();
while(ir.hasNext()){
	Treeitem ti=(Treeitem)ir.next();

	if(selectItem!=null&&!selectItem.equals(ti)) {
		ti.setDisabled(b);
	}
}
b = !b;
	]]></attribute>
</button>
</zk>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tree = ztl$engine.$f("tree")
    runZTL(zscript, () => {
      click(jq("@treecell[label=\"Item 2.1\"]"))
      click(jq("@button"))
      verifyTrue(jq("@treecell[label=\"Item 2\"]").exists())
      click(jq("@button"))
      verifyTrue(jq("@treecell[label=\"Item 2\"]").exists())
    })
  }
}



