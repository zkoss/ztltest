/* B36_2814504Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B36_2814504Test extends ZTL4ScalaTestCase {
  @Test
  def testsetLabel() = {
    var zscript =
      """
			<window>
			First, click
			<button label="change label" onClick='i2.label = "test1"'/>
			and you will see the first treeitem's label changed to test1.
			Then, click
			<button label="change label" onClick='i1.label = "test2"'/>
			and you shall see nothing changed. Then, click the previous page
			and you will see the first treeitem is test2.
			
			<tree id="tree" width="400px" mold="paging" pageSize="2"
			onCreate="self.activePage= 1">
			<treecols sizable="true">
			<treecol label="Name" />
			<treecol label="Description" />
			</treecols>
			<treechildren>
			<treeitem>
			<treerow>
			<treecell id="i1" label="Item 1" />
			<treecell label="Item 1 description" />
			</treerow>
			</treeitem>
			<treeitem>
			<treerow>
			<treecell label="Item 2" />
			<treecell label="Item 2 description" />
			</treerow>
			<treechildren>
			<treeitem>
			<treerow>
			<treecell id="i2" label="Item 2.1" />
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
			</treechildren>
			</treeitem>
			<treeitem label="Item 3" />
			</treechildren>
			</tree>
			<button label="invalidate" onClick='tree.invalidate()'/>
			</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tree = ztl$engine.$f("tree")
    val i1 = ztl$engine.$f("i1")
    val i2 = ztl$engine.$f("i2")
    runZTL(zscript, () => {
      click(jq("@window @button[label=\"change label\"]:eq(0)"))
      waitResponse()
      verifyTrue(jq(jq("$i2").toWidget().$n("cave")).text().contains("test1"))
      click(jq("@window @button[label=\"change label\"]:eq(1)"))
      waitResponse()
      click(jq("[name=" + jq("@paging").attr("id") + "-prev]"))
      waitResponse()
      verifyTrue(jq(jq("$i1").toWidget().$n("cave")).text().contains("test2"))
    })
  }
}



