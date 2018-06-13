/* B50_3167027Test.java

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


class B50_3167027Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	<html><![CDATA[
		<ol>
			<li>Click "add node" button.</li>
			<li>A "new item" shall appear.</li>
		</ol>
	]]></html>
	<button label="add node">
		<attribute name="onClick"><![CDATA[
			Treerow tr = new Treerow();
			item.appendChild(tr);
			tr.appendChild(new Treecell("new Item"));
		]]></attribute>
	</button>
	<tree>
		<treechildren>
			<treeitem id="item"/>
		</treechildren>
	</tree>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val item = ztl$engine.$f("item")
    runZTL(zscript, () => {
      verifyFalse(jq("@treecell:eq(0)").exists())
      click(jq("@button"))
      waitResponse()
      verifyTrue(isVisible(jq("@treecell:eq(0)")))
      verifyTrue(jq("@treecell:eq(0)").text().contains("new Item"))
    })
  }
}



