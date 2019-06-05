/* B50_3131173Test.java

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


class B50_3131173Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<window title="tree demo" border="normal" width="100%" height="100%">
	<tree id="tree" width="100%" height="200%" multiple="true"
		checkmark="true">
		
		<attribute name="onSelect"><![CDATA[
		  	Treeitem treeitem = (Treeitem)((SelectEvent)event).getReference();
            if (treeitem.getLastChild() != null && treeitem.getLastChild() instanceof Treechildren)
            {
                Treechildren tchildren = (Treechildren)treeitem.getLastChild();
                
                List list = tchildren.getChildren();//Treeitem list
                for (Treeitem ti : list)
                {
                    ti.setSelected(treeitem.isSelected());
                }
            }
            self.getFellow("cell").setLabel("Item 4: / selected:"+treeitem.isSelected());
	        ]]></attribute>
		
		<treecols>
			<treecol label="Name" />
			<treecol label="Description" />
		</treecols>
		<treechildren>

			<treeitem>
				<treerow>
					<treecell id="cell" label="Item 4" />
					<treecell label="Item 4 description" />
				</treerow>

				<treechildren>
					<treeitem>
						<treerow>
							<treecell label="Item 3" />
							<treecell label="Item 3 description" />
						</treerow>
					</treeitem>
					<treeitem>
						<treerow>
							<treecell label="Item 3a" />
							<treecell label="Item 3a description" />
						</treerow>
					</treeitem>
					<treeitem>
						<treerow>
							<treecell label="Item 3b" />
							<treecell label="Item 3b description" />
						</treerow>
					</treeitem>
				</treechildren>
			</treeitem>
		</treechildren>
	</tree>
</window>

		"""
    val ztl$engine = engine()
    val tree = ztl$engine.$f("tree")
    val cell = ztl$engine.$f("cell")
    runZTL(zscript, () => {
      click(jq(".z-treerow-checkbox:eq(0)"));
      waitResponse()
      click(jq(".z-treerow-checkbox:eq(0)"));
      waitResponse()
      click(jq(".z-treerow-checkbox:eq(0)"));
      waitResponse()
      click(jq(".z-treerow-checkbox:eq(0)"));
      waitResponse()
      click(jq(".z-treerow-checkbox:eq(0)"));
      waitResponse()
      click(jq(".z-treerow-checkbox:eq(0)"));
      waitResponse()
      click(jq(".z-treerow-checkbox:eq(0)"));
      waitResponse()
      verifyContains(jq("@treecell:eq(0)").text(), "Item 4: / selected:true")
      click(jq(".z-treerow-checkbox:eq(0)"));
      waitResponse()
      verifyContains(jq("@treecell:eq(0)").text(), "Item 4: / selected:false")
    })
  }
}



