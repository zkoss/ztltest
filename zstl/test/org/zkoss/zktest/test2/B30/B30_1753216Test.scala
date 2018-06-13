/* B30_1753216Test.java

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
import org.zkoss.ztl.unit.Widget


class B30_1753216Test extends ZTL4ScalaTestCase {
  @Test
  def testTree() = {
    var zscript =
      """
		<zk>
		If no error occur, it is right.
		<tree mold="paging" pageSize="3">
			<treechildren>
				<treeitem id="ti0" selected="true" onOpen="onOpen(event, 4)" open="false">
					<treerow>
						<treecell label="Add onOpen"/>
					</treerow>
					<treechildren id="tch">
					</treechildren>
				</treeitem>
			</treechildren>
		</tree>
		<zscript><![CDATA[
		void onOpen(Event evt, int cnt) {
			if (evt.open) {
				for (int j = 1; j <= cnt; ++j) {
					Treeitem ti = new Treeitem();
					Treerow tr = new Treerow();
					new Treecell("new " + j).setParent(tr);
					tr.setParent(ti);
					ti.setParent(tch);
				}
		
			}
		}
		]]></zscript>
		</zk>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val ti0 = ztl$engine.$f("ti0")
    val tch = ztl$engine.$f("tch")
    runZTL(zscript, () => {
      verifyFalse(jq("@window").exists())
      verifyFalse(jq(".z-error").exists())
      click(ti0.$n("open"))
      verifyFalse(jq("@window").exists())
      verifyFalse(jq(".z-error").exists())
    })
  }
}



