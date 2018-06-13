/* B50_3283951Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3283951Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	<html><![CDATA[
		<ol>
			<li>Click "set select" button, the item shall be selected.</li>
			<li>Click "select item" button, the select item shall not be null.</li>
		</ol>
	]]></html>
	<button label="set select" onClick="titem.selected=true;"/>
	<button label="select item" onClick="alert(tree.selectedItem);"/>
	<tree id="tree" width="100px" multiple="true">
		<treechildren>
			<treeitem label="item" id="titem"/>
		</treechildren>
	</tree>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tree = ztl$engine.$f("tree")
    val titem = ztl$engine.$f("titem")
    runZTL(zscript, () => {
      click(jq("@button:eq(0)"))
      waitResponse()
      verifyTrue(titem.is("selected"))
      click(jq("@button:eq(1)"))
      waitResponse()
      verifyTrue(getAlertMessage().matches("<Treeitem .*titem>"))
    })
  }
}



