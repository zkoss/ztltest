/* B50_3161667Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3161667Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			

<zk xmlns:w="http://www.zkoss.org/2005/zk/client">
	<script>
		function checkEq(self) {
			var dbx = self.previousSibling,
				lb = dbx.previousSibling,
				eq = lb.getValue() == dbx.getText();
			self.setValue(eq ? 'Yes' : 'No');
			self.setStyle('color:' + (eq ? 'green' : 'red'));
		}
	</script>
	<html><![CDATA[
		<ol>
			<li>If any row shows "No" in Matched column, there is a bug.</li>
		</ol>
	]]></html>
	<grid>
		<columns>
			<column label="Value" width="200px" />
			<column label="Format" width="100px" />
			<column label="Expected Text" width="200px" />
			<column label="Actual Text" width="200px" />
			<column label="Matched" width="50px" />
		</columns>
		<rows>
			<row>
				<label value="0.000023" />
				<label value="##.###" />
				<label value="0" />
				<doublebox hflex="1" value="0.000023" format="##.###" />
				<label w:onBind="checkEq(this)" />
			</row>
			<row>
				<label value="0.000023" />
				<label value="##.######" />
				<label value="0.000023" />
				<doublebox hflex="1" value="0.000023" format="##.######" />
				<label w:onBind="checkEq(this)" />
			</row>
			<row>
				<label value="0.000023" />
				<label value="N/A" />
				<label value="0.000023" />
				<doublebox hflex="1" value="0.000023" />
				<label w:onBind="checkEq(this)" />
			</row>
			<row>
				<label value="450000000001" />
				<label value="##.###" />
				<label value="450000000001" />
				<doublebox hflex="1" value="450000000001" format="##.###" />
				<label w:onBind="checkEq(this)" />
			</row>
			<row>
				<label value="0.00000023" />
				<label value="##.###" />
				<label value="0" />
				<doublebox hflex="1" value="0.00000023" format="##.###" />
				<label w:onBind="checkEq(this)" />
			</row>
			<row>
				<label value="0.00000023" />
				<label value="##.########" />
				<label value="0.00000023" />
				<doublebox hflex="1" value="0.00000023" format="##.########" />
				<label w:onBind="checkEq(this)" />
			</row>
			<row>
				<label value="0.00000023" />
				<label value="N/A" />
				<label value="2.3e-7" />
				<doublebox hflex="1" value="0.00000023" />
				<label w:onBind="checkEq(this)" />
			</row>
			<row>
				<label value="-0.00000023" />
				<label value="##.###" />
				<label value="0" />
				<doublebox hflex="1" value="-0.00000023" format="##.###" />
				<label w:onBind="checkEq(this)" />
			</row>
			<row>
				<label value="-0.00000023" />
				<label value="##.########" />
				<label value="-0.00000023" />
				<doublebox hflex="1" value="-0.00000023" format="##.########" />
				<label w:onBind="checkEq(this)" />
			</row>
			<row>
				<label value="-0.00000023" />
				<label value="N/A" />
				<label value="-2.3e-7" />
				<doublebox hflex="1" value="-0.00000023" />
				<label w:onBind="checkEq(this)" />
			</row>
			<row>
				<label value="4500000000000000000000" />
				<label value="##.###" />
				<label value="4500000000000000000000" />
				<doublebox hflex="1" value="4500000000000000000000" format="##.###" />
				<label w:onBind="checkEq(this)" />
			</row>
			<row>
				<label value="4500000000000000000000" />
				<label value="N/A" />
				<label value="4.5e+21" />
				<doublebox hflex="1" value="4500000000000000000000" />
				<label w:onBind="checkEq(this)" />
			</row>
			<row>
				<label value="-4500000000000000000000" />
				<label value="##.###" />
				<label value="-4500000000000000000000" />
				<doublebox hflex="1" value="-4500000000000000000000" format="##.###" />
				<label w:onBind="checkEq(this)" />
			</row>
			<row>
				<label value="-4500000000000000000000" />
				<label value="N/A" />
				<label value="-4.5e+21" />
				<doublebox hflex="1" value="-4500000000000000000000" />
				<label w:onBind="checkEq(this)" />
			</row>
		</rows>
	</grid>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      for (i <- 0 until 14) {
        verifyEquals("Yes", jq("@row:eq(" + i + ") @label:eq(3)").text())
      }
    })
  }
}



