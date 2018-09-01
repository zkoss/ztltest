/* B30_1886788_1Test.java

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


class B30_1886788_1Test extends ZTL4ScalaTestCase {
  @Test
  def testWidth() = {
    var zscript =
      """
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>Grid rows not follow columns's widths when it has the auxhead component.(This example also apply to listbox)</n:p>
				<listbox>
					<auxhead>
						<auxheader label="Selecteds Items (Listbox)" colspan="9"
							align="center" />
					</auxhead>
					<listhead>
						<listheader id="header0" label="70px" width="70px" />
						<listheader id="header1" label="75px" width="75px" />
						<listheader id="header2" label="75px" width="75px" />
						<listheader id="header3" label="150px" width="150px" />
						<listheader id="header4" label="107px" width="107px" />
						<listheader id="header5" label="120px" width="120px" />
						<listheader id="header6" label="115px" width="115px" />
						<listheader id="header7" label="50px" width="50px" />
						<listheader id="header8" label="80px" width="90px" />
					</listhead>
					<listitem>
						<listcell id="cell0" label="1" />
						<listcell id="cell1" label="2" />
						<listcell id="cell2" label="3" />
						<listcell id="cell3" label="4" />
						<listcell id="cell4" label="5" />
						<listcell id="cell5" label="6" />
						<listcell id="cell6" label="7" />
						<listcell id="cell7" label="8" />
						<listcell id="cell8" label="9" />
					</listitem>
				</listbox>
		</zk>
		"""
    val ztl$engine = engine()
    val header0 = ztl$engine.$f("header0")
    val header1 = ztl$engine.$f("header1")
    val header2 = ztl$engine.$f("header2")
    val header3 = ztl$engine.$f("header3")
    val header4 = ztl$engine.$f("header4")
    val header5 = ztl$engine.$f("header5")
    val header6 = ztl$engine.$f("header6")
    val header7 = ztl$engine.$f("header7")
    val header8 = ztl$engine.$f("header8")
    val cell0 = ztl$engine.$f("cell0")
    val cell1 = ztl$engine.$f("cell1")
    val cell2 = ztl$engine.$f("cell2")
    val cell3 = ztl$engine.$f("cell3")
    val cell4 = ztl$engine.$f("cell4")
    val cell5 = ztl$engine.$f("cell5")
    val cell6 = ztl$engine.$f("cell6")
    val cell7 = ztl$engine.$f("cell7")
    val cell8 = ztl$engine.$f("cell8")
    runZTL(zscript, () => {
      for (i <- 0 until 9) {
        verifyTolerant(jq("$header" + i).width(), jq("$cell" + i).width(), 5)
      }
    })
  }
}



