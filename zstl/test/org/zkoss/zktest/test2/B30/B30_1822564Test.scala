/* B30_1822564Test.java

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
import org.zkoss.ztl.unit.Widget


class B30_1822564Test extends ZTL4ScalaTestCase {
  @Test
  def testDragdrop() = {
    var zscript =
      """
<zk>
Column should can resize by drag when start with no row.
It still doesn't work even add row after creation.
	<zscript>
	void addRow1(){
		Row row = new Row();
		row.setParent(rows);
		new Label("Label x").setParent(row);
		new Textbox().setParent(row);
		new Datebox().setParent(row);
	};

	</zscript>
	<vbox>
		<div width="500px">
			<button id="btn1" label="add row(end)" onClick="addRow1()"/>
			<button id="btn2" label="setColumnWidth1" onClick='col1.setWidth("20px")'/>
			<button id="btn3" label="setColumnWidth2" onClick='col1.setWidth("100px")'/>
			<button id="btn4" label="setColumnWidth3" onClick='col1.setWidth("200px")'/>
		</div>
		<grid id="g1" width="400px" sizedByContent="false">
			<columns id="cols" sizable="true">
				<column label="Type 50px" id="col1"  align="center" width="50px" style="position:relative;"/>
				<column label="Content" id="col2" align="right"  style="position:relative;"/>
				<column label="AA-BB" id="col3"  style="position:relative;"/>
			</columns>
			<rows id="rows">
			</rows>
		</grid>
	</vbox>
</zk>
		 """
    val ztl$engine = engine()
    val btn1 = ztl$engine.$f("btn1")
    val btn2 = ztl$engine.$f("btn2")
    val btn3 = ztl$engine.$f("btn3")
    val btn4 = ztl$engine.$f("btn4")
    val g1 = ztl$engine.$f("g1")
    val cols = ztl$engine.$f("cols")
    val col1 = ztl$engine.$f("col1")
    val col2 = ztl$engine.$f("col2")
    val col3 = ztl$engine.$f("col3")
    val rows = ztl$engine.$f("rows")
    runZTL(zscript, () => {
      var w = jq(col1).outerWidth()
      dragdropTo(col1, w + ",0", w + 10 + ",0")
      w += 10
      verifyTrue(w <= jq(col1).outerWidth())
      sleep(1000) // for ios's slow response time (waitResponse is not enough)
      click(btn1)
      waitResponse()
      dragdropTo(col1, w + ",0", w + 10 + ",0")
      w += 10
      verifyTrue(w <= jq(col1).outerWidth())
      // the following is the rough test, because the grid is sized by content.
      click(btn2)
      waitResponse()
      verifyTrue(20 <= jq(col1).outerWidth())
      verifyEquals(jq(col1).outerWidth(), jq(jq("@row").toWidget().firstChild().$n("chdextr")).outerWidth())
      click(btn3)
      waitResponse()
      verifyTrue(100 >= jq(col1).outerWidth())
      verifyEquals(jq(col1).outerWidth(), jq(jq("@row").toWidget().firstChild().$n("chdextr")).outerWidth())
      click(btn4)
      waitResponse()
      verifyTrue(200 >= jq(col1).outerWidth())
      verifyEquals(jq(col1).outerWidth(), jq(jq("@row").toWidget().firstChild().$n("chdextr")).outerWidth())
    })
  }
}



