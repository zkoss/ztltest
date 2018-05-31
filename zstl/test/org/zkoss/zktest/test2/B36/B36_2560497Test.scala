/* B36_2560497Test.java

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


class B36_2560497Test extends ZTL4ScalaTestCase {
  @Test
  def testformat() = {
    var zscript =
      """
		<zk>
			<vbox>
				Click the first button and click the second button.
				Then click the datebox popup.
				<separator />
				
				you should not see any error message
				
			</vbox>
			<datebox id="DTbox" />
			<button id="b1" label="hh:mm">
				<attribute name="onClick"><![CDATA[
				DTbox.setFormat("hh:mm");
			]]></attribute>
			</button>
			<button id="b2" label="ddMMyy">
				<attribute name="onClick"><![CDATA[
				DTbox.setFormat("ddMMyy");
			]]></attribute>
			</button>
		</zk>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val DTbox = ztl$engine.$f("DTbox")
    val b1 = ztl$engine.$f("b1")
    val b2 = ztl$engine.$f("b2")
    runZTL(zscript, () => {
      click(b1)
      click(b2)
      click(DTbox.$n("btn"))
      verifyFalse(jq(".z-error").exists())
    })
  }
}



