/* B50_2956421Test.java

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


class B50_2956421Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<zk>
					<html><![CDATA[
					<ol>
					<li>Click a1 and the first item shall be selected</li>
					<li>Click b1 and the second item shall be selected</li>
					</ol>
					]]></html>
				
					<listbox width="200px">
						<listhead>
							<listheader label="col1" />
							<listheader label="col2" />
						</listhead>
						<listitem id="item1">
							<listcell id="a1" label="a1"/>
							<listcell label="a2"/>
						</listitem>
						<listitem  id="item2">
							<listcell id="b1" label="b1" onClick=""/>
							<listcell label="b2" />
						</listitem>
					</listbox>
				</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val item1 = ztl$engine.$f("item1")
    val a1 = ztl$engine.$f("a1")
    val item2 = ztl$engine.$f("item2")
    val b1 = ztl$engine.$f("b1")
    runZTL(zscript, () => {
      click(a1)
      waitResponse()
      verifyTrue(item1.is("selected"))
      verifyTrue(jq(item1).hasClass("z-listitem-selected"))
      click(b1)
      waitResponse()
      verifyTrue(item2.is("selected"))
      verifyFalse(jq(item1).hasClass("z-listitem-selected"))
      verifyTrue(jq(item2).hasClass("z-listitem-selected"))
    })
  }
}



