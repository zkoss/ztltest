/* B30_1876391Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1876391Test extends ZTL4ScalaTestCase {
  @Test
  def testSelection() = {
    var zscript =
      """
			<window>
				Click the test button and you shall see "OK" being appended.
				<button id="ok" label="test">
					<attribute name="onClick"><![CDATA[
				cb.setText("BB");
				Comboitem ci = cb.getSelectedItem();
				new Label(ci != null && "BB".equals(ci.label) ? "OK": "Failed "+ci)
					.setParent(self.parent);
					]]></attribute>
				</button>
				<combobox id="cb">
					<comboitem label="AA"/>
					<comboitem label="BB"/>
					<comboitem label="CC"/>
				</combobox>
			</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val ok = ztl$engine.$f("ok")
    val cb = ztl$engine.$f("cb")
    runZTL(zscript, () => {
      click(cb.$n("btn"))
      click(ok)
      waitResponse()
      verifyEquals("BB", jq(jq(".z-combobox").toWidget().$n("real")).`val`())
      verifyEquals("OK", jq(".z-label:eq(1)").text())
    })
  }
}



