/* B30_1822566Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1822566Test extends ZTL4ScalaTestCase {
  @Test
  def testColumnSize() = {
    var zscript =
      """
<zk>
	<zscript>
	void addRow1(){
		Row row = new Row();
		row.setParent(rows);
		new Label("Label x").setParent(row);
		new Textbox().setParent(row);
		new Datebox().setParent(row);
	};
	
	</zscript>
             1. Click set button to set Cloumn Width 
             <separator/>
	If Column set Width doesn't work correctly  try click <button label="fixedLayout=&quot;true&quot;" onClick="g1.fixedLayout=true"/> then run 1 again
             <separator/>


	<vbox>
		<hbox width="500px">
			<button id="btn1" label="setColumnWidth1" onClick='col1.setWidth("20px")'/>
			<button id="btn2" label="setColumnWidth2" onClick='col1.setWidth("100px")'/>
			<button id="btn3" label="setColumnWidth3" onClick='col1.setWidth("200px")'/>
		</hbox>
		<grid id="g1" width="400px" height="100px">
			<columns id="cols">
				<column label="Type 50px" id="col1"  align="center" width="50px"/>
				<column label="Content" id="col2" align="right"/>
				<column label="AA-BB" id="col3"/>
			</columns>
			<rows id="rows">
			<row><textbox/><textbox/><textbox/>
			</row>
			</rows>
		</grid>
	</vbox>
</zk>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val btn1 = ztl$engine.$f("btn1")
    val btn2 = ztl$engine.$f("btn2")
    val btn3 = ztl$engine.$f("btn3")
    val g1 = ztl$engine.$f("g1")
    val cols = ztl$engine.$f("cols")
    val col1 = ztl$engine.$f("col1")
    val col2 = ztl$engine.$f("col2")
    val col3 = ztl$engine.$f("col3")
    val rows = ztl$engine.$f("rows")
    runZTL(zscript, () => {
      var jcol1 = jq(col1.$n())
      var jrow1 = jq(jq("@row").toWidget().firstChild().$n("chdextr"))
      // growing
      click(btn1)
      waitResponse()
      verifyEquals(20, jcol1.outerWidth())
      verifyEquals(20, jrow1.outerWidth())
      click(btn2)
      waitResponse()
      verifyEquals(100, jcol1.outerWidth())
      verifyEquals(100, jrow1.outerWidth())
      click(btn3)
      waitResponse()
      verifyEquals(200, jcol1.outerWidth())
      verifyEquals(200, jrow1.outerWidth())
      // shrinking
      click(btn2)
      waitResponse()
      verifyEquals(100, jcol1.outerWidth())
      verifyEquals(100, jrow1.outerWidth())
      click(btn1)
      waitResponse()
      verifyEquals(20, jcol1.outerWidth())
      verifyEquals(20, jrow1.outerWidth())
    })
  }
}



