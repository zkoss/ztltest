/* B30_1486556Test.java

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


class B30_1486556Test extends ZTL4ScalaTestCase {
  @Test
  def testConstraint1() = {
    var zscript =
      """
			<zk>
				<textbox constraint="/.+@.+\.[a-z]+/: Invalid e-mailaddress" id="tb" />
				<button id="btn" label="check" onClick="checkDate()" />
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tb = ztl$engine.$f("tb")
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      runZscript(
        """
		void checkDate() {
			tb.getValue();
		}
		""")
      focus(tb.$n())
      blur(tb);
      waitResponse()
      verifyTrue(jq(tb).hasClass("z-textbox-invalid"));
    })
  }

  @Test
  def testConstraint2() = {
    var zscript = """$source.content"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tb = ztl$engine.$f("tb")
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      runZscript("""$serverZscript""")
      focus(tb.$n())
      click(btn);
      waitResponse()
      verifyTrue(jq(tb).hasClass("z-textbox-invalid"));
    })
  }
}



