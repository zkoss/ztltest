/* B50_3071613Test.java

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


class B50_3071613Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<?page title="new page title" contentType="text/html;charset=UTF-8"?>
<zk>
	<zscript>
		import java.math.BigDecimal;
	</zscript>
	<html><![CDATA[
		Type <b>"12.123"</b>, then move focus out of textbox, It will show <b>"12.12"</b>.<br />
		Type <b>"12.125"</b>, then move focus out of textbox, It will show <b>"12.13"</b>.
	]]></html>
	<window title="new page title" border="normal">
		<decimalbox id="myDeci" />
		<zscript>
			myDeci.setRoundingMode(BigDecimal.ROUND_HALF_UP);
			myDeci.setFormat("0.##");
		</zscript>
	</window>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val myDeci = ztl$engine.$f("myDeci")
    runZTL(zscript, () => {
      typeKeys(jq("@decimalbox"), "12.123")
      waitResponse()
      verifyEquals("12.12", jq("@decimalbox").`val`())
      findElement(jq("@decimalbox")).clear()
      waitResponse()
      typeKeys(jq("@decimalbox"), "12.125")
      waitResponse()
      verifyEquals("12.13", jq("@decimalbox").`val`())
    })
  }
}



