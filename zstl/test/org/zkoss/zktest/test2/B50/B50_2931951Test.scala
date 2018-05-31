/* B50_2931951Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_2931951Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<div>
Please click addRow button, than you should see a paging toolbar.
	<grid id="grid" mold="paging" height="60px">
		<columns>
			<column label="column1" align="Center" />
			<column label="column2" align="Center" />
			<column label="column3" align="Center" />
			<column label="column4" align="Center" />
			<column label="column5" align="Center" />
			<column label="column6" align="Center" />
		</columns>
		<rows id="rows">
			<row forEach="0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9">
				<label value="column1" />
				<label value="column2" />
				<label value="column3" />
				<label value="column4" />
				<label value="column5" />
				<label value="column6" />
			</row>
		</rows>
	</grid>
	<button label="addRow">
		<attribute name="onClick">
			Row rw = new Row(); rw.setParent(rows); 
			new Label("Column1").setParent(rw); 
			new Label("Column1").setParent(rw); 
			new Label("Column1").setParent(rw); 
			new Label("Column1").setParent(rw); 
			new Label("Column1").setParent(rw); 
			new Label("Column1").setParent(rw); 
		</attribute>
	</button>
</div>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val grid = ztl$engine.$f("grid")
    val rows = ztl$engine.$f("rows")
    runZTL(zscript, () => {
      var paging = grid.getChild("paging")
      verifyFalse(isVisible(paging))
      click(jq("@button"))
      waitResponse()
      click(jq("@button"))
      waitResponse()
      //why not work?
      //verifyTrue(jq(".z-paging-input").exists())
      verifyTrue(isVisible(paging))
    })
  }
}



