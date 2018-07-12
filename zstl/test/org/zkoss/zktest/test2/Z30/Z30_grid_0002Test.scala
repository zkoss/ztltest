/* Z30_grid_0002Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.Z30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class Z30_grid_0002Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    var zscript =
      """
			<vbox>
				<label id="lab"/>
				
				<separator/>
				This testcase test the click event in grid column, column1 handle onClick, column2 handle rightClick, column3 handle double click, 
				column4 handle click and rightclick and doublelclick
				<separator/>
				it also test the resize of column
				<button label="invalidate" onClick="g.invalidate()"/>
				<button label="alert" onClick='alert("Try")'/>
				<label id="label"/>
				<grid id="g" width="500px">
					<columns id="cs" sizable="true" onColSize='lab.value=new java.util.Date()+"col size change:"+event+",colindex:"+event.getColIndex()'>
						<column label="AA" id="col1" onClick='label.value = "Click on column 1";'/>
						<column label="BB" id="col2" onRightClick='label.value = "onRightClick on column 2";'/>
						<column label="CC" id="col3" onDoubleClick='label.value = "onDoubleClick on column 3";'/>
						<column label="DD" id="col4" onClick='label.value = "Click on column 4"' onRightClick='label.value = "onRightClick on column 4";' onDoubleClick='label.value = "onDoubleClick on column 4";'/>
						<column label="EE" id="col5" />
					</columns>
					<rows>
						<row>
							<label value="AA01" />
							<label value="BB01" />
							<label value="CC01" />
							<label value="DD01" />
							<label value="EE01" />
						</row>
						<row>
							<label value="AA02" />
							<label value="BB02" />
							<label value="CC02" />
							<label value="DD02" />
							<label value="EE02" />
						</row>
					</rows>
				</grid>
			</vbox>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val lab = ztl$engine.$f("lab")
    val label = ztl$engine.$f("label")
    val g = ztl$engine.$f("g")
    val cs = ztl$engine.$f("cs")
    val col1 = ztl$engine.$f("col1")
    val col2 = ztl$engine.$f("col2")
    val col3 = ztl$engine.$f("col3")
    val col4 = ztl$engine.$f("col4")
    val col5 = ztl$engine.$f("col5")
    runZTL(zscript, () => {
      click(col1)
      waitResponse()
      verifyEquals("Click on column 1", label.attr("value"))
      contextMenu(col2)
      waitResponse()
      verifyEquals("onRightClick on column 2", label.attr("value"))
      doubleClick(col3)
      waitResponse()
      verifyEquals("onDoubleClick on column 3", label.attr("value"))
      click(col4)
      waitResponse()
      verifyEquals("Click on column 4", label.attr("value"))
      contextMenu(col4)
      waitResponse()
      verifyEquals("onRightClick on column 4", label.attr("value"))
      doubleClick(col4)
      waitResponse()
      verifyEquals("onDoubleClick on column 4", label.attr("value"))
    })
  }
}



