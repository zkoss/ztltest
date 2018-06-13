/* B50_3031562Test.java

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


class B50_3031562Test extends ZTL4ScalaTestCase {
  @Test
  def testhbox() = {
    var zscript =
      """
		<zk>
			<label
				value="The AA and BB should be in the same line, if iin different line, it's wrong" />
			<hbox id="hbox">
				<div>AA</div>
				<div>BB</div>
			</hbox>

			<label id="msg" style="color:red;">
				<attribute name="onCreate">
				if ("default".equals(hbox.getOrient()))
					self.setValue("The hbox's mold should be horizontal, not "
							+ hbox.getOrient());
				</attribute>
			</label>
		</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val hbox = ztl$engine.$f("hbox")
    val msg = ztl$engine.$f("msg")
    runZTL(zscript, () => {
      verifyEquals(msg.get("value"), "")
    })
  }
}



