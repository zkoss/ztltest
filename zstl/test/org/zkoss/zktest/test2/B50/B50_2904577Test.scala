/* B50_2904577Test.java

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


class B50_2904577Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
			<zk>
			<zscript><![CDATA[
			void addTreeItem(Treerow tr) {
			Treeitem item = (Treeitem) tr.getParent();
			if (item.getTreechildren()==null) {
			Treechildren tc = new Treechildren();
			for (int i = 0; i < 5; i++) {
			tc.appendChild(getTreeItem(i));
			}
			item.appendChild(tc);
			}
			}
			
			public getTreeItem(int i) {
			Treeitem ti = new Treeitem();
			Treerow tr = new Treerow();
			tr.appendChild(new Treecell("Item " + i));
			tr.addEventListener(Events.ON_CLICK, new EventListener() {
			public void onEvent(Event arg0) throws Exception {
			Treerow row = (Treerow) arg0.getTarget();
			addTreeItem(row);
			}
			});
			ti.appendChild(tr);
			ti.setOpen(true);
			return ti;
			}
			
			]]></zscript>
			
			<tree id="tree" width="400px" rows="8">
				<treecols sizable="true">
					<treecol label="Name" />
				</treecols>
				<treechildren>
					<treeitem>
						<treerow>
							<attribute name="onClick">
									addTreeItem(self);
							</attribute>
							<treecell label="Please Click Me, you should see 5 items added below." />
						</treerow>
					</treeitem>
				</treechildren>
			</tree>
			</zk>
			"""
    val ztl$engine = engine()
    val tree = ztl$engine.$f("tree")
    runZTL(zscript, () => {
      var before = jq(".z-treerow").length()
      clickAt(jq(".z-treecell"), "5,5")
      waitResponse()
      var after = jq(".z-treerow").length()
      verifyEquals(5, after - before)
    })
  }
}



