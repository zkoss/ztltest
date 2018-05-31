/* B50_2911379Test.java

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
import org.zkoss.ztl.Widget


class B50_2911379Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
			<zk>
			You should see each label is the same as that of input element.
			<vbox>
			<hbox>
			<doublebox id="percent" format="0.00%;(0.00%)" width="200px"/> = 99.00%
			</hbox>
			<hbox>
			<doublebox id="value" format="#,##0.##;(#,##0.##)" width="200px"/> = (200,000) 
			</hbox>
			<hbox>
			<doublebox id="value2" format="#,##0.00;($#,##0.00)" width="200px"/> = ($200,000.00) 
			</hbox>
			<hbox>
			<decimalbox id="decimal" format="##0.00;(#,##0.00)" width="200px"/> = (1,234,567,890.00)
			</hbox>
			</vbox>
			
			<zscript>
			decimal.value = new java.math.BigDecimal(-1234567890.0);
			</zscript>
			<zscript>
			percent.value = 0.99;
			value.value = -200000;
			percent2.value = 0.99;
			value2.value = -200000;
			</zscript>
			
			</zk>

			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val percent = ztl$engine.$f("percent")
    val value = ztl$engine.$f("value")
    val value2 = ztl$engine.$f("value2")
    val decimal = ztl$engine.$f("decimal")
    runZTL(zscript, () => {
      verifyEquals("99.00%", jq(percent).`val`());
      verifyEquals("(200,000)", jq(value).`val`());
      verifyEquals("($200,000.00)", jq(value2).`val`());
      verifyEquals("(1,234,567,890.00)", jq(decimal).`val`())
    })
  }
}



