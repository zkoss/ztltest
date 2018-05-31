/* B50_ZK_599Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Nov 30 18:47:18 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{Tags, Widget}

/**
  * A test class for bug ZK-599
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-599.zul,B,E,Grid,Height")
class B50_ZK_599Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<zk>
			<div height="25px">Both grid below should has vertical scrollbar.</div>
				<zscript><![CDATA[
				Object[] o = new Object[50];
				]]></zscript>
				<window border="normal" title="" height="500px">
					<grid id="grid1" height="40%">
						<columns>
							<column label="Grid with height=40% no scroll bar" sort="auto(name)" />
						</columns>
						<rows>
							<row forEach="${o}">item ${forEachStatus.index}</row>
						</rows>
					</grid>
					<space spacing="15px"/>
					<grid id="grid2" height="200px">
						<columns>
							<column label="Grid with height=200px has scroll bar" sort="auto(name)" />
						</columns>
						<rows>
							<row forEach="${o}">item ${forEachStatus.index}</row>
						</rows>
					</grid>
				</window>
			</zk>

    """


    runZTL(zscript, () => {
      var grid1: Widget = engine.$f("grid1");
      var grid2: Widget = engine.$f("grid2");

      verifyTrue("grid 1 should have vertical scrollbar",
        Integer.parseInt(grid1.$n("body").get("scrollHeight")) >= Integer.parseInt(grid1.$n("body").get("clientHeight")));
      verifyTrue("grid 1 should have vertical scrollbar",
        Integer.parseInt(grid2.$n("body").get("scrollHeight")) >= Integer.parseInt(grid2.$n("body").get("clientHeight")));
    })
  }
}