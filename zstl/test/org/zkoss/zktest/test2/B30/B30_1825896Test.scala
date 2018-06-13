/* B30_1825896Test.java

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


class B30_1825896Test extends ZTL4ScalaTestCase {
  @Test
  def testResizeColumn() = {
    var zscript =
      """
				<zk>
					<vbox>
						1.In IE only, Resize the column of datebox as small as possible, and you should not see the button of datebox.
						<grid id="g1" width="400px">
							<columns id="cols" sizable="true">
								<column label="A" id="col1" align="center" width="50px"/>
								<column label="B" id="col2" align="right"/>
								<column label="C" id="col3"/>
								<column label="D" id="col4"/>
							</columns>
							<rows id="rows">
								<row>
								Label ABCDEFG<datebox/>Label EFGHIJK<datebox/>
								
								</row>
							</rows>
						</grid>
					</vbox>
				</zk>
			 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val g1 = ztl$engine.$f("g1")
    val cols = ztl$engine.$f("cols")
    val col1 = ztl$engine.$f("col1")
    val col2 = ztl$engine.$f("col2")
    val col3 = ztl$engine.$f("col3")
    val col4 = ztl$engine.$f("col4")
    val rows = ztl$engine.$f("rows")
    runZTL(zscript, () => {
      var colWidth = jq(".z-column:eq(3)").width()
      dragdropTo(jq(".z-column:eq(3)"), (colWidth - 2) + ",5", (colWidth / 2) + ",5")
      verifyTrue(jq(".z-column:eq(3)").find(".z-datebox").innerWidth() < jq(".z-column:eq(3)").outerWidth())
    })
  }
}



