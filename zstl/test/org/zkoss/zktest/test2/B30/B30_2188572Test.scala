/* B30_2188572Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_2188572Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
				There shall be two listbox (side-by-side)
				The first listbox has two items, and the second has three items.
				<hbox>
				<zscript>
				classes = new String[] {"College", "Graduate"};
				grades = new Object[] {
				new String[] {"Best", "Better"}, new String[] {"A++", "A+", "A"}
				};
				</zscript>
			
				<listbox width="200px" forEach="${classes}" >
					<listhead>
					<listheader label="${each}: ${forEachStatus.index}"/>
					</listhead>
					<listitem label="${forEachStatus.previous.current}: ${each}"
						forEach="${grades[forEachStatus.index]}"/>
					</listbox>
				</hbox>
			</zk>
		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      verifyEquals("College: 0", jq(".z-listbox:eq(0) .z-listheader").text())
      verifyEquals("College: Best", jq(".z-listbox:eq(0) .z-listcell:eq(0)").text())
      verifyEquals("College: Better", jq(".z-listbox:eq(0) .z-listcell:eq(1)").text())
      verifyEquals("", jq(".z-listbox:eq(0) .z-listcell:eq(2)").text())
      verifyEquals(2, jq(".z-listbox:eq(0) .z-listcell").length())
      verifyEquals("Graduate: 1", jq(".z-listbox:eq(1) .z-listheader").text())
      verifyEquals("Graduate: A++", jq(".z-listbox:eq(1) .z-listcell:eq(0)").text())
      verifyEquals("Graduate: A+", jq(".z-listbox:eq(1) .z-listcell:eq(1)").text())
      verifyEquals("Graduate: A", jq(".z-listbox:eq(1) .z-listcell:eq(2)").text())
      verifyEquals("", jq(".z-listbox:eq(1) .z-listcell:eq(3)").text())
      verifyEquals(3, jq(".z-listbox:eq(1) .z-listcell").length())
    })
  }
}



