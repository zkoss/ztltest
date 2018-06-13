/* B36_2777216Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2777216Test extends ZTL4ScalaTestCase {
  @Test
  def testpaging() = {
    var zscript =
      """
			<window id="wnditemlist" title="List Item" mode="overlapped">
				Please add 5 items, then the paging bar in  IE7 shouldn't appear weird
				<grid id="itemlist" mold="paging" pageSize="4">
					<columns>
						<column label="Kode" />
			
					</columns>
					<rows id="rows"/>
				</grid>
				<button label="addItem">
					<attribute name="onClick"><![CDATA[
						Row row = new Row();
						new Label("TEST TEST TEST").setParent(row);
						row.setParent(rows);
					]]></attribute>
				</button>
			</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val wnditemlist = ztl$engine.$f("wnditemlist")
    val itemlist = ztl$engine.$f("itemlist")
    val rows = ztl$engine.$f("rows")
    runZTL(zscript, () => {
      for (i <- 0 until 5) {
        click(jq("@button"))
        waitResponse()
      }
      verifyEquals(jq(itemlist.$n("body")).outerWidth(), jq(itemlist.$n("pgib")).outerWidth())
    })
  }
}



