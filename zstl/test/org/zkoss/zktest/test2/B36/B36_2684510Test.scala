/* B36_2684510Test.java

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
import org.zkoss.ztl.unit.Widget


class B36_2684510Test extends ZTL4ScalaTestCase {
  @Test
  def testevent() = {
    var zscript =
      """
			<zk>
				After clicking the test button, you shall see "&lt;Button b>:onClick:void" below
				<separator/>
				<label id="i"/>
				<zscript><![CDATA[
				public void test(){i.value = "<" + self.getClass().getSimpleName() + " " + self.id+">:"+event.getName()+":"+b;}
				]]></zscript>
				<window>
				<button id="b" label="test" onClick="test()"/>
				</window>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val i = ztl$engine.$f("i")
    val b = ztl$engine.$f("b")
    runZTL(zscript, () => {
      click(b)
      waitResponse()
      verifyEquals("<Button b>:onClick:void", i.get("value"))
    })
  }
}



