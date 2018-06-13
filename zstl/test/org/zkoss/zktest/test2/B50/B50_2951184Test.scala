/* B50_2951184Test.java

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


class B50_2951184Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<window>
					<html><![CDATA[
					<ol>
						<li>Click the arrow icon and the tree item shall be opened</li>
						<li>Click "1" and a dialog shall be shown</li>
					</ol>
					]]></html>
				    <tree>
				        <treechildren>
				            <treeitem open="false">
				                <treerow onClick='alert("row clicked")'>
				                    <treecell label="1"/>
				                </treerow>
				                <treechildren>
				                    <treeitem>
				                        <treerow>
				                            <treecell label="a"/>
				                        </treerow>
				                    </treeitem>
				                </treechildren>
				            </treeitem>
				        </treechildren>
				    </tree>
				</window>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      verifyEquals(1, jq(".z-treerow").length())
      click(jq(".z-treerow").toWidget().$n("icon"))
      waitResponse()
      verifyEquals(2, jq(".z-treerow").length())
      click(jq(".z-treecell"))
      waitResponse()
      verifyTrue(isVisible(jq(".z-window-highlighted")))
    })
  }
}



