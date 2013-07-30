/* B30_1920706Test.scala

	Purpose:
		
	Description:
		
	History:
		Wed Oct 12 11:17:39 TST 2011, Created by jumperchen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;
import org.junit.Test

/**
 *
 * @author jumperchen
 */
@Tags(tags = "B30-1920706.zul,B,E,Grid,Opera")
class B30_1920706Test extends ZTL4ScalaTestCase {
	@Test
	def testCase() = {
		val zscript = """
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>[Set width of grid column doesn't work correctly (Opera only)]</n:p>
				<zscript><![CDATA[
void addRow1(){
Row row = new Row();
row.setParent(rows);
new Label("Label x").setParent(row);
new Textbox().setParent(row);
new Datebox().setParent(row);
};
]]></zscript>
				Column set Width doesn't work correctly
				<vbox>
					<div width="500px">
						<button label="setColumnWidth1" onClick='col1.setWidth("20px")'/>
						<button label="setColumnWidth2" onClick='col1.setWidth("100px")'/>
						<button label="setColumnWidth3" onClick='col1.setWidth("200px")'/>
					</div>
					<grid id="g1" width="400px">
						<columns id="cols">
							<column label="Type 50px" id="col1" align="center" width="50px"/>
							<column label="Content" id="col2" align="right"/>
							<column label="AA-BB" id="col3"/>
						</columns>
						<rows id="rows">
							<row>
								<textbox/><textbox/><textbox/>
							</row>
						</rows>
					</grid>
				</vbox>
			</zk>
		""";
		runZTL(zscript, () => {
			val g1 = engine $f "g1"
			val $col1 = jq("$col1")
			val $col2 = jq("$col2")
			val $col3 = jq("$col3")

			verifyEquals(50, $col1.outerWidth())

			var halfWidth = (jq(g1).innerWidth() - 50) / 2
			verifyEquals(halfWidth, $col2.outerWidth())
			verifyEquals(halfWidth, $col3.outerWidth())

			val btn1 = jq("@button:eq(0)")
			val btn2 = jq("@button:eq(1)")
			val btn3 = jq("@button:eq(2)")

			for ((btn, size) <- List((btn1, 20), (btn2, 100), (btn3, 200))) {
				click(btn)
				waitResponse
				verifyEquals(size, $col1.outerWidth())

				halfWidth = (jq(g1).innerWidth() - size) / 2
				verifyEquals(halfWidth, $col2.outerWidth())
				verifyEquals(halfWidth, $col3.outerWidth())
			}
		})
	}
}
