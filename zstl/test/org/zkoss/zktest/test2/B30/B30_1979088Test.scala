/* B30_1979088Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget
import org.zkoss.ztl.util.ColorVerifingHelper


class B30_1979088Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<window>
	Click the "test" button, then the background of the both paging are changed to red.
<zscript>
List items = new org.zkoss.zktest.test2.BigList(100); //a big list of
Integer
</zscript>
<button label="test" onClick='list.pagingChild.setStyle("background:red;");'/>
<listbox mold="paging" id="list" pagingPosition="both">
<listitem forEach="&#36;{items}">
<listcell label="&#36;{each}-1"/>
<listcell label="&#36;{each}-2"/>
<listcell label="&#36;{each}-3"/>
<listcell label="&#36;{each}-4"/>
</listitem>
</listbox>
</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val list = ztl$engine.$f("list")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      var color = ColorVerifingHelper.isEqualColor("red", jq(".z-paging:eq(0)").css("backgroundColor"))
      verifyTrue(color)
      var color1 = org.zkoss.ztl.util.ColorVerifingHelper.isEqualColor("red", jq(".z-paging:eq(1)").css("backgroundColor"))
      verifyTrue(color1)
    })
  }
}



