/* B30_1826517Test.java

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
import org.zkoss.ztl.Widget


class B30_1826517Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
       
       <div>This case we need to make sure the column width is same after set visiable false.</div>
       <div> 1. click the button , and check the width . </div>
	<listbox width="400px">
		<listhead id="hd" sizable="true" visible="false">
			<listheader width="50px" label="name" sort="auto"/>
			<listheader label="Column2" sort="auto"/>
		</listhead>
		<listitem>
			<listcell label="Mary"/>
			<listcell label="FEMALE"/>
		</listitem>
		<listitem>
			<listcell label="John"/>
			<listcell label="MALE"/>
		</listitem>
	</listbox>
	<button label="visible" onClick='hd.visible = !hd.visible'/>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val hd = ztl$engine.$f("hd")
    runZTL(zscript, () => {
      verifyFalse(jq("@listhead").isVisible())
      var width1 = jq("@listcell").eq(0).outerWidth()
      var width2 = jq("@listcell").eq(1).outerWidth()
      click(jq("@button"))
      waitResponse()
      verifyTrue(jq("@listhead").isVisible())
      verifyEquals(width1, jq("@listcell").eq(0).outerWidth())
      verifyEquals(width1, jq("@listheader").eq(0).outerWidth())
      verifyEquals(width2, jq("@listcell").eq(1).outerWidth())
      verifyEquals(width2, jq("@listheader").eq(1).outerWidth())
      click(jq("@button"))
      waitResponse()
      verifyFalse(jq("@listhead").isVisible())
      verifyEquals(width1, jq("@listcell").eq(0).outerWidth())
      verifyEquals(width2, jq("@listcell").eq(1).outerWidth())
    })
  }
}



