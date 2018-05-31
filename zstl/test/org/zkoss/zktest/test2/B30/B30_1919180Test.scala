/* B30_1919180Test.scala

	Purpose:
		
	Description:
		
	History:
		Wed Oct 12 11:01:09 TST 2011, Created by jumperchen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  *
  * @author jumperchen
  */
@Tags(tags = "B30-1919180.zul,B,E,Grid")
class B30_1919180Test extends ZTL4ScalaTestCase {
  @Test
  def testCase() = {
    val zscript =
      """
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:ol>
					<n:li>Click add row(end)</n:li>
					<n:li>Click setColumnWidth1</n:li>
					<n:li>Click setColumnWidth2</n:li>
					<n:li>Click setColumnWidth3</n:li>
					<n:li>Do 2,3,4 again</n:li>
				</n:ol>
				<zscript><![CDATA[
          void addRow1(){
            Row row = new Row();
            row.setParent(rows);
            new Label("Label x").setParent(row);
            new Textbox().setParent(row);
            new Datebox().setParent(row);
          }
          ;
        ]]></zscript>
				<vbox>
					<div width="500px">
						<button label="add row(end)" onClick="addRow1()"/>
						<button label="setColumnWidth1" onClick='col1.setWidth("50px")'/>
						<button label="setColumnWidth2" onClick='col1.setWidth("150px")'/>
						<button label="setColumnWidth3" onClick='col1.setWidth("300px")'/>
					</div>
					<grid id="g1" width="400px">
						<columns id="cols" sizable="true">
							<column label="Type 50px" id="col1" align="center" width="50px"/>
							<column label="Content" id="col2" align="right"/>
							<column label="AA-BB" id="col3"/>
						</columns>
						<rows id="rows">
						</rows>
					</grid>
				</vbox>
			</zk>

		"""
    runZTL(zscript, () => {
      val g1 = engine $f "g1"

      val $col1 = jq("$col1")
      val $col2 = jq("$col2")
      val $col3 = jq("$col3")

      verifyEquals(50, $col1.outerWidth())

      var halfWidth = (jq(g1).innerWidth() - 50) / 2
      verifyEquals(halfWidth, $col2.outerWidth())
      verifyEquals(halfWidth, $col3.outerWidth())

      // add row
      click(jq("@button:eq(0)"))
      val btn1 = jq("@button:eq(1)")
      val btn2 = jq("@button:eq(2)")
      val btn3 = jq("@button:eq(3)")

      for ((btn, size) <- List((btn2, 150), (btn3, 300), (btn1, 50))) {
        click(btn)
        waitResponse(true)
        val $row1 = jq(jq(".z-row:eq(0)").children().get(0))
        val $row2 = jq(jq(".z-row:eq(0)").children().get(1))
        val $row3 = jq(jq(".z-row:eq(0)").children().get(2))
        verifyEquals(size, $col1.outerWidth())
        verifyEquals(size, $row1.outerWidth())

        halfWidth = (jq(g1).innerWidth() - size) / 2
        verifyEquals(halfWidth, $col2.outerWidth())
        verifyEquals(halfWidth, $row2.outerWidth())
        verifyEquals(halfWidth, $col3.outerWidth())
        verifyEquals(halfWidth, $row3.outerWidth())
      }
    })
  }
}
