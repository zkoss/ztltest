/* B50_3035230Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3035230Test extends ZTL4ScalaTestCase {
  @Test
  def testColumnSize() = {
    var zscript =
      """
<zk>
	<zscript><![CDATA[
	String[] datas = new String[50];
]]></zscript>
	<html><![CDATA[ <h1>Grid sizedByContent</h1> ]]></html>
	<hbox>
		<vbox>
			<label value="grid has 300px width" />
			<grid sizedByContent="true" height="200px" width="300px">
				<columns>
					<column id="c1" label="col 1" />
					<column id="c2" label="col 2" />
				</columns>
				<rows>
					<row forEach="${datas}">
						<label value="item" />
						<label value="item" />
					</row>
				</rows>
			</grid>
		</vbox>
		<separator orient="vertical" />
		<vbox>
			<label value="grid without width in a div with 300px width" />
			<div width="300px">
				<grid sizedByContent="true" height="200px">
					<columns>
						<column id="c3" label="col 1" />
						<column id="c4" label="col 2" />
					</columns>
					<rows>
						<row forEach="${datas}">
							<label value="item" />
							<label value="item" />
						</row>
					</rows>
				</grid>
			</div>
		</vbox>
	</hbox>
</zk>
		"""
    val ztl$engine = engine()
    val c1 = ztl$engine.$f("c1")
    val c2 = ztl$engine.$f("c2")
    val c3 = ztl$engine.$f("c3")
    val c4 = ztl$engine.$f("c4")
    runZTL(zscript, () => {
      verifyTrue(getEval("Math.abs(" + jq(c1).outerWidth() + "-" + jq(c2).outerWidth() + ") <= 3"))
      verifyTrue(getEval("Math.abs(" + jq(c3).outerWidth() + "-" + jq(c4).outerWidth() + ") <= 3"))
    })
  }
}



