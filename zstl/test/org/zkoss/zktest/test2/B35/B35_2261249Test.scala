/* B35_2261249Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

import java.util.ArrayList

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.{JQuery, Widget}
import org.zkoss.ztl._
import org.zkoss.ztl.unit._


class B35_2261249Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<window title="Grid" border="normal" width="100%">
				Click the context menu option of grid "Group", "Sort Ascending", and "Sort Descending". if no exception, it is fixed!
				 
				<zscript><![CDATA[//@IMPORT
					import org.zkoss.zktest.util.*;                  
				]]>
				Comparator asc = new RowLabelComparator(true),
					dsc = new RowLabelComparator(false);
				</zscript>
				<grid>
					<columns sizable="true" menupopup="auto">
						<column id="c1" label="Type" sortAscending="&#36;{asc}"
							sortDescending="&#36;{dsc}" onSelect='alert("xx")'/>
						<column id="c2" label="Content" />
					</columns>
				</grid>
			</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val c1 = ztl$engine.$f("c1")
    val c2 = ztl$engine.$f("c2")
    runZTL(zscript, () => {
      for (i <- 0 until 3) {
        mouseOver(c1)
        waitResponse()
        click(jq(".z-column").toWidget.$n("btn"))
        waitResponse()
        var items = jq(".z-menuitem")
        var displayItem = new ArrayList[JQuery]()
        for (j <- 0 until items.length) {
          var q: JQuery = items.eq(j)
          if (!q.css("display").equals("none")) {
            displayItem.add(q)
          }
        }
        click(displayItem.get(i))
        waitResponse()
        verifyFalse(jq(".z-window-modal").exists())
      }
    })
  }
}



